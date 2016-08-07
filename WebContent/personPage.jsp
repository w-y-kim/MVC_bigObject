<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="model2.vo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {

		return true;
	}
</script>
<style>


td, td {
	border: 1px solid black; width =70%;
	text-align: center;
	font-weight: bold;
	border-collapsed: collapse;
}

input {width ="80%";
	
}
</style>
</head>
<body>
	<h1>[ 인물 상세 정보 ]</h1>
	<table>

		<tr>
			<td>성</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.first_name}" /></td>
			<td>이름</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.last_name}" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input size="50%" type="text" disabled
				value="${INFO.sex  == 0 ? '남자':'여자'}" /></td>
			<td>공개구분</td>
			<td><input size="50%" type="text" disabled
				value="${INFO.type == 0 ? '비공개':'공개'}" /></td>
		</tr>
		<tr>
			<td>가족</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.family}" /></td>
			<td>나이</td>
			<td><input type="text" size="50%" disabled value="${INFO.age}" /></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.hobby}" /></td>
			<td>우편번호</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.zipcode}" /></td>
		</tr>
		<tr>
			<td>출생지</td>
			<td colspan="3" align="center"><input type="text" disabled
				value="${INFO.birthday}" size="100%" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="3" align="center"><input type="text" disabled
				value="${INFO.addr}" size="100%" /></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td colspan="3" align="center"><input type="text" size="100%"
				disabled value="${INFO.addr_detail}" /></td>
		</tr>
		<tr>
			<td>학교</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.school}" /></td>
			<td>전공</td>
			<td><input type="text" size="50%" disabled
				value="${INFO.major}" /></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><input type="text" size="50%" disabled value="${INFO.job}" /></td>
			<td>분야</td>
			<td><input type="text" size="50%" disabled value="${INFO.field}" /></td>
		</tr>
		<tr>
			<td>소속</td>
			<td><input type="text" size="50%" disabled value="${INFO.dept}" /></td>
			<td>직위</td>
			<td><input type="text" size="50%" disabled value="${INFO.position}" /></td>
		</tr>
		<tr>
			<td>연봉</td>
			<td><input type="text" disabled  size="50%" value="${INFO.salary}" /></td>
			<td>입사일</td>
			<td><input type="text" disabled  size="50%"value="${INFO.hiredate}" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" size="50%"  disabled value="${INFO.email}" /></td>
			<td>FAX</td>
			<td><input type="text" disabled  size="50%" value="${INFO.fax}" /></td>
		</tr>
		<tr>
			<td>홈페이지</td>
			<td><input type="text" disabled  size="50%" value="${INFO.hp}" /></td>
			<td>회사연락처</td>
			<td><input type="text" disabled  size="50%" value="${INFO.company_phone}" />
			</td>
		</tr>
		<tr>
			<td>개인연락처1</td>
			<td><input size="60%" type="text" size="50%" disabled
				value="${INFO.phone_1}" /></td>
			<td>개인연락처2</td>
			<td><input type="text" disabled  size="50%" value="${INFO.phone_2}" /></td>
		</tr>
		<tr>
			<td>자격증1</td>
			<td colspan="3" align="center"><input type="text"  size="100%" disabled
				value="${INFO.license_1}" /></td>
		</tr>
		<tr>
			<td>자격증2</td>
			<td colspan="3" align="center"><input type="text"  size="100%" disabled
				value="${INFO.license_2}" /></td>
		</tr>
		<tr>
			<td>자격증3</td>
			<td colspan="3" align="center"><input type="text" size="100%"  disabled
				value="${INFO.license_3}" /></td>
		</tr>
		<tr>
			<td>경력사항1</td>
			<td colspan="3" align="center"><input type="text"  size="100%" disabled
				value="${INFO.career_1}" /></td>
		</tr>
		<tr>
			<td>경력사항2</td>
			<td colspan="3" align="center"><input type="text"  size="100%" disabled
				value="${INFO.career_2}" /></td>
		</tr>
		<tr>
			<td>경력사항3</td>
			<td colspan="3" align="center"><input type="text" size="100%"  disabled
				value="${INFO.career_3}" /></td>
		</tr>
	</table>
</body>
</html>