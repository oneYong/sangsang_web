package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 가이드-오브젝트
 * ------------------------------------
 * 	가이드아이디(FK)		GUIDE_ID
 * 	오브젝트아이디(FK)		OBJECT_ID
 */
@Table(name="SS_GUIDE_OBJECT")
@Data
public class SsGuideObject extends BaseEntity {
	@Column(name="GUIDE_ID")
	private String guideId;
	@Column(name="OBJECT_ID")
	private String objectId;
}