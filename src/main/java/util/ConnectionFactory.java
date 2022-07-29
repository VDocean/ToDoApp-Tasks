/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author barbara
 */
public class ConnectionFactory {
    // responsavel por realizar a conexao do meu codigo com o banco de dados
    public static final String DRIVER=  "com.mysql.jdbc.Driver"; // jdbc eh o driver que conecta o mysql ao java
    public static final String URL="jdbc:mysql://localhost:3306/todoapp";//local onde meu banco de dados esta, a porta obtenho olhando o xampp
    public static final String USER ="root";// USUARIO DO BANCO DE DADOS, por padrao eh root, mas da pra mudar
    public static final String PASS="";// senha
    
    // o jdbc nao eh uma dependencia padrao do gradle, portanto devo instala-la pegando o jdbc my sql no
    //mvn repository e colando o codigo no arquivo build.gradle
     public static java.sql.Connection getConnection() {
        try {
            Class.forName(DRIVER);// carrega o drive
            return DriverManager.getConnection(URL, USER, PASS);// faz a conexao com o banco de dados
        } catch (Exception ex) { // caso aconteca um erro no try
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
     public static void closeConnection(Connection connection){
     
         try{
             if (connection!=null){
               connection.close();
             }
             
         }catch(Exception ex){
             
             throw new RuntimeException("Erro ao fechar o banco de dados", ex);
         }
     }
     
       public static void closeConnection(Connection connection, PreparedStatement statement){
         // metodos com mesmo nome, mas parametros diferentes
         try{
             if (connection!=null){
               connection.close();
             }
             if (statement != null){
               statement.close(); // fecha o statement
             }
             
         }catch(Exception ex){
             
             throw new RuntimeException("Erro ao fechar o banco de dados", ex);
         }
     }
       
       public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
         // metodos com mesmo nome, mas parametros diferentes
         try{
             if (connection!=null){
               connection.close();
             }
             if (statement != null){
               statement.close(); // fecha o statement
             }
             if (resultSet != null){
               resultSet.close(); // fecha o statement
             }
             
         }catch(Exception ex){
             
             throw new RuntimeException("Erro ao fechar o banco de dados", ex);
         }
     }
    
    
    
}
