package com.web.sangsang.cmm.api;


import com.web.sangsang.SangsangWebApplication;
import com.web.sangsang.cmm.entity.SsResource;
import com.web.sangsang.cmm.entity.annotation.Table;
import com.web.sangsang.mapper.CmmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by kimwonyong on 2017. 1. 25..
 */
@Controller
@RequestMapping(value="/api/resource")
public class ResourceController {
    @Autowired
    private CmmMapper cmmMapper;
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value="/{targetName}/{targetId}", method = RequestMethod.GET)
    public void toImage(HttpServletRequest request, HttpServletResponse response
                        ,@PathVariable("targetName") String targetName
                        ,@PathVariable("targetId") String targetId
                        ,@RequestParam(value = "type",required = false) String type
                        ,@RequestParam(value = "maxWidth",required = false) Integer maxWidth
                        ,@RequestParam(value = "maxHeight",required = false) Integer maxHeight){
        if(type == null) type = "png";
        if(maxWidth == null) maxWidth = 500;
        if(maxHeight == null) maxHeight = 500;
        String whereClause = "TARGET_NAME = '"+targetName + "' AND TARGET_ID = '" + targetId + "'";
        response.setContentType("image/" + type);
        try {
            Map<String,Object> resource = cmmMapper.selectTable(SsResource.class.getAnnotation(Table.class).name(), whereClause);
            String data;
            if(resource == null){
                //Image Empty
                Resource imageResource = context.getResource("classpath:templates/resource/empty_image.jpg");
                BufferedImage image = ImageIO.read(imageResource.getInputStream());
                OutputStream out = response.getOutputStream();
                ImageIO.write(image, type, out);
                out.close();
            }else{
                data = (String) resource.get("contents");
                byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(data);
                ImageIcon icon = new ImageIcon(imageBytes);
                int width = icon.getIconWidth();
                int height = icon.getIconHeight();
                int newWidth = 0;
                int newHeight = 0;
                int resizeWidth = maxWidth;
                int resizeHeight = maxHeight;
                if (width > resizeWidth) {
                    newWidth = resizeWidth;
                    newHeight = (int) ((double) height * ((double) resizeWidth / (double) width));
                }
                if (newHeight > resizeHeight) {
                    newWidth = (int) ((double) width * ((double) resizeHeight / (double) height));
                    newHeight = resizeHeight;
                }
                if (newWidth == 0 || newHeight == 0) {
                    newWidth = width;
                    newHeight = height;
                }
                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight ,BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resizedImage.createGraphics();
                g.drawImage(icon.getImage(), 0, 0, newWidth, newHeight, null);
                g.dispose();
                g.setComposite(AlphaComposite.Src);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                OutputStream out = response.getOutputStream();
                ImageIO.write(resizedImage, type, out);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
