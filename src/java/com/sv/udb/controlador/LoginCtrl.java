/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoUsuario;
import com.sv.udb.modelo.Usuario;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gersonfrancisco
 */
public class LoginCtrl {
    
    public static int CodiSesion;
    
    public boolean consDatos(String User, String Pass){
      int cont=0;
      boolean resp= false;
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select * from usuario WHERE user_usua='"+User+"' and pass_usua='"+Pass+"'";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               CodiSesion = rs.getInt(1);
               cont++;
           }
           if(cont >0){resp=true;}
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;  
    }
}
