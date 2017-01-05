package com.web.sangsang.cmm.util;

import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

/**
 * Created by wonyongkim on 2017. 1. 5..
 */
@Component
public class CmmSqlProvider {

    public String selectTable(final String tableName, final String whereClause,final Integer start,final Integer end) {
        String makeTable = getMakeTable(tableName, whereClause);
        String makeWhere = getMakeWhere(start, end);
        return new SQL(){{
            SELECT("*");
            FROM(makeTable);
            WHERE(makeWhere);

        }}.toString();
    }

    private String getMakeWhere(Integer start, Integer end) {
        String whereStr = "1=1";

        if(start != null && end != null){
            whereStr = "t.rowNum >= "+ start + " ";
            whereStr += "AND t.rowNum <= "+ end +" ";
        }

        return whereStr;
    }

    private String getMakeTable(String tableName, String whereClause) {
        String whereStr = "";

        if(whereClause != null && !whereClause.equals(""))
            whereStr = "AND " + whereClause;

        return "("+
        "SELECT @rownum:=@rownum +1 as rowNum, t.*\n " +
        "  FROM (SELECT * \n" +
        "          FROM " +tableName +"\n" +
        "          WHERE 1=1\n" +
                  whereStr +"\n" +
        "        ) t\n" +
        "   , (SELECT @rownum:=0) TMP" +
        ") t";
    }
}
