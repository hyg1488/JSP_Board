package com.jhs.exam.exam2.http.controller;

import com.jhs.exam.exam2.http.Rq;

public class UsrArticleController extends Controller {

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "write":
			actionShowWrite(rq);
			break;
		case "doWrite":
			actionDoWrite(rq);
			break;
		}
	}

	private void actionDoWrite(Rq rq) {

	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
	}
}
