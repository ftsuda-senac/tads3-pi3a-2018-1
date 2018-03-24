<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo Servlet + JSP em conjunto</h1>
    <hr />
    <h2><c:out value="${xpto.nome}" /></h2>
    <p>Data de nascimento:
      <fmt:formatDate value="${xpto.dtNascimento}" pattern="dd/MM/yyyy" /></p>
  </body>
</html>
