<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Personal Infomation(model2)</h1>

	<!-- JSTL c:if -->
	<p>
		<c:if test="${null ne sessionScope.ID}">(JSTL c:if)안녕하세요. ${sessionScope.ID} 님</c:if>
	</p>

	<!-- JSTL c:out  -->
	<p>
		<c:out value="(JSTL c:out)${sessionScope.ID}님을 환영합니다."
			default="JSLT c:out 로그인해주세요" />
	</p>

	<!--EL  -->
	<p>${empty sessionScope.ID ? "(EL 3항 연산자) 로그인해주세요" : ID}</p>

	<ul>
		<!-- //FIXME href 앞에 /(절대경로) 붙이면 안되는 이유는 프로젝트(웹어플리케이션) 위까지 올라가서 -->

		<c:choose>
			<c:when test="${sessionScope.ID eq null}">
				<li><a href="ActionServlet?action=JOIN">회원가입</a></li>
				<li><a href="ActionServlet?action=LOGIN">로그인</a></li>
			</c:when>
			<c:when test="${sessionScope.ID ne null}">
				<li><a href="ActionServlet?action=LOGOUT">로그아웃</a></li>
				<c:choose>
					<c:when test="${sessionScope.ID != 'admin'}">
						<li><a href="ActionServlet?action=SEARCH">인물정보검색</a></li>
					</c:when>
					<c:when test="${sessionScope.ID == 'admin'}">
						<li><a href="ActionServlet?action=SEARCH">인물정보검색</a></li>
						<li><a href="ActionServlet?action=ENROLL">인물정보등록</a></li>
					</c:when>
				</c:choose>
			</c:when>
		</c:choose>

	</ul>
	
	<p>남은작업 : 1. 아이디 한글막기 2. 비밀번호 암호화해서 DB넣기 3. 입력받은 스트링에 공백도 들어간다.</p>

	<c:if test="${(param.action == 'SEARCH' && sessionScope.ID != null) || (param.action == 'SEARCH_RESULT' && sessionScope.ID != null)}">
		<jsp:include page="search.jsp"></jsp:include>
	</c:if>

	<c:if test="${sessionScope.ID == 'admin' &&  param.action == 'ENROLL'}">
		<jsp:include page="enrollForm.html"></jsp:include>
	</c:if>



</body>
</html>