/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    Pessoa p1 = new Pessoa("Fulano da Silva", "23/09/1994");
    
    try (PrintWriter out = response.getWriter()) {
      response.setStatus(200);
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"utf-8\" />");
      out.println("<title>ExemploServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1 style=\"color: red\">" + p1.getNome() + "</h1>");
      DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
      out.println("<h2>Nascimento: " + formatador.format(p1.getDtNascimento()) + "</h2>");
      out.println("</body>");
      out.println("</html>");
      out.flush();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }


}
