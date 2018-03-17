/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agendaweb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Pessoa {

  private String nome;

  private Date dtNascimento;

  public Pessoa() {
  }

  public Pessoa(String nome, String dtNascimentoStr) {
    this.nome = nome;
    DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.dtNascimento = formatador.parse(dtNascimentoStr);
    } catch (ParseException e) {

    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(Date dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

}
