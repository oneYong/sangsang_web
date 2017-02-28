package com.web.sangsang.cmm.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * 주제
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	제목					TITLE
 * 	내용					CONTENTS
 * 	순서					ODER
 * ------------------------------------
 */
@Table(name="SS_THEME")
public class SsTheme extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="TITLE", nullable = false, length = 254)
	private String title;
	@Column(name="TYPE", nullable = false, length = 20)
	private String type;
	@Column(name="ODER", precision = 4)
	private Integer oder;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="CREATE_TIME", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	private Date createTime;
	@Column(name="UPDATE_TIME", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	private Date updateTime;
}