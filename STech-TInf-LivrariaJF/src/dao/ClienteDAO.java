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
import model.Cliente;

/**
 *
 * @author casso
 */
public class ClienteDAO {

    public void cadastrarClienteCpf(Cliente cVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL

            String sql;
            sql = "insert into cliente values(null,'" + cVO.getNomeCliente() + "','" + cVO.getCpf() + "',"
                    + cVO.getCnpj() + ",'" + cVO.getEndereco() + "','"
                    + cVO.getTelefone() + "')";
            //vamos executar o comando  construido na sting aql

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Cliente\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public void cadastrarClienteCnpj(Cliente cVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL

            String sql;
            sql = "insert into cliente values(null,'" + cVO.getNomeCliente() + "'," + cVO.getCpf() + ",'"
                    + cVO.getCnpj() + "','" + cVO.getEndereco() + "','"
                    + cVO.getTelefone() + "')";
            //vamos executar o comando  construido na sting aql

            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Cliente\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public ArrayList<Cliente> buscarClientes() throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from cliente";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                //lado do java||lado do banco
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("nomeCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
           
                clientes.add(c);
            }
            return clientes;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar clientes \n" + e.getMessage());

        } finally {
            stat.close();
            con.close();
        }
    }

    public boolean verCPF(String cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        boolean verCPF = true;

        try {
            String sql;
            sql = "select cpf from cliente where cpf = '" + cpf + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verCPF = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe. \n" + e.getMessage());

        } finally {
            con.close();
            stat.close();
        }
        return verCPF;
    }

    public boolean verCNPJ(String cnpj) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        boolean verCNPJ = true;

        try {
            String sql;
            sql = "select cpf from cliente where cnpj = '" + cnpj + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verCNPJ = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe. \n" + e.getMessage());

        } finally {
            con.close();
            stat.close();
        }
        return verCNPJ;
    }

    public void deletarCliente(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "delete from cliente where idCliente =" + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Cliente. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();

        }
    }
public String getNomeCliente(int id) throws SQLException {
        String nomeCliente = null;
        try {
            for (Cliente cli : buscarClientes()) {
                if (cli.getIdCliente() == id) {
                    nomeCliente = cli.getNomeCliente();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id não existe. \n"
                    + e.getMessage());
        }
        return nomeCliente;
    }

    public int getIdCliente(String cpf) throws SQLException {
        int idCliente = 0;
        try {
            for (Cliente cli : buscarClientes()) {
                System.out.println("teste: "+cli);
                if (cli.getCpf()!= null && cli.getCpf().equals(cpf)) {             
                    idCliente = cli.getIdCliente();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cpf não existe. \n"
                    + e.getMessage());
        }
        return idCliente;
    }

    public String getCPFCliente(int id) throws SQLException {
        String cpf = null;
        try {
            for (Cliente cli : buscarClientes()) {
                if (cli.getIdCliente() == id) {
                    cpf = cli.getCpf();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cpf não existe. \n"
                    + e.getMessage());
        }
        return cpf;
    }

    public String getCNPJCliente(int id) throws SQLException {
        String cnpj = null;
        try {
            for (Cliente cli : buscarClientes()) {
                if (cli.getIdCliente() == id) {
                    cnpj = cli.getCnpj();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cnpj não existe. \n"
                    + e.getMessage());
        }
        return cnpj;
    }

    public Cliente getByDocBD(String cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        Cliente c = new Cliente();
        try {
            String sql;
            sql = "select * from Cliente where cpf = '" + cpf + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java||lado do banco
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("nomeCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco("endereco");
                c.setTelefone(rs.getString("telefone"));
                c.setCnpj(rs.getString("cnpj"));

            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este CPF não existe. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return c;
    }

    public Cliente getByCnpjBD(String cnpj) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        Cliente c = new Cliente();
        try {
            String sql;
            sql = "select * from Cliente where cnpj = '" + cnpj + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java||lado do banco
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("nomeCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco("endereco");
                c.setTelefone(rs.getString("telefone"));
                c.setCnpj(rs.getString("cnpj"));

            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cnpj não existe. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return c;
    }

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

}
