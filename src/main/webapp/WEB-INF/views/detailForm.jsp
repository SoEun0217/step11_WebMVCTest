<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품상세보기</h1>

<table border="1">
 <tr>
   <th>상품코드</th>
   <td>${dto.code}</td>
 </tr>
  <tr>
   <th>상품이름</th>
   <td>${dto.name}</td>
 </tr>
  <tr>
   <th>상품가격</th>
   <td>${dto.price}</td>
 </tr>
  <tr>
   <th>상품설명</th>
   <td>${dto.detail}</td>
 </tr>
 <tr>
   <th colspan="2">
     <a href="javascript:history.back();">이전으로</a>
   </th>
 </tr>
</table>

</body>
</html>





