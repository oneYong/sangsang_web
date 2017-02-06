package com.web.sangsang.report.web;

import com.web.sangsang.cmm.entity.SsGuide;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
    private final String REPORT_PATH = "/WEB-INF/views/report/";
    private final String PDF_CONTENT_TYPE = "application/pdf; charset=UTF-8";

    @RequestMapping(value="/document1", method = RequestMethod.GET)
    public void document1(HttpServletRequest request, HttpServletResponse response){



        JasperReport report = null;
        JasperPrint jasperPrint = null;

        List<SsGuide> dataSourceList = new ArrayList<>();
        SsGuide ssGuide = new SsGuide();
        ssGuide.setContents("nice");
        dataSourceList.add(ssGuide);
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSourceList);
        try {
            ClassPathResource classPathResource = new ClassPathResource("/templates/report/document1.jasper");
            File file = classPathResource.getFile();

            report = (JasperReport) JRLoader.loadObject(file);
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("path", "/hello");
            jasperPrint = JasperFillManager.fillReport(report, parameterMap,jrDataSource);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "filename=\"" + "document1" + ".pdf\"");
            response.setContentType(PDF_CONTENT_TYPE);
            response.setContentLength(baos.size());
            try (ServletOutputStream sos = response.getOutputStream()) {
                baos.writeTo(sos);
                sos.flush();
                baos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
