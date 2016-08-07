<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function check() {
		var key = document.getElementById('key');
		var gender = document.getElementById('gender');
		var type = document.getElementById('type');

		if (key.value == "" ) {
			alert('조건을 선택하세요');
		} else {
			return true;
		}
		return false;
	}
</script>
<style>
</style>
</head>
<body>

	<form action="ActionServlet?action=SEARCH_RESULT" method="post"
		onsubmit="return check()">
		<table>
			<tr>
				<td>조건</td>
				<td><select style="background-color: gray;" name="con_key"
					id="key">
						<option value="" style="display:none;" >-선택-</option>
						<option value="PI_FRIST_NAME" style="background-color: white;">성</option>
						<option value="PI_LAST_NAME" style="background-color: white;">이름</option>
						<option value="PI_AGE" style="background-color: white;">나이</option>
						<option value="PI_JOB" style="background-color: white;">직업</option>
						<option value="PI_MAJOR" style="background-color: white;">전공</option>
				</select></td>
				<td>성별</td>
				<td><select style="background-color: gray;" name="con_gender"
					id="gender">
						<option style="display:none;" value="">-선택-</option>
						<option style="background-color: white;" value="" >전체</option>
						<option style="background-color: white;"value="0">남자</option>
						<option style="background-color: white;" value="1">여자</option>
				</select></td>
				<td>공개구분</td>
				<td><select style="background-color: gray;" name="con_type"
					id="type">
						<option style="display:none;" value="">-선택-</option>
						<option style="background-color: white;"value="">전체</option>
						<option style="background-color: white;"value="0">비공개</option>
						<option style="background-color: white;"value="1">공개</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="5"><input type="text" name="text"
					style="width: 95%" /></td>
				<td><input type="submit" value="검색" /></td>

			</tr>
			<%
				System.out.println("================서치");
				System.out.println(request.getAttribute("LIST"));
				System.out.println("================서치");
			%>


			<c:if test="${param.action == 'SEARCH_RESULT'}">
				<c:if test="${LIST[0] ==  null}">
					<tr>
						<td colspan="6">일치하는 데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${LIST[0] != null}">
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>전공</th>
						<th>직업</th>
						<th>공개구분</th>
					</tr>
				</c:if>

				<c:forEach var="i" items="${LIST}">
					<tr>
						<td>${i.num}</td>
						<td><a href="ActionServlet?action=INFO&seq=${i.seq}">${i.name }</a></td>
						<td>${i.age }</td>
						<td>
						<c:if test="${i.gender == 0}">남자</c:if>
						<c:if test="${i.gender == 1}">여자</c:if>						
						</td>
						<td>${i.major}</td>
						<td>${ i.job}</td>
						<td>
						<c:if test="${i.type == 0}">비공개</c:if>
						<c:if test="${i.type == 1}">공개</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>


		</table>
	</form>

</body>
</html>