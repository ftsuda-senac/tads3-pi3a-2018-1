<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Lista de nomes</h1>
    <h3>JSESSIONID = <c:out value="${pageContext.request.session.id}" /></h3>
    <form action="${pageContext.request.contextPath}/exemplo-sessao" method="post">
      <div>
	<label>Nome</label>
	<div>
	  <input type="text" name="nome" />
	</div>
      </div>
      <button type="submit">Enviar</button>
    </form>
    <c:if test="${not empty sessionScope.pessoas}">
      <div>
	<h2>Nomes preenchidos</h2>
	<ul>
	  <c:forEach items="${sessionScope.pessoas}" var="p">
	    <li><c:out value="${p}" /></li>
	    </c:forEach>
	</ul>
      </div>
    </c:if>
  </body>
</html>
