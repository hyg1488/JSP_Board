package com.jhs.exam.exam2.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rq {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private boolean isInvalid = false;
	private String controllerTypeName;
	private String controllerName;
	private String actionMethodName;

	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		// 들어오는 파리미터를 UTF-8로 해석
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 서블릿이 HTML 파일을 만들때 UTF-8 로 쓰기
		resp.setCharacterEncoding("UTF-8");

		// HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
		resp.setContentType("text/html; charset=UTF-8");

		this.req = req;
		this.resp = resp;

		String requestUri = req.getRequestURI();
		String[] requestUriBits = requestUri.split("/");

		int minBitsCount = 5;

		if (requestUriBits.length < minBitsCount) {
			isInvalid = true;
			return;
		}

		int controllerTypeNameIndex = 2;
		int controllerNameIndex = 3;
		int actionMethodNameIndex = 4;

		this.controllerTypeName = requestUriBits[controllerTypeNameIndex];
		this.controllerName = requestUriBits[controllerNameIndex];
		this.actionMethodName = requestUriBits[actionMethodNameIndex];
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public boolean isInvalid() {
		return isInvalid;
	}

	public String getControllerTypeName() {
		return controllerTypeName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public String getActionMethodName() {
		return actionMethodName;
	}

	public void print(String str) {
		try {
			resp.getWriter().append(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void println(String str) {
		print(str + "\n");
	}

	public void jsp(String jspPath) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/" + jspPath + ".jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public String getParam(String paramName, String defaultValue) {
		String paramValue = req.getParameter(paramName);
		
		if ( paramValue == null ) {
			return defaultValue;
		}
		
		return paramValue;
	}

	public void printf(String format, Object... args) {
		print(String.format(format, args));
	}
}
