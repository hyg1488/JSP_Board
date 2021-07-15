package com.jhs.exam.exam2.dto;

import java.util.Map;

import com.jhs.exam.exam2.util.Ut;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultData {
	@Getter
	private String msg;
	@Getter
	private String resultCode;
	@Getter
	private Map<String, Object> body;
	
	private ResultData() {
		
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return !isSuccess();
	}

	public static ResultData from(String resultCode, String msg, Object... bodyArgs) {
		ResultData rd = new ResultData();

		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.body = Ut.mapOf(bodyArgs);

		return rd;
	}
}
