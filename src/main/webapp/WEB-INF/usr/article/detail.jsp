<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../part/head.jspf"%>

<section class="section section-article-detail px-4">
	<div class="container mx-auto">

		<div class="card bordered shadow-lg">
			<div class="card-title">
				<a href="javascript:history.back();" class="cursor-pointer"> <i
					class="fas fa-chevron-left"></i>
				</a> <span>게시물 상세페이지</span>
			</div>

			<div class="px-4">

				<div class="py-4">
					<div class="grid gap-3" style="grid-template-columns: 100px 1fr;">
						<div>
							<img class="rounded-full w-full"
								src="https://i.pravatar.cc/200?img=37" alt="">
						</div>
						<div>
							<span class="badge badge-outline">제목</span>
							<div>${article.titleForPrint}</div>
						</div>
					</div>

					<div class="mt-3 grid sm:grid-cols-2 lg:grid-cols-4 gap-3">
						<div>
							<span class="badge badge-primary">번호</span> <span>${article.id}</span>
						</div>

						<div>
							<span class="badge badge-accent">작성자</span> <span>${article.memberId}</span>
						</div>

						<div>
							<span class="badge">등록날짜</span> <span
								class="text-gray-600 text-light">${article.regDate}</span>
						</div>

						<div>
							<span class="badge">수정날짜</span> <span
								class="text-gray-600 text-light">${article.updateDate}</span>
						</div>
					</div>

					<div
						class="block mt-3 hover:underline cursor-pointer col-span-1 sm:col-span-2 xl:col-span-3">
						<span class="badge badge-outline">본문</span>

						<div class="mt-2">
							<img class="rounded" src="https://picsum.photos/id/237/300/300"
								alt="" />
						</div>

						<div>${article.bodySummaryForPrint}</div>
					</div>

					<div class="btns mt-3">
						<c:if test="${article.extra__actorCanModify}">
							<a href="../article/modify?id=${article.id}" class="btn btn-link">
								<span><i class="fas fa-edit"></i></span> <span>수정</span>
							</a>
						</c:if>
						<c:if test="${article.extra__actorCanDelete}">
							<a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;"
								href="../article/doDelete?id=${article.id}" class="btn btn-link">
								<span><i class="fas fa-trash-alt"></i></span> <span>삭제</span>
							</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../part/foot.jspf"%>