/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
public class Agenda {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {

        // 1A) Registrar driver JDBC
        Class.forName("com.mysql.jdbc.Driver");

        // 1B) Abrir conexão com DB
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/agendabd", "root", "");
    }

    public List<Pessoa> consultar() throws ClassNotFoundException, SQLException {

        // 2) Escrever a lógica para executar algum comando no banco
        String query = "SELECT id, nome, dtnascimento FROM pessoa";

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            try (ResultSet resultados = stmt.executeQuery()) {

                while (resultados.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(resultados.getLong("id"));
                    p.setNome(resultados.getString("nome"));
                    p.setDtNascimento(resultados.getDate("dtnascimento"));
                    lista.add(p);
//                    long id = resultados.getLong("id");
//                    String nome = resultados.getString("nome");
//                    Date dtNascimento = resultados.getDate("dtnascimento");
//
//                    System.out.println(id + ", " + nome + ", " + dtNascimento);
                }
            }

        } catch (Exception e) {

        }

        // 3) Fechar conexão (tratado pelo try acima - try-with-resources)
        return lista;
    }

    public void incluir(Pessoa p) throws ClassNotFoundException, SQLException {

        String query = "INSERT INTO pessoa (nome, dtnascimento) VALUES (?, ?)";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, p.getNome());
//            String strDtNascimento = "1970-05-15";
//            DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
//            Date dtNascimento = formatadorData.parse(strDtNascimento);
            stmt.setDate(2, new java.sql.Date(p.getDtNascimento().getTime()));

            stmt.executeUpdate();

        }

    }

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        try {
            // 1) Inclusao
            Pessoa p1 = new Pessoa();
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Digite o nome:");
                String nome = in.nextLine();
                p1.setNome(nome);
                System.out.println("Digite a data de nascimento no formato ano-mês-dia;");
                String dtNasc = in.nextLine();
                DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
                p1.setDtNascimento(formatadorData.parse(dtNasc));
            }
            agenda.incluir(p1);

            // 2) Consulta
            List<Pessoa> lista = agenda.consultar();
            for (Pessoa p : lista) {
                System.out.println(p.getId() + ", " + p.getNome()
                        + ", " + p.getDtNascimento());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
