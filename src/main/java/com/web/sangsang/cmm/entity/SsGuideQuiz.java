package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 가이드-퀴즈
 * ------------------------------------
 * 	가이드아이디(FK)		GUIDE_ID
 * 	퀴즈아이디(FK)			QUIZ_ID
 */
@Table(name="SS_GUIDE_QUIZ")
@Data
public class SsGuideQuiz extends BaseEntity {
	@Column(name="GUICE_ID")
	private String guideId;
	@Column(name="QUIZ_ID")
	private String quizId;
}