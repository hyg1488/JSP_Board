<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../part/head.jspf"%>

<section class="section section-article-write px-4">
	<div class="container mx-auto">

		<div class="card bordered shadow-lg">
			<div class="card-title">
				<a href="javascript:history.back();" class="cursor-pointer">
					<i class="fas fa-chevron-left"></i>
				</a>
				<span>게시물 리스트</span>
			</div>

			<div class="px-4">
				<c:forEach items="${articles}" var="article">
					<div class="py-4">
						<a class="hover:underline cursor-pointer block">
							<span class="badge badge-outline">제목</span>
							<div class="line-clamp-3">${article.titleForPrint}</div>
						</a>

						<div
							class="mt-3 grid sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-3">
							<a href="#" class="row-span-7">
								<img class="rounded-full" src="https://i.pravatar.cc/200?img=37"
									alt="">
							</a>

							<a href="#" class="hover:underline">
								<span class="badge badge-primary">번호</span>
								<span>${article.id}</span>
							</a>

							<a href="#" class="cursor-pointer hover:underline">
								<span class="badge badge-accent">작성자</span>
								<span>${article.memberId}</span>
							</a>

							<a href="#" class="hover:underline">
								<span class="badge">등록날짜</span>
								<span class="text-gray-600 text-light">${article.regDate}</span>
							</a>

							<a href="#" class="hover:underline">
								<span class="badge">수정날짜</span>
								<span class="text-gray-600 text-light">${article.updateDate}</span>
							</a>

							<a
								class="mt-3 hover:underline cursor-pointer col-span-1 sm:col-span-2 xl:col-span-3">
								<span class="badge badge-outline">본문</span>
								
								<div class="mt-2">
									<img class="rounded" src="https://picsum.photos/id/237/300/300" alt="" />
								</div>
								
								<div class="line-clamp-3">${article.bodySummaryForPrint}</div>
							</a>
						</div>

						<!--
						번호 : ${article.id}
						<br>
						작성 : ${article.regDate}
						<br>
						갱신 : ${article.updateDate}
						<br>
						제목 : ${article.title}
						<br>
						내용 : ${article.body}
						<br>
						-->
					</div>
					<hr />
				</c:forEach>
			</div>
		</div>
	</div>
</section>

<%@ include file="../part/foot.jspf"%>