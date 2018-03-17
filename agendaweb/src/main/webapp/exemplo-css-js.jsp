<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String mensagem = "Exemplo JSP + JSTL";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="estilos.css" />

    <script>
      window.onload = function() {
	alert("teste");
      }
    </script>
  </head>
  <body>
    <c:forEach begin="1" end="100" varStatus="contador">
      <c:choose>
	<c:when test="${contador.index % 2 == 0}">
	  <h1 style="color: red"><c:out value="${contador.index}" /> - <%= mensagem%></h1>
	</c:when>
	<c:otherwise>
	  <h1 style="color: blue"><c:out value="${contador.index}" /> - <%= mensagem%></h1>
	</c:otherwise>
      </c:choose>
    </c:forEach>
  </body>
</html>
