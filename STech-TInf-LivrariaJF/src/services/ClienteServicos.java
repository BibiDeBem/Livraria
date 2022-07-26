/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ClienteDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Usuário
 */
public class ClienteServicos {

    public void cadClienteCpf(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCpf(cVO);
    }

    public void cadClienteCnpj(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCnpj(cVO);
    }

    public ArrayList<Cliente> getClientes() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.buscarClientes();
    }

    public boolean verCPF(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verCPF(cpf);
    }

    public boolean verCNPJ(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verCNPJ(cnpj);
    }

    public Cliente buscarClienteBD(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getByDocBD(cpf);
    }

    public void deletarClienteBD(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.deletarCliente(id);
    }

    public void atualizarClienteBD(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarCliente(cVO);
    }

    public String getNomeCliente(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getNomeCliente(id);
    }

    public int getIdCliente(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getIdCliente(cpf);
    }

    public Cliente buscaClienteCnpjBD(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getByCnpjBD(cnpj);
    }

}
