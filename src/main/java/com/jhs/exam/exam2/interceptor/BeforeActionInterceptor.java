package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.dto.Member;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.util.Ut;

public class BeforeActionInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		String loginedMemberJson = rq.getSessionAttr("loginedMemberJson", "");

		if (loginedMemberJson.length() > 0) {
			rq.setLogined(true);
			rq.setLoginedMember(Ut.toObjFromJson(loginedMemberJson, Member.class));
			rq.setLoginedMemberId(rq.getLoginedMember().getId());
		}
		
		rq.setAttr("rq", rq);

		return true;
	}

}
