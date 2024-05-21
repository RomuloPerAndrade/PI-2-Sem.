package com.mycompany.exemplopdv.dao;

import com.mycompany.exemplopdv.models.Cliente;
import java.sql.Connection;

/**
 *
 * @author romul
 */
public class ClienteDAO {
    
    static String URL = "jdbc:mysql://localhost:3306/exemplopdv";
    static String login = "root";
    static String senha = "adminadmin";
    
    public static boolean salvar(Cliente obj) {
        Connection conexao = null;
        boolean retorno = false;
        
        try {
            
            //1) Carregar o driver do mysql
            Class.forName("com.mysql.cj.jbdc.Driver");
            
            //2) Fazer conexão com o banco
            
        }catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado");
        } catch (Exception e) {
            
        } finally {
            
        }
        
        
        return retorno;
    }

    
}
