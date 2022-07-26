/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Usuário
 */
public class DAOFactory {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static ClienteDAO getClienteDAO(){
        return clienteDAO;
    }

    private static EditoraDAO editoraDAO = new EditoraDAO();
    
    public static EditoraDAO getEditoraDAO(){
        return editoraDAO;
    }
}
