package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.annotation.Column;
import com.web.sangsang.cmm.annotation.Table;
import lombok.Data;

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
public class SsResource {
	@Column(name = "ID", nullable = false, precision = 10,primarykey = true)
	private Long id;
	@Column(name="CAPTION")
	private String caption;
	@Column(name="PATH", nullable = false,length = 4000)
	private String path;
	@Column(name="TYPE", length = 254)
	private String type;
	@Column(name="TARGET_ID", nullable = false,length = 5)
	private String targetId;
	@Column(name="TARGET_NAME", nullable = false,length = 50)
	private String targetName;
}