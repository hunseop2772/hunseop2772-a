<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h2>EL</h2>
	<p>덧셈 : ${10+2 }</p>
	<p>뺄셈: ${10-2 }</p>
	<p>곱셈: ${10*2 }</p>
	<p>나눗셈: ${10/2 }</p>
	<p>나눗셈: ${10 div 2 }</p>
	<p>나머지: ${10% 2 }</p>
	<p>나머지: ${10 mod 2 }</p>
	<p>크다: ${10 > 2 }</p>
	<p>크다: ${10 gt 2 }</p>
	<p>작다: ${10 < 2 }</p>
	<p>작다: ${10 lt 2 }</p>
	<p>같다: ${10 == 2 }</p>
	<p>같다: ${10 eq 2 }</p>
	<p>다르다: ${10 != 2 }</p>
	<p>다르다: ${10 ne 2 }</p>
	<p>크거나 같다: ${10 >= 2 }</p>
	<p>크거나 같다: ${10 ge 2 }</p>
	<p>작거나 같다: ${10 <= 2 }</p>
	<p>작거나 같다: ${10 le 2 }</p>
	
	<jsp:useBean id="test" class="com.koreait.Eltest"/>
	<p>test.getStr() :${test.getStr()} </p>
	<p>test.setStr() :${test.setStr("Hello el")} </p>
	<p>test.getStr() :${test.getStr()} </p>
	<p>test.sum(10,5) :${test.sum(10,5)} </p>
</body>
</html>