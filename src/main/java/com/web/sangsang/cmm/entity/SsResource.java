package com.web.sangsang.cmm.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * 리소스
 * ------------------------------------
 * 	아이디(PK)			ID
 * 	경로(link,url,...)	PATH
 * 	리소스형태				TYPE
 * 	리소스설명				CAPTION
 * 	대상아이디				TARGET_ID
 * 	대상테이블명			TARGET_NAME
 */
@Table(name="SS_RESOURCE")
@Data
public class SsResource  extends BaseEntity{
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="CAPTION")
	private String caption;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="TYPE", length = 254)
	private String type;
	@Column(name="TARGET_ID", nullable = false,length = 5)
	private String targetId;
	@Column(name="TARGET_NAME", nullable = false,length = 50)
	private String targetName;
	@Column(name="CREATE_TIME", nullable = false)
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	public Date createTime;
	@Column(name="UPDATE_TIME", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	public Date updateTime;
}