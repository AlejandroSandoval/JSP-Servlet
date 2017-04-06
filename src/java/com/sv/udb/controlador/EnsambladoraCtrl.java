/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.controlador;

import com.sv.udb.modelo.Ensambladora;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class EnsambladoraCtrl {
    
    public boolean guar(Ensambladora obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO ensambladora VALUES(NULL, ?,?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombEnsa());
            cmd.setString(2, obje.getDireEnsa());
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
    
    public boolean modi(Ensambladora obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE ensambladora SET nomb_ensa=?, dire_ensa=? WHERE codi_ensa=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombEnsa());
            cmd.setString(2, obje.getDireEnsa());
            cmd.setInt(3, obje.getCodiEnsa());
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
    
    public boolean elim(Ensambladora obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM ensambladora WHERE codi_ensa=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiEnsa());
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
 
    public List<Ensambladora> consTodo(){
      List <Ensambladora> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="SELECT * FROM ensambladora";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Ensambladora(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
    
    
    public Ensambladora cons(int codiEnsa)
    {
        Ensambladora resp = null;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "SELECT * FROM ensambladora WHERE codi_ensa = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiEnsa);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp= new Ensambladora(rs.getInt(1),rs.getString(2),rs.getString(3));
                //resp = new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3),, rs.getString(4));
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

