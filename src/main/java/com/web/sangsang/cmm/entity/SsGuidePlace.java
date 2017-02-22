package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 가이드-장소
 * ------------------------------------
 * 	가이드아이디(FK)		GUIDE_ID
 * 	장소아이디(FK)			PLACE_ID
 */
@Table(name="SS_GUIDE_PLACE")
@Data
public class SsGuidePlace extends BaseEntity {
	@Column(name="GUICE_ID")
	private String guideId;
	@Column(name="PLACE_ID")
	private String placeId;
}