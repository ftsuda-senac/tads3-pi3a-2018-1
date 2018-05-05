/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistemaService {

  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS
	  = new LinkedHashMap<>();

  static {
    USUARIOS_CADASTRADOS.put("fulano", new UsuarioSistema("fulano",
	    "Fulano da Silva", "abcd1234",
	    Arrays.asList(new Papel("RALE"))));
    USUARIOS_CADASTRADOS.put("ciclano", new UsuarioSistema("ciclano",
	    "Ciclano de Souza", "abcd1234",
	    Arrays.asList(new Papel("RALE"), new Papel("FODA"))));
    USUARIOS_CADASTRADOS.put("beltrana", new UsuarioSistema("beltrana",
	    "Beltrana das Cruzes", "abcd1234",
	    Arrays.asList(new Papel("RALE"), new Papel("GOD"))));
  }
  
  public UsuarioSistema buscarPorUsername(String username) {
    return USUARIOS_CADASTRADOS.get(username);
  }
}
