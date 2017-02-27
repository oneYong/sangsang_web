package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 테마-장소
 * ------------------------------------
 * 	테마아이디(FK)			THEME_ID
 * 	장소아이디(FK)			PLACE_ID
 */
@Table(name="SS_THEME_PLACE")
public class SsThemePlace extends BaseEntity {
	@Column(name="THEME_ID")
	private String themeId;
	@Column(name="PLACE_ID")
	private String placeId;
}