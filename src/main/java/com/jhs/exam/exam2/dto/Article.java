package com.jhs.exam.exam2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private int boardId;
	private int memberId;
	private String title;
	private String body;
	
	private String extra__writerName;
	
	public String getTitleForPrint() {
		return title;
	}
	
	public String getBodySummaryForPrint() {
		return body;
	}
}
