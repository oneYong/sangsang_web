package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 사용자-퀴즈
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	퀴즈통과여부			IS_PASS
 * ------------------------------------
 * 	사용자연결(MtoO)		SS_USER
 * 	퀴즈연결(MtoO)		SS_QUIZ
 */
@Table(name="SS_USER_QUIZ")
@Data
public class SsUserQuiz  extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="IS_PASS", nullable = false)
	private Boolean isPass;
	@Column(name="USER_ID")
	private SsUser ssUser;
	@Column(name="QUIZ_ID")
	private SsQuiz ssQuiz;
}