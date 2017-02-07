package com.web.sangsang.report.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-09.
 */
@Service
public class JasperReportService {
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;

    private JRDataSource jrDataSource;
    private Map<String, Object> params;

    private final String PDF_CONTENT_TYPE = "application/pdf; charset=UTF-8";

    public JasperReportService params(Map<String, Object> params){
        this.params = params;

        return this;
    }

    public JasperReportService jrDataSource(JRDataSource jrDataSource){
        this.jrDataSource = jrDataSource;
        return this;
    }

    public void jasperPrint(String classPath){
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            File file = classPathResource.getFile();

            this.jasperReport = (JasperReport) JRLoader.loadObject(file);
            this.jasperPrint = JasperFillManager.fillReport(this.jasperReport, this.params, this.jrDataSource);
        }catch(Exception e){
        }
    }

    public ByteArrayOutputStream getExportReportToPdfStream(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            JasperExportManager.exportReportToPdfStream(this.jasperPrint, byteArrayOutputStream);
        }catch(Exception e){

        }
        return byteArrayOutputStream;
    }

    public void exportReportToPdfStream(String fileName, HttpServletResponse response){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "filename=\"" + fileName+ ".pdf\"");
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
