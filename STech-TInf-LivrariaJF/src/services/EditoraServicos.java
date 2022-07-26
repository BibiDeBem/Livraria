/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EditoraDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author Usuário
 */
public class EditoraServicos {
    
    public Editora buscaGerenteBD(String editora) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getByDocBD(editora);
    }
    
    public void deletarEditoraBD(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditora(id);
    }
    
    public void cadEditora(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }
    
    public ArrayList<Editora> getEditoras() throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.buscarEditoras();
    }
    
/*
    
    public boolean verEditora(String editora) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.verEditora(editora);
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
*/
}
