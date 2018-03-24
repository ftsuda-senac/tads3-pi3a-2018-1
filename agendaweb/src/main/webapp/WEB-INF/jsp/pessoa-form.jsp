<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Agenda WEB</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
  <form action="${pageContext.request.contextPath}/cadastro-pessoa" method="post">
            <div class="data-container">
                <div>
                    <div>
                    Nome: <input type="text" name="nome"/> 
                </div>
                <div>
                    Data de nascimento: <input type="text" name="dtnasc"/>
                </div>
                <div>
                    E-mail: <input type="text" name="email"/>
                </div>
                <div>
                    Telefone: <input type="text" name="telefone"/>
                </div>
                <div>
                    <button type="submit">Enviar</button>
                </div>
                </div>
            </div>
        </form>
</body>
</html>