/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Lote;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gersonfrancisco
 */
public class LoteCtrl {
    public boolean guar(Lote obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO lote VALUES(NULL, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiEnsa().getCodiEnsa());
            cmd.setInt(2, obje.getCodiEnca().getCodiEnca());
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
    
    public int consMaxLote(){
      int cont=0;
      boolean resp= false;
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select max(codi_lote) from lote";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               cont=rs.getInt(1);
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
        return cont;  
    }
    
}
