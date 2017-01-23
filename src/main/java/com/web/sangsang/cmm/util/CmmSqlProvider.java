package com.web.sangsang.cmm.util;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

/**
 * Created by wonyongkim on 2017. 1. 5..
 */
@Component
public class CmmSqlProvider {

    public String selectTable(final String tableName, final String whereClause) {
        String makeTable = getMakeTable(tableName, whereClause);
        String makeWhere = getMakeWhere(null, null);
        String makeColumns = CmmSqlUtils.getTableColumInfo(tableName);
        return new SQL(){{
            SELECT(makeColumns);
            FROM(makeTable);
            WHERE(makeWhere);

        }}.toString();
    }

    public String selectTableList(final String tableName, final String whereClause,final Integer start,final Integer end) {
        String makeTable = getMakeTable(tableName, whereClause);
        String makeWhere = getMakeWhere(start, end);
        String makeColumns = CmmSqlUtils.getTableColumInfo(tableName);
        return new SQL(){{
            SELECT(makeColumns);
            FROM(makeTable);
            WHERE(makeWhere);

        }}.toString();
    }

    private String getMakeWhere(Integer start, Integer end) {
        String whereStr = "1=1";

        if(start != null){
            whereStr += " AND t.rowNum >= "+ start + " ";
        }
        if(end != null){
            whereStr += " AND t.rowNum <= "+ end +" ";
        }
        return whereStr;
    }

    private String getMakeTable(String tableName, String whereClause) {
        tableName = CmmSqlUtils.DATABASE_NAME + "."+tableName;
        String whereStr = "";

        if(whereClause != null && !whereClause.equals(""))
            whereStr = " AND (" + whereClause + ") ";

        return "("+
        "SELECT @rownum:=@rownum +1 as rowNum, t.* \n " +
        "  FROM (SELECT * \n" +
        "          FROM " +tableName +" \n" +
        "          WHERE 1=1 \n" +
                  whereStr +" \n" +
        "        ) t \n" +
        "   , (SELECT @rownum:=0) TMP" +
        ") t";
    }

    public String serverState() {
        return "SELECT * FROM "+CmmSqlUtils.DATABASE_NAME + ".SS_ENVIRONMENT ORDER BY APPLY_TIME DESC LIMIT 1";
    }
}
