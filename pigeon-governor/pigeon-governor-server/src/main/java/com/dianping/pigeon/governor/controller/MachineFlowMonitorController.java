package com.dianping.pigeon.governor.controller;

import com.dianping.cat.consumer.transaction.model.entity.TransactionReport;
import com.dianping.pigeon.governor.bean.FlowMonitorBean.ServerMachines;
import com.dianping.pigeon.governor.bean.FlowMonitorBean.ServerMethodDataTableBean;
import com.dianping.pigeon.governor.bean.FlowMonitorBean.ServerSummaryGraphBean;
import com.dianping.pigeon.governor.bean.FlowMonitorBean.method.MethodDistributedGraphBean;
import com.dianping.pigeon.governor.service.CatReportService;
import com.dianping.pigeon.governor.util.GsonUtils;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by shihuashen on 16/6/29.
 */
@Controller
public class MachineFlowMonitorController extends BaseController{
    @Autowired
    private CatReportService catReportService;
    @RequestMapping(value = {"/flowMonitor/test"},method = RequestMethod.GET)
    public void test1(HttpServletRequest request, HttpServletResponse response){
    }

    @RequestMapping(value={"/shs/flowMonitor"},method = RequestMethod.GET)
    public String entrance(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        commonnav(modelMap,request);
        String projectName = "ts-account-service";
        String date = "2016070610";
        TransactionReport report  = catReportService.getCatTransactionReport(projectName,date,"All","PigeonService");
        modelMap.put("summaryGraph",new ServerSummaryGraphBean(report));
        modelMap.put("serverMachines",new ServerMachines(report));
        modelMap.put("serverSummaryData",new ServerMethodDataTableBean(report));
        return "/flowMonitor/main";
    }

    @RequestMapping(value={"/groupConfig"},method = RequestMethod.GET)
    public String testConfig(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        return "/config/GroupConfig";
    }

    @RequestMapping(value = {"/shs/flow/test"},method = RequestMethod.GET)
    public String testFlow(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        return "/flowMonitor/material";
    }
    @RequestMapping(value = {"/flowMonitor/methodDetail"},method = RequestMethod.POST)
    public String  getMethodDetail(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        String projectName = request.getParameter("projectName");
        String ip = request.getParameter("ip");
        String time = request.getParameter("time");
        String nameId = request.getParameter("nameId");
        MethodDistributedGraphBean bean = catReportService.getMethodDistributedGraph(projectName,time,nameId);
        modelMap.put("name",bean.getIpName());
        modelMap.put("data",bean.getData());
        return "/flowMonitor/server/modalContent";
    }
}
