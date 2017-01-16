package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 퀴즈
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	내용					CONTENTS
 * 	정답여부				IS_CORRECT
 * ------------------------------------
 * 	퀴즈아이디(FK)			QUIZ_ID
 */
@Table(name="SS_QUIZ_CHOICE")
@Data
public class SsQuizChoice  extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="IS_CORRECT",nullable = false)
	private Boolean isCorrect;
	@Column(name="QUIZ_ID")
	private Long quizId;
}