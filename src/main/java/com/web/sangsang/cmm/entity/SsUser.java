package com.web.sangsang.cmm.entity;



import com.web.sangsang.cmm.annotation.Column;
import com.web.sangsang.cmm.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * 사용자
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	이름					NAME
 * 	이메일				EMAIL
 * 	생성일자				CREATE_TIME
 * 	동의일자				AGREE_TIME
 * 	최종액션일자			LAST_TIME
 * 	로그아웃일자			LEAVE_TIME
 * 	연계(페이스북,네이버,..)	SOURCE
 * 	연계아이디				SOURCE_ID
 * 	연계토큰				SOURCE_TOKEN
 * ------------------------------------
 * 	박물관연결(MtoM)		SS_MUSEUM
 * 	퀴즈연결(OtoM)		SS_USER_QUIZ
 */
@Table(name="SS_USER")
@Data
public class SsUser  {
	@Column(name = "GUID", nullable = false, precision = 10)
	public String guid;
	@Column(name="AGREE_TIME")
	public Date agreeTime;
	@Column(name="CREATE_TIME")
	public Date createTime;
	@Column(name="EMAIL", nullable = false,length = 254)
	public String email;
	@Column(name="LAST_TIME")
	public Date lastTime;
	@Column(name="LEAVE_TIME")
	public Date leaveTime;
	@Column(name="NAME", nullable = false,length = 100)
	public String name;
	@Column(name="SOURCE", nullable = false,length = 100)
	public String source;
	@Column(name="SOURCE_ID",length = 1000)
	public String sourceId;
	@Column(name="SOURCE_TOKEN",length = 1000)
	public String sourceToken;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getAgreeTime() {
		return agreeTime;
	}

	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceToken() {
		return sourceToken;
	}

	public void setSourceToken(String sourceToken) {
		this.sourceToken = sourceToken;
	}
}