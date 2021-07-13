<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jhs.exam.exam2.http.Rq" %>
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
			
			<div class="px-4 py-4">
				<div class="badge badge-primary">전체게시물 개수</div>			
				${totalItemsCount}
			</div>
			
			<hr />
			
			<div class="px-4">
				<c:forEach items="${articles}" var="article">
					<c:set var="detailUri" value="../article/detail?id=${article.id}" />

					<div class="py-4">
						<div class="grid gap-3" style="grid-template-columns: 100px 1fr;">
							<a href="${detailUri}">
								<img class="rounded-full w-full"
									src="https://i.pravatar.cc/200?img=37" alt="">
							</a>
							<a href="${detailUri}" class="hover:underline cursor-pointer">
								<span class="badge badge-outline">제목</span>
								<div class="line-clamp-3">${article.titleForPrint}</div>
							</a>
						</div>

						<div class="mt-3 grid sm:grid-cols-2 lg:grid-cols-4 gap-3">
							<a href="${detailUri}" class="hover:underline">
								<span class="badge badge-primary">번호</span>
								<span>${article.id}</span>
							</a>

							<a href="${detailUri}" class="cursor-pointer hover:underline">
								<span class="badge badge-accent">작성자</span>
								<span>${article.extra__writerName}</span>
							</a>

							<a href="${detailUri}" class="hover:underline">
								<span class="badge">등록날짜</span>
								<span class="text-gray-600 text-light">${article.regDate}</span>
							</a>

							<a href="${detailUri}" class="hover:underline">
								<span class="badge">수정날짜</span>
								<span class="text-gray-600 text-light">${article.updateDate}</span>
							</a>
						</div>

						<a href="${detailUri}"
							class="block mt-3 hover:underline cursor-pointer col-span-1 sm:col-span-2 xl:col-span-3">
							<span class="badge badge-outline">본문</span>

							<div class="mt-2">
								<img class="rounded" src="https://picsum.photos/id/237/300/300"
									alt="" />
							</div>

							<div class="line-clamp-3">${article.bodySummaryForPrint}</div>
						</a>
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
					
					<hr />
				</c:forEach>
				
				<div class="page-menu">
					<%
					Rq rq = (Rq)request.getAttribute("rq");
					int totalPage = rq.getIntAttr("totalPage", 10);
					%>
					<% for ( int i = 1; i <= totalPage; i++ ) { %>
					<a href="?page=<%=i%>"><%=i%></a>
					<% } %>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../part/foot.jspf"%>