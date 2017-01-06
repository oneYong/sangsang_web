package com.web.sangsang.test;

import com.web.sangsang.cmm.entity.SsObject;
import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.constant.TableNameToClassName;

import java.lang.reflect.Field;

/**
 * Created by WYKIM on 2017-01-06.
 */

public class TestClass {
    public static void main(String[] args) throws Exception{
        System.out.println(TableNameToClassName.valueOf("SS_GUIDE"));



        SsObject ssObject = new SsObject();

        Class clas = Class.forName("com.web.sangsang.cmm.entity.SsObject");

        Field[] fields = clas.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            String fieldName = fields[i].getName();
            System.out.println(fieldName);
        }
        System.out.println(ssObject.getClass().getDeclaredFields()[0].getAnnotation(Column.class).name());

    }
}
