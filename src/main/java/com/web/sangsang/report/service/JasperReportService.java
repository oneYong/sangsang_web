package com.web.sangsang.report.service;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by WYKIM on 2017-01-09.
 */
@Service
public class JasperReportService {
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;

    public void setJasperReport(String classPath){
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            File file = classPathResource.getFile();

            jasperReport = (JasperReport) JRLoader.loadObject(file);
        }catch(Exception e){
        }
    }


}
