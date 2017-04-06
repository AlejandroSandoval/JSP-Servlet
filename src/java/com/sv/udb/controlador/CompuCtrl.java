/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Computadora;
import com.sv.udb.modelo.Encargado;
import com.sv.udb.modelo.Lote;
import com.sv.udb.modelo.Marca;
import com.sv.udb.modelo.Modelo;
import com.sv.udb.modelo.Usuario;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gersonfrancisco
 */
public class CompuCtrl {
    public boolean guar(Computadora obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO computadora VALUES(NULL, ?, ?, ?, ? ,?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getFechFabr());
            cmd.setString(2, obje.getNumeSeri());
            cmd.setInt(3, obje.getEstaCompu());
            cmd.setInt(4, obje.getCodiMode().getCodiMode());
            cmd.setInt(5, new LoteCtrl().consMaxLote());
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
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select max(codi_comp) from computadora";
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
    
     public List<Computadora> consTodo(Encargado obje){
      List <Computadora> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select * from computadora w INNER JOIN modelo r on w.codi_mode = r.codi_mode INNER JOIN marca y on r.codi_marc = y.codi_marc INNER JOIN lote q on w.codi_lote = q.codi_lote INNER JOIN encargado o on q.codi_enca = o.codi_enca and q.codi_enca = ?";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           cmd.setInt(1, obje.getCodiEnca());
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Computadora(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new Modelo(rs.getInt("codi_mode"), rs.getString("nomb_mode"), rs.getDouble("prec_mode"), new Marca(rs.getInt("codi_marc"), rs.getString("nomb_marc"))), new Lote(rs.getInt("codi_lote"), null, null)));
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
