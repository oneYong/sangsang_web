package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.annotation.Column;
import com.web.sangsang.cmm.annotation.Table;
import lombok.Data;

/**
 * 탐방포인트
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	제목					TITLE
 * 	내용					CONTENTS
 * 	주요시대				MAJOR_ERA
 * 	순서					ODER
 * ------------------------------------
 * 	박물관아이디(FK)		MUSEUM_ID
 * ------------------------------------
 * 	오브젝트연결(MtoM)		SS_GUIDE_OBJECT
 * 	퀴즈연결(MtoM)		SS_GUIDE_QUIZ
 */
@Table(name="SS_GUIDE")
@Data
public class SsGuide extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="TITLE", nullable = false, length = 254)
	private String title;
	@Column(name="MAJOR_ERA", length = 50)
	private String majorEra;
	@Column(name="ODER", precision = 4)
	private Integer oder;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="MUSEUM_ID")
	private SsMuseum ssMuseum;

}