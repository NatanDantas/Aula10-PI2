package com.mycompany.datas.aula10.dao;

import com.mycompany.datas.aula10.model.NotaFiscal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaFiscalDAO {

    public static boolean salvar(NotaFiscal obj) throws SQLException{
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "basenotafiscal", "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO notafiscal "
                    + "(numeroNota, valorNota, dataNota) "
                    + "VALUES (?,?,?)" );
            
            comandoSQL.setInt(1, obj.getNumeroNota());
            comandoSQL.setDouble(2, obj.getValorNota());
            comandoSQL.setDate(3, new java.sql.Date(obj.getDataNota().getTime()));
            
            int LinhasAfetadas = comandoSQL.executeUpdate();
            
            if(LinhasAfetadas > 0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        }
        
        
        return  retorno;
    }
}
