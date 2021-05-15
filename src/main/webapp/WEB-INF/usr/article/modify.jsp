<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 수정" />
<%@ include file="../part/head.jspf"%>

<section class="section section-article-write px-4">
	<div class="container mx-auto">

		<div class="card bordered shadow-lg">
			<div class="card-title">
				<a href="javascript:history.back();" class="cursor-pointer">
					<i class="fas fa-chevron-left"></i>
				</a>
				<span>게시물 수정페이지</span>
			</div>

			<div class="px-4 py-4">
				<script>
					let ArticleModify__submitDone = false;
					function ArticleModify__submit(form) {
						if (ArticleModify__submitDone) {
							return;
						}

						if (form.title.value.length == 0) {
							alert('제목을 입력해주세요.');
							form.title.focus();

							return;
						}

						if (form.body.value.length == 0) {
							alert('내용을 입력해주세요.');
							form.body.focus();

							return;
						}

						form.submit();
						ArticleModify__submitDone = true;
					}
				</script>
				<form action="../article/doModify" method="POST"
					onsubmit="ArticleModify__submit(this); return false;">
					<input type="hidden" name="id"
						value="${article.id}" />
					<input type="hidden" name="redirectUri"
						value="../article/detail?id=${article.id}" />
					<div class="form-control">
						<label class="label">
							<span class="label-text">제목</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="title" type="text" placeholder="제목을 입력해주세요." value="${article.title}" />
						</div>
					</div>

					<div class="form-control">
						<label class="label">
							<span class="label-text">내용</span>
						</label>
						<textarea maxlength="2000" class="textarea textarea-bordered h-60"
							placeholder="내용을 입력해주세요." name="body">${article.body}</textarea>
					</div>

					<div class="btns">
						<button type="submit" class="btn btn-link">수정</button>
						<button onclick="history.back();" type="button" class="btn btn-link">수정취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<%@ include file="../part/foot.jspf"%>