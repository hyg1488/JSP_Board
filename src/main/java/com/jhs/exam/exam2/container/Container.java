package com.jhs.exam.exam2.container;

import com.jhs.exam.exam2.http.controller.UsrArticleController;
import com.jhs.exam.exam2.http.controller.UsrMemberController;
import com.jhs.exam.exam2.interceptor.BeforeActionInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLoginInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLogoutInterceptor;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.repository.MemberRepository;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.service.MemberService;

public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		memberRepository = new MemberRepository();
		
		articleService = new ArticleService();
		memberService = new MemberService();
		
		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
	}
}
