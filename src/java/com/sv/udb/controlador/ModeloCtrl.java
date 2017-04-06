/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.controlador;

import com.sv.udb.modelo.Marca;
import com.sv.udb.modelo.Modelo;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class ModeloCtrl {
    public boolean guar(Modelo obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO modelo VALUES(NULL, ?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombMode());
            cmd.setDouble(2, obje.getPrecioMode());
            cmd.setInt(3, obje.getCodiMarc().getCodiMarc());
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
    
    public boolean modi(Modelo obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE modelo SET  nomb_mode=?, prec_mode=?,codi_marc=? WHERE codi_mode=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombMode());
            cmd.setDouble(2, obje.getPrecioMode());
            cmd.setInt(3, obje.getCodiMarc().getCodiMarc());
            cmd.setInt(4, obje.getCodiMode());
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
    
    public boolean elim(Modelo obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM modelo WHERE codi_mode=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiMode());
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
    
    public List<Modelo> consTodo(){
      List <Modelo> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="SELECT a.codi_mode, a.nomb_mode, a.prec_mode, b.codi_marc, b.nomb_marc FROM modelo a, marca b WHERE a.codi_marc = b.codi_marc";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Modelo(rs.getInt(1), rs.getString(2), rs.getDouble(3), new Marca(rs.getInt("codi_marc"), rs.getString("nomb_marc"))));
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
}
