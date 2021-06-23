package com.jhs.exam.exam2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private String delDate;
	private boolean delStatus;
	private String name;
	private String nickname;
	private String email;
	private String cellphoneNo;
	private int authLevel;
}
