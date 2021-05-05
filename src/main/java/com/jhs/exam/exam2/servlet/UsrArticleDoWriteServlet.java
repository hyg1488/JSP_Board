package com.jhs.exam.exam2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhs.mysqliutil.MysqlUtil;
import com.jhs.mysqliutil.SecSql;

@WebServlet("/usr/article/doWrite")
public class UsrArticleDoWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 들어오는 파리미터를 UTF-8로 해석
		request.setCharacterEncoding("UTF-8");

		// 서블릿이 HTML 파일을 만들때 UTF-8 로 쓰기
		response.setCharacterEncoding("UTF-8");
		// HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
		response.setContentType("text/html; charset=UTF-8");
		
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(true);

		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		int id = MysqlUtil.insert(sql);
		
		response.getWriter().append(id + "번 게시물이 생성되었습니다.");
		
		MysqlUtil.closeConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
