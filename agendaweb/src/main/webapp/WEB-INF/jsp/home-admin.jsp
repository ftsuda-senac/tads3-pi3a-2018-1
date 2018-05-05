<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Página Home ADMIN - Usuario RALE não pode acessar esta tela</h1>
    <c:if test="${sessionScope.usuario.verificarPapel('FODA')}">
      <p>Usuário com Papel FODA pode ver esta mensagem</p>
    </c:if>
    <c:if test="${sessionScope.usuario.verificarPapel('GOD')}">
      <p>Usuário com Papel GOD pode ver esta mensagem</p>
    </c:if>
  </body>
</html>
