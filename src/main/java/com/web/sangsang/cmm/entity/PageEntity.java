package com.web.sangsang.cmm.entity;

import lombok.Data;

@Data
public class PageEntity {
    private String query;
    private String whereClause;
    private Integer start;
    private Integer end;
}