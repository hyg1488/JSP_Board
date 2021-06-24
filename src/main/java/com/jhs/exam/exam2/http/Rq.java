package com.jhs.exam.exam2.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhs.exam.exam2.dto.Member;
import com.jhs.exam.exam2.util.Ut;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Rq {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	@Getter
	private boolean isInvalid = false;
	@Getter
	private String controllerTypeName;
	@Getter
	private String controllerName;
	@Getter
	private String actionMethodName;
	
	@Getter
	@Setter
	private boolean isLogined = false;
	
	@Getter
	@Setter
	private int loginedMemberId = 0;
	
	@Getter
	@Setter
	private Member loginedMember = null;
	
	public boolean isNotLogined() {
		return isLogined == false;
	}

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

		if (paramValue == null) {
			return defaultValue;
		}

		return paramValue;
	}

	public int getIntParam(String paramName, int defaultValue) {
		String paramValue = req.getParameter(paramName);

		if (paramValue == null) {
			return defaultValue;
		}

		try {
			return Integer.parseInt(paramValue);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public void printf(String format, Object... args) {
		print(Ut.f(format, args));
	}

	public void historyBack(String msg) {
		println("<script>");
		if (msg != null && msg.trim().length() > 0) {
			printf("alert('%s');\n", msg.trim());
		}
		println("history.back();");
		println("</script>");
	}

	public void println(Object obj) {
		println(obj.toString());
	}

	public void setAttr(String attrName, Object attrValue) {
		req.setAttribute(attrName, attrValue);
	}

	public void replace(String msg, String redirectUri) {
		println("<script>");
		if (msg != null && msg.trim().length() > 0) {
			printf("alert('%s');\n", msg.trim());
		}
		printf("location.replace('%s');\n", redirectUri);
		println("</script>");
	}

	public void setSessionAttr(String attrName, String attrValue) {
		req.getSession().setAttribute(attrName, attrValue);
	}

	public void removeSessionAttr(String attrName) {
		req.getSession().removeAttribute(attrName);
	}

	public <T> T getSessionAttr(String attrName, T defaultValue) {
		if (req.getSession().getAttribute(attrName) == null) {
			return defaultValue;
		}

		return (T) req.getSession().getAttribute(attrName);
	}

	public String getActionPath() {
		return "/" + controllerTypeName + "/" + controllerName + "/" + actionMethodName;
	}
}
