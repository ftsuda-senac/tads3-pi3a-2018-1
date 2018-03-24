/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CadastroPessoaMVCServlet", urlPatterns = {"/cadastro-pessoa"})
public class CadastroPessoaMVCServlet extends HttpServlet {

  // Carrega o formulário de cadastro na tela do usuário
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    HttpSession sessao = request.getSession();

    Object p1 = sessao.getAttribute("xpto");
    if (p1 != null) {
      // Deve mostrar tela de resultados
      request.setAttribute("xpto", p1);
      sessao.removeAttribute("xpto");
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/pessoa-resultado.jsp");
      dispatcher.forward(request, response);
    } else {
      // Acesso padrão - deve mostrar tela de formulario
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/pessoa-form.jsp");
      dispatcher.forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String dtNascimento = request.getParameter("dtnasc");
    String email = request.getParameter("email");
    String telefone = request.getParameter("telefone");

    Pessoa p1 = new Pessoa(nome, dtNascimento, email, telefone);

    // POST-REDIRECT-GET
    HttpSession sessao = request.getSession();
    sessao.setAttribute("xpto", p1);
    response.sendRedirect(request.getContextPath() + "/cadastro-pessoa");

  }

}
