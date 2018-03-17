<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
String mensagem = "Primeiro exemplo JSP";  
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
<%
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0) {
%>
    <h1 style="color: red"><%= i %> - <%= mensagem %></h1>
<%
      } else {
%>
    <h1 style="color: blue"><%= i %> - <%= mensagem %></h1>
<%
      }
    }
%>
  </body>
</html>
