package com.mycompany.exemplopdv.dao;

import com.mycompany.exemplopdv.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            conexao = DriverManager.getConnection(URL, login, senha );
            
            //3) Preparar o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
            "INSERT INTO cliente (nomeCliente, cpf, emailCliente) VALUES (?,?,?);"
            );
                                      
            instrucaoSQL.setString(1, obj.getNomeCliente());
            instrucaoSQL.setString(2, obj.getCPF());
            instrucaoSQL.setString(3, obj.getEmailCliente());
            
            //4) Executar o comando
             int linhasAfetadas = instrucaoSQL.executeUpdate();
             
             if (linhasAfetadas>0){
                 retorno = true;
             }                                        
            
        }catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return retorno;
    }

    
}
