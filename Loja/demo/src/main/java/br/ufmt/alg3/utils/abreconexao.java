 package br.ufmt.alg3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class abreconexao {

    
 public static  Connection abreConexao() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:3000/sua_loja",
            "postgres",  
            "123" 
            );
        }
    }