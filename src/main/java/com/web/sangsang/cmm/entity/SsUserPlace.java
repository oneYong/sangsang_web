package com.web.sangsang.cmm.entity;


import com.web.sangsang.cmm.entity.annotation.Column;
import com.web.sangsang.cmm.entity.annotation.Table;
import lombok.Data;

/**
 * 사용자-장소
 */
@Table(name="SS_USER_PLACE")
@Data
public class SsUserPlace extends BaseEntity{
	@Column(name="USER_UID",primarykey = true)
	private String userUid;
	@Column(name="PLACE_ID",primarykey = true)
	private Long placeId;
	@Column(name="VISIT_CONFIRM")
	private Boolean visitConfirm;
	@Column(name="INTEREST")
	private Boolean interest;

}