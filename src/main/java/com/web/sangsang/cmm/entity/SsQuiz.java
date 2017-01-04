package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.annotation.Column;
import com.web.sangsang.cmm.annotation.Table;
import lombok.Data;

/**
 * 퀴즈
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	질의문				QUESTION
 * 	퀴즈형태구분			TYPE
 * 	내용					CONTENTS
 * ------------------------------------
 * 	박물관아이디(FK)		MUSEUM_ID
 * ------------------------------------
 *  탐방포인트연결(MtoM)	SS_GUIDE_QUIZ	
 * 	퀴즈선택항목연결(OtoM)	SS_QUIZ_CHOICE
 * 	사용자퀴즈확인연결(OtoM)	SS_USER_QUIZ
 */
@Table(name="SS_QUIZ")
@Data
public class SsQuiz {
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="TYPE", nullable = false, length = 20)
	private String type;
	@Column(name="QUESTION", nullable = false, length = 100)
	private String question;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="MUSEUM_ID")
	private SsMuseum ssMuseum;
}