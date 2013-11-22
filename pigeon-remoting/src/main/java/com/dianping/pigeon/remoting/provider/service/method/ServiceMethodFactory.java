/**
 * Dianping.com Inc.
 * Copyright (c) 2003-2013 All Rights Reserved.
 */
package com.dianping.pigeon.remoting.provider.service.method;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.dianping.dpsf.exception.ServiceException;
import com.dianping.pigeon.component.invocation.InvocationRequest;
import com.dianping.pigeon.monitor.LoggerLoader;
import com.dianping.pigeon.remoting.provider.component.ProviderConfig;
import com.dianping.pigeon.remoting.provider.process.filter.ContextTransferProcessFilter;
import com.dianping.pigeon.remoting.provider.service.ServiceProviderFactory;

public final class ServiceMethodFactory {

	private static final Logger logger = LoggerLoader.getLogger(ContextTransferProcessFilter.class);

	private static Map<String, ServiceMethodCache> methods = new ConcurrentHashMap<String, ServiceMethodCache>();

	private static Set<String> ingoreMethods = new HashSet<String>();

	static {
		Method[] objectMethodArray = Object.class.getMethods();
		for (Method method : objectMethodArray) {
			ingoreMethods.add(method.getName());
		}

		Method[] classMethodArray = Class.class.getMethods();
		for (Method method : classMethodArray) {
			ingoreMethods.add(method.getName());
		}
	}

	public static ServiceMethod getMethod(InvocationRequest request) throws ServiceException {
		String serviceName = request.getServiceName();
		String methodName = request.getMethodName();
		String[] paramClassNames = request.getParamClassName();
		String version = request.getVersion();
		String newUrl = ServiceProviderFactory.getServiceUrlWithVersion(serviceName, version);
		if(logger.isDebugEnabled()) {
			logger.debug("get method for service url:" + request);
		}
		ServiceMethodCache serviceMethodCache = getServiceMethodCache(newUrl);
		if (serviceMethodCache == null) {
			logger.warn("no service found for version:" + version + ", use the default version of service:"
					+ serviceName);
			serviceMethodCache = getServiceMethodCache(serviceName);
		}
		if (serviceMethodCache == null) {
			throw new ServiceException("cannot find serivce for request:" + request);
		}
		return serviceMethodCache.getMethod(methodName, new ServiceParam(paramClassNames));
	}

	private static ServiceMethodCache getServiceMethodCache(String url) throws ServiceException {
		ServiceMethodCache serviceMethodCache = methods.get(url);
		if (serviceMethodCache == null) {
			Map<String, ProviderConfig> services = ServiceProviderFactory.getAllServices();
			ProviderConfig providerConfig = services.get(url);
			if (providerConfig != null) {
				Object service = providerConfig.getService();
				Method[] methodArray = service.getClass().getMethods();
				serviceMethodCache = new ServiceMethodCache(url, service);
				for (Method method : methodArray) {
					if (!ingoreMethods.contains(method.getName())) {
						method.setAccessible(true);
						serviceMethodCache.addMethod(method.getName(), new ServiceMethod(service, method));
					}
				}
				methods.put(url, serviceMethodCache);
			}
		}
		return serviceMethodCache;
	}

}