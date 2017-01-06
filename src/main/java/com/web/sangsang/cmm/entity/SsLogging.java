package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

import java.util.Date;


/**
 * 로깅
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	타입(error,info,...)	TYPE
 * 	기록시간				RECODE_TIME
 * 	이전페이지				REFERER
 * 	접속아이피				ACCESS_IP
 * 	접속정보				ACCESS_INFO
 * 	기록자아이디			USER_ID
 * 	기록자이름				USER_NAME
 */
@Table(name="SS_LOGGING")
@Data
public class SsLogging extends BaseEntity{
	@Column(name="TYPE", nullable=false, length=10)
	private String type;
	@Column(name="RECODE_TIME")
	private Date recodeTime;
	@Column(name="REFERER",length=4000)
	private String referer;
	@Column(name="ACCESS_IP", length=39)
	private String accessIp;
	@Column(name="ACCESS_INFO", length=4000)
	private String accessInfo;
	@Column(name="USER_ID",  length=254)
	private String userId;
	@Column(name="USER_NAME", length=254)
	private String userName;
}