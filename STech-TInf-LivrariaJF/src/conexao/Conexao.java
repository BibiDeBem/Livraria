/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class Conexao {
//cria uma constante com endereço do BD e schema

    private static String url = "jdbc:mysql://localhost:3306/livrariam211";
    //cria uma constante com o user de conexão do banco
    private static String user = "root";
    //cria uma constante com a senha de acesso ao BD
    private static String pass = "";

    public static Connection getConexao() throws SQLException {
        // Iniciar conexão nula, ainda não estabelecida
        Connection c = null;
        // tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
            // Caso haja falha na conexão, gera uma conexão
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar! /n" + e.getMessage());
        }
        return c;
        /*
        SIGLAS
        • VO = Value Object - Objeto de valor
        • DAO = Data Access Object - Acesso aos dados do objeto
        • Factory = Fábrica
        
        Dentro dessa classe DAO colocaremos todos os códigos de SQL DML(Data
        manipulation language), ou seja, vamos colocar os seguintes códigos:
        • insert
        • select
        • update
        • delete
         */
    }
}
