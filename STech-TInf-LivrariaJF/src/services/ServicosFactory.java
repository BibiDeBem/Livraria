/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Usuário
 */
public class ServicosFactory {
    private static ClienteServicos clienteServicos = new ClienteServicos();
    
    public static ClienteServicos getClienteServicos(){
        return clienteServicos;
    }
    
    private static EditoraServicos editoraServicos = new EditoraServicos();
    
    public static EditoraServicos getEditoraServicos(){
        return editoraServicos;
    }
   
}
