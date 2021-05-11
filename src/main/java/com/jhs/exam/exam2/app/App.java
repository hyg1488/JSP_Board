package com.jhs.exam.exam2.app;

import com.jhs.exam.exam2.container.Container;
import com.jhs.mysqliutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		// 이 부분을 false로 바꾸면 production 모드 이다.
		return true;
	}
	
	public static void init() {
		// DB 세팅
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());
		
		// 공용 객체 세팅
		Container.init();
	}
}
