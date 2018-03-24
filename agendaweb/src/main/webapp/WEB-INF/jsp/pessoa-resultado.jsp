<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<title>Sucesso!</title>
</head>
<body>
	<div class="data-container">
	<div class="success-container">
		<div>
		  <h1><c:out value="${xpto.nome}" /> FOI SALVO COM SUCESSO!!</h1>
		  <p>Data nascimento: <fmt:formatDate value="${xpto.dtNascimento}" pattern="dd/MM/yyyy" /></p>
		  <p>E-mail: <c:out value="${xpto.email}" /></p>
		  <p>Telefone: <c:out value="${xpto.telefone}" /></p>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/cadastro-pessoa">Voltar</a>
		</div>		
	</div>	
	</div>
</body>
</html>