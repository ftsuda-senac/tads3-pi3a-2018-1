/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter", 
	urlPatterns = {"/admin/*"},
	servletNames = {"HomeServlet", "ExemploSessaoServlet"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig)
	  throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response,
	  FilterChain chain)
	  throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sessao = httpRequest.getSession();

    // 1) Verificar se usuario esta autenticado
    if (sessao.getAttribute("usuario") == null) {
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
      return;
    }

    UsuarioSistema usuario = (UsuarioSistema) sessao.getAttribute("usuario");

    // 2) Usuario logado, verifica se tem autorizacao para acessar recurso
    if (verificarAcesso(usuario, httpRequest, httpResponse)) {
      // Acesso ao recurso está liberado
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem autorizacao para acessar pagina
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
    }

  }

  private static boolean verificarAcesso(UsuarioSistema usuario,
	  HttpServletRequest request, HttpServletResponse response) {
    String paginaAcessada = request.getRequestURI();
    String pagina = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.startsWith("/home")
	    && usuario.verificarPapel("RALE")) {
      return true;
    } else if (pagina.startsWith("/admin/")
	    && usuario.verificarPapel("FODA")) {
      return true;
    }
    return false;
  }

  @Override
  public void destroy() {

  }

}
