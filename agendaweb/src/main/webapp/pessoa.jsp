<%@page import="br.senac.tads.pi3a.agendaweb.Pessoa" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
Pessoa p1 = new Pessoa("Ciclano de Souza", "14/12/1992");
request.setAttribute("xpto", p1);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1><c:out value="${xpto.nome}" /></h1>
    <h2>Data de nascimento:
      <fmt:formatDate value="${xpto.dtNascimento}" pattern="dd/MM/yyyy" /></h2>
  </body>
</html>
