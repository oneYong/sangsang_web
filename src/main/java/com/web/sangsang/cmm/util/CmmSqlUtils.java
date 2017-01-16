package com.web.sangsang.cmm.util;

import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.constant.TableNameToClassName;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by WYKIM on 2017-01-06.
 */
@Component
public class CmmSqlUtils {
    public static final String DATABASE_NAME = "sangsang";
    private static final String PAKAGE_NAME = "com.web.sangsang.cmm.entity";


    public static String getTableColumInfo(String tableName){
        String makeColumn = "";
        try{
            String className = TableNameToClassName.valueOf(tableName).toString();

            Class clas = Class.forName(PAKAGE_NAME + "." + className);

            Field[] fields = clas.getDeclaredFields();
            for(int i = 0; i < fields.length; i++){
                String fieldName = fields[i].getName();
                String tableColumnName = fields[i].getAnnotation(Column.class).name();

                if(i == 0){
                    makeColumn += " t." + tableColumnName + " AS " + fieldName;
                }else{
                    makeColumn += ", t." + tableColumnName + " AS " + fieldName;
                }

            }

        }catch (Exception e){
            e.printStackTrace();
            makeColumn = "*";
        }

        return makeColumn;
    }
}
