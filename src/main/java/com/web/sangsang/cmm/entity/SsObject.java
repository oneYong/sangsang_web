package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 오브젝트(전시물/유물)
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	이름					NAME
 * 	구분(국보,사적,...)	TYPE
 * 	설명					DESCRIPTION
 * ------------------------------------
 * 	박물관아이디(FK)		MUSEUM_ID
 * ------------------------------------
 * 	탐방포인트연결(MtoM)	SS_GUIDE_OBJECT
 */
@Table(name="SS_OBJECT")
@Data
public class SsObject  extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="TYPE", nullable = false, length = 20)
	private String type;
	@Column(name="NAME", nullable = false, length = 100)
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="MUSEUM_ID")
	private SsMuseum ssMuseum;
}