package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.dto.Member;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.util.Ut;

public class BeforeActionInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		boolean isLogined = false;
		int loginedMemberId = 0;
		Member loginedMember = null;

		String loginedMemberJson = rq.getSessionAttr("loginedMemberJson", "");

		if (loginedMemberJson.length() > 0) {
			isLogined = true;
			loginedMember = Ut.toObjFromJson(loginedMemberJson, Member.class);
			loginedMemberId = loginedMember.getId();
		}

		rq.setAttr("isLogined", isLogined);
		rq.setAttr("loginedMember", loginedMember);
		rq.setAttr("loginedMemberId", loginedMemberId);

		return true;
	}

}
