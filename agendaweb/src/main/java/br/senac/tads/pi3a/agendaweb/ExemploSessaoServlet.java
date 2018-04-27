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
    // Recupera o nome enviado na requisicao
    String nome = request.getParameter("nome");
    
    // Verifica se nome eh valido
    if (nome != null && !nome.trim().isEmpty()) {
      
      // Cria ou recupera a sessao do usuario
      HttpSession sessao = request.getSession();
      if (sessao.getAttribute("pessoas") == null) {
	// Se nao existir, adiciona uma nova lista vazia na sessao
	sessao.setAttribute("pessoas", new ArrayList<String>());
      }
      // Recupera a lista de nomes da sessao
      List<String> pessoas = 
	      (List<String>) sessao.getAttribute("pessoas");
      // Adiciona o nome na lista e salva como atributo na sessao
      pessoas.add(nome);
      sessao.setAttribute("pessoas", pessoas);
    }
    request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp")
	    .forward(request, response);

  }

}
