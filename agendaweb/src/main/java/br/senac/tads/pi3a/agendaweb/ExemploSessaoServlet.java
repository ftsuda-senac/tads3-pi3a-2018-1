/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ExemploSessaoServlet", urlPatterns = {"/exemplo-sessao"})
public class ExemploSessaoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, 
	  HttpServletResponse response)
	  throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp")
	    .forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    String nome = request.getParameter("nome");
    if (nome != null && !nome.trim().isEmpty()) {
      
      // Adicionar na lista
      HttpSession sessao = request.getSession();
      if (sessao.getAttribute("pessoas") == null) {
	sessao.setAttribute("pessoas", new ArrayList<String>());
      }
      List<String> pessoas = 
	      (List<String>) sessao.getAttribute("pessoas");
      pessoas.add(nome);
      sessao.setAttribute("pessoas", pessoas);
    }
    request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp")
	    .forward(request, response);

  }

}
