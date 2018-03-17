/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploServlet", urlPatterns = {"/xpto"})
public class ExemploServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String mensagem = "Primeiro exemplo";

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
      out.println("<h1 style=\"color: red\">" + mensagem + "</h1>");
      out.println("</body>");
      out.println("</html>");
      out.flush();
    }

  }

}
