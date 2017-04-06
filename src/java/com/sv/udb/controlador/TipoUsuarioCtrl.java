/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoUsuario;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gersonfrancisco
 */
public class TipoUsuarioCtrl {
    
    public boolean guar(TipoUsuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO tipo_usuario VALUES(NULL, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombTipoUsua());
            cmd.executeUpdate();
            resp=true;
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
    
    public List<TipoUsuario> consTodo(){
      List <TipoUsuario> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="SELECT * FROM tipo_usuario";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new TipoUsuario(rs.getInt(1), rs.getString(2)));
           }
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
    
    public boolean modi(TipoUsuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE tipo_usuario SET nomb_tipo=? WHERE codi_tipo=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombTipoUsua());
            cmd.setInt(2, obje.getCodiTipoUsua());
            cmd.executeUpdate();
            resp=true;
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
    public boolean elim(TipoUsuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM tipo_usuario WHERE codi_tipo=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiTipoUsua());
            cmd.executeUpdate();
            resp=true;
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
    
    public TipoUsuario cons(int codiTipo)
    {
        TipoUsuario resp = null;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM tipo_usuario WHERE codi_tipo = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiTipo);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp= new TipoUsuario(rs.getInt(1),rs.getString(2));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
}
