package com.jhs.exam.exam2.service;

import java.util.List;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.dto.Article;
import com.jhs.exam.exam2.dto.Member;
import com.jhs.exam.exam2.dto.ResultData;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;

	public ResultData write(int boardId, int memberId, String title, String body) {
		int id = articleRepository.write(boardId, memberId, title, body);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles() {
		return articleRepository.getForPrintArticles();
	}

	public Article getForPrintArticleById(int id) {
		return articleRepository.getForPrintArticleById(id);
	}

	public ResultData delete(int id) {
		articleRepository.delete(id);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id), "id", id);
	}

	public ResultData modify(int id, String title, String body) {
		articleRepository.modify(id, title, body);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 수정되었습니다.", id), "id", id);
	}

	public ResultData actorCanModify(Member member, Article article) {
		int memberId = member.getId();
		int writerMemberId = article.getMemberId();

		if (memberId != writerMemberId) {
			return ResultData.from("F-1", "권한이 없습니다.");
		}

		return ResultData.from("S-1", "수정이 가능합니다.");
	}

	public ResultData actorCanDelete(Member member, Article article) {
		int memberId = member.getId();
		int writerMemberId = article.getMemberId();

		if (memberId != writerMemberId) {
			return ResultData.from("F-1", "권한이 없습니다.");
		}

		return ResultData.from("S-1", "삭제가 가능합니다.");
	}

}
