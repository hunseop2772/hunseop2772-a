<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List"%>
<%
	int sum =0;
List<String> list = (List)session.getAttribute("productList");

if(list != null){
	for(String product : list){
		if("그래픽 카드".equals(product)){
			sum+=1300000;
		}else if("닌텐도".equals(product)){
			sum+=400000;
		}else if("모니터".equals(product)){
			sum+=500000;
		}else if("멕북".equals(product)){
			sum+=3800000;
		}else if("페라리".equals(product)){
			sum+=320000000;
		}else if("집".equals(product)){
			sum+=800000000;
		}
	}
%>
	<script>
	if(confirm('<%=sum%>원을 결제하시겠습니까?')){
		alert('결제가 성공적으로 완료되었습니다.\n 장바구니를 초기화합니다.');
		location.href='7_basket_invalid.jsp';
	}else{
		alert('돈이 없군요....');
		history.back();
	}
</script>

<%
}else{
%>
<script>
alert('상품이 없습니다.....');
history.back();
</script>
<%
}
%>