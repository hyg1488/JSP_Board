package com.jhs.exam.exam2.http.service;

import com.jhs.exam.exam2.dto.ResultData;
import com.jhs.exam.exam2.http.repository.ArticleRepository;
import com.jhs.exam.exam2.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository;
	
	public ArticleService() {
		articleRepository = new ArticleRepository();
	}

	public ResultData write(String title, String body) {
		int id = articleRepository.write(title, body);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

}
