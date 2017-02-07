package com.web.sangsang.report.web;

import com.web.sangsang.cmm.entity.SsGuide;
import com.web.sangsang.report.service.JasperReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimwonyong on 2017. 1. 25..
 */
@Controller
@RequestMapping(value="/web/report")
public class ReportController {

    @Autowired
    private JasperReportService jasperReportService;

    @RequestMapping(value="/document1", method = RequestMethod.GET)
    public void document1(HttpServletRequest request, HttpServletResponse response){


        List<SsGuide> dataSourceList = new ArrayList<>();
        SsGuide ssGuide = new SsGuide();
        ssGuide.setContents("nice");
        dataSourceList.add(ssGuide);
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSourceList);

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("path", "/hello");

        // jasper set ...
        jasperReportService.params(parameterMap)
                .jrDataSource(jrDataSource)
                .jasperPrint("/templates/report/document1.jasper");

        jasperReportService.exportReportToPdfStream("document1",response);

    }

}
