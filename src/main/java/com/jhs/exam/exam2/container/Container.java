package com.jhs.exam.exam2.container;

import com.jhs.exam.exam2.http.controller.UsrArticleController;
import com.jhs.exam.exam2.http.repository.ArticleRepository;
import com.jhs.exam.exam2.http.service.ArticleService;

public class Container {
	public static ArticleRepository articleRepository;
	
	public static ArticleService articleService;
	
	public static UsrArticleController usrArticleController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		articleService = new ArticleService();
		usrArticleController = new UsrArticleController();
	}
}
