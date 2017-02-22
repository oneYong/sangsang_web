package com.web.sangsang.cmm.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * 박물관
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	박물관이름				NAME
 * 	구분(국립,도립,...)		TYPE
 * 	중요도				IMPORTANCE
 * 	주제					SUBJECT
 * 	설명					DESCRIPTION
 * 	주요시대				MAJOR_ERA
 * 	주소					ADDRESS
 * 	홈페이지				HOMEPAGE
 * 	휴관일				CLOSED_DAY
 * 	연락처				CONTACT
 * 	위치(위도)				LAT
 * 	위치(경도)				LON
 * 	비고					REMARKS
 * ------------------------------------
 * 	탐방포인트(OtoM)		SS_GUIDE
 * 	오브젝트연결(OtoM)		SS_OBJECT
 * 	퀴즈연결(OtoM)			SS_QUIZ
 * 	사용자연결(MtoM)		SS_USER_MUSEUM
 */
@Table(name="SS_PLACE")
@Data
public class SsPlace extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="TYPE", nullable = false, length = 20)
	private String type;
	@Column(name="NAME", nullable = false, length = 100)
	private String name;
	@Column(name="ADDRESS", length=500)
	private String address;
	@Column(name="CLOSED_DAY", length=254)
	private String closedDay;
	@Column(name="CONTACT", length=254)
	private String contact;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="HOMEPAGE", length=254)
	private String homepage;
	@Column(name="IMPORTANCE", length=10)
	private String importance;
	@Column(name="LAT", precision = 18, scale = 10)
	private Double lat;
	@Column(name="LON", precision = 18, scale = 10)
	private Double lon;
	@Column(name="MAJOR_ERA", length = 50)
	private String majorEra;
	@Column(name="REMARKS")
	private String remarks;
	@Column(name="SUBJECT", length = 254)
	private String subject;
	@Column(name="CREATE_TIME", nullable = false)
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	public Date createTime;
	@Column(name="UPDATE_TIME", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	public Date updateTime;
}