/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author casso
 */
public class EditoraDAO {
    
    public Editora getByDocBD(String gerente) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        Editora e = new Editora();
        try {
            String sql;
            sql = "select * from Editora where gerente = '" + gerente + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java||lado do banco
                e.setIdEditora(rs.getInt("idEditora"));
                e.setNmEditora(rs.getString("nmEditora"));
                e.setGerente(rs.getString("gerente"));
                e.setTelefone(rs.getString("telefone"));
                e.setEndereco("endereco");

            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este gerente não existe. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return e;
    }
    
      public void deletarEditora(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "delete from editora where idCliente =" + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Editora. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();

        }
    }
      
      public void cadastrarEditora(Editora eVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL

            String sql;
            sql = "insert into editora values(null,'" + eVO.getNmEditora() + "', '"
                    + eVO.getGerente() + "', " + eVO.getTelefone() + ", '"
                    + eVO.getEndereco() + "')";
            //vamos executar o comando  construido na sting aql

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Cliente\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
      
       public ArrayList<Editora> buscarEditoras() throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from editora";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Editora> editoras = new ArrayList<>();
            while (rs.next()) {
                Editora e = new Editora();
                //lado do java||lado do banco
                e.setIdEditora(rs.getInt("idEditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setGerente(rs.getString("gerente"));
                e.setTelefone(rs.getString("telefone"));
                e.setEndereco(rs.getString("endereco"));
                
                editoras.add(e);
            }
            return editoras;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar editoras \n" + e.getMessage());

        } finally {
            stat.close();
            con.close();
        }
    }
       
       public String getNomeEditora(int id) throws SQLException {
        String nomeEditora = null;
        try {
            for (Editora edi : buscarEditoras()) {
                if (edi.getIdEditora() == id) {
                    nomeEditora = edi.getNmEditora();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este id não existe. \n"
                    + e.getMessage());
        }
        return nomeEditora;
    }
       
       public int getIdEditora(String NmEditora) throws SQLException {
        int idEditora = 0;
        try {
            for (Editora edit : buscarEditoras()) {
                System.out.println("teste: " + edit);
                if (edit.getNmEditora() != null && edit.getNmEditora().equals(NmEditora)) {
                    idEditora = edit.getIdEditora();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cpf não existe. \n"
                    + e.getMessage());
        }
        return idEditora;
    }
/*
    
    

    public void atualizarCliente(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update cliente set "
                    + "nomeCliente = '" + cVO.getNomeCliente() + "', "
                    + "cpf = '" + cVO.getCpf() + "', "
                    + "cnpj = " + cVO.getCnpj() + ", "
                    + "endereco = '" + cVO.getEndereco() + "', "
                    + "telefone = '" + cVO.getTelefone() + "' "
                    + "where idCliente = " + cVO.getIdCliente() + "";
            System.out.println(sql);
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Cliente. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public void atualizarClienteCnpj(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update cliente set "
                    + "nomeCliente = '" + cVO.getNomeCliente() + "', "
                    + "cpf = " + cVO.getCpf() + ", "
                    + "cnpj = '" + cVO.getCnpj() + "', "
                    + "endereco = '" + cVO.getEndereco() + "', "
                    + "telefone = '" + cVO.getTelefone() + "' "
                    + "where idCliente = " + cVO.getIdCliente() + "";
            System.out.println(sql);
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Cliente. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public Cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
        Cliente c = new Cliente();
        try {
            switch (cpfCNPJ) {
                case 1:
                    for (Cliente cli : buscarClientes()) {
                        if (cli.getCpf() != null && cli.getCpf().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Cliente cli : buscarClientes()) {
                        if (cli.getCnpj() != null && cli.getCnpj().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Cliente não Encontrado!!!");
                    break;
            }
            return c;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
*/

}
