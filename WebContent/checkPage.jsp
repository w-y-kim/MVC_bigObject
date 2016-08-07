<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insert() {
		var id = document.getElementById('id');
		opener.document.getElementById('id').value = id.value;
		top.window.close();
	}
</script>
</head>
<body>
	<h1 id="">중복확인</h1>
${ID}
	<form action="ActionServlet" method="get" accept-charset="utf-8">
		<input type="hidden" name="action" value="ID_CHECK_RESULT" /> <label
			for="id">이름 <input type="text" id="id" name="id"
			value="${param.id}" /> <!-- 여기서 param.id는 이전 페이지의 form값을 서블릿에서 request와 함께 넘겨준것 -->
		</label> <input type="submit" value="확인" />

		<!-- EL식 안에 연산자 넣어야 하는 듯 , JSTL태그사이 주석 못넣는듯-->
		<c:choose>
			<c:when test="${RESULT eq false}">
				<p>사용할 수 없는 ID 입니다.</p>

			</c:when>
			<c:when test="${RESULT eq true}">
				<p>사용할 수 있는 ID 입니다.</p>
				<input type="button" onclick="insert()" value="사용" />
			</c:when>
			<c:otherwise>
				<p>아이디 필드가 비어 있습니다.</p>
			</c:otherwise>

		</c:choose>




		<!-- 		<input type="submit" value="검색" /> -->
	</form>

</body>
</html>

<!--
4.3. ID 중복확인

- 회원가입 폼에서 윈도우 창을 띄워 다음과 같은 화면을 보여준다.

- 사용중인 ID의 경우 ‘이미 사용중인 ID 입니다’를 표시한다.

- 사용할 수 있는 ID의 경우 ‘사용할 수 있는 ID 입니다’를 표시하고 ID사용하기 버튼이 보여진다.

- ID사용하기 버튼을 누르면 아이디가 회원 가입 폼에 입력되고 중복확인 윈도우가 닫힌다. -->