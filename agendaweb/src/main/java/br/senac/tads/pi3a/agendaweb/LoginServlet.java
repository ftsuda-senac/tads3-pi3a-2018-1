/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  
  // Apresentar o formulário de Login
  @Override
  protected void doGet(HttpServletRequest request, 
	  HttpServletResponse response)
	  throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
	    .forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, 
	  HttpServletResponse response)
	  throws ServletException, IOException {
    String username = request.getParameter("username");
    String senha = request.getParameter("senha");
    
    // Validar as informações
    if ("fulano".equals(username) && "abcd1234".equals(senha)) {
      UsuarioSistema usuario = new  UsuarioSistema("fulano", 
	      "Fulano da Silva", 
	      "abcd1234", 
	      Arrays.asList(new Papel("BASICO")));
      HttpSession sessao = request.getSession();
      sessao.setAttribute("usuario", usuario);
      response.sendRedirect(request.getContextPath() + "/exemplo-sessao");
    } else {
      request.setAttribute("msgErro", "Usuário ou senha inválido");
      request.getRequestDispatcher("WEB-INF/jsp/erro-login.jsp")
	      .forward(request, response);
    }
    
    
  }

}
