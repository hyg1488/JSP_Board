package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.http.Rq;

public class NeedLogoutInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		return true;
	}

}
