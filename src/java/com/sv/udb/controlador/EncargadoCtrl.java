/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Encargado;
import com.sv.udb.modelo.Escuela;
import com.sv.udb.modelo.Usuario;
import com.sv.udb.controlador.UsuarioCtrl;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gersonfrancisco
 */
public class EncargadoCtrl {
    
    public boolean guar(Encargado obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO encargado VALUES(NULL, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getDuiEnca());
            cmd.setInt(2, obje.getTeleEnca());
            cmd.setInt(3, obje.getCodiEscu().getCodiEscu());
            int codi = new UsuarioCtrl().UltimoID();
            cmd.setInt(4, codi);
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
    
    public List<Encargado> consTodo(){
      List <Encargado> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select a.codi_enca, a.dui_enca, a.tele_enca, b.codi_escu, b.nomb_escu, b.dire_escu, u.codi_usua, u.nomb_usua, u.apel_usua, u.corr_usua, u.user_usua, u.pass_usua from encargado a, escuela b, usuario u where a.codi_escu=b.codi_escu and a.codi_usua = u.codi_usua";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Encargado(rs.getInt(1), rs.getString(2), rs.getInt(3), new Escuela(rs.getInt("codi_escu"), rs.getString("nomb_escu"),rs.getString("dire_escu")), new Usuario(rs.getInt("codi_usua"), rs.getString("nomb_usua"), rs.getString("apel_usua"), rs.getString("corr_usua"), rs.getString("user_usua"), rs.getString("pass_usua"),null)));
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
    
     public List<Encargado> consTodoCmb(int codi_escu){
      List <Encargado> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select a.codi_enca, a.dui_enca, a.tele_enca, b.codi_escu, b.nomb_escu, b.dire_escu, u.codi_usua, u.nomb_usua, u.apel_usua, u.corr_usua, u.user_usua, u.pass_usua from encargado a, escuela b, usuario u where a.codi_escu=b.codi_escu and a.codi_usua = u.codi_usua where a.codi_escu = ?";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           cmd.setInt(1, codi_escu);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Encargado(rs.getInt(1), rs.getString(2), rs.getInt(3), new Escuela(rs.getInt("codi_escu"), rs.getString("nomb_escu"),rs.getString("dire_escu")), new Usuario(rs.getInt("codi_usua"), rs.getString("nomb_usua"), rs.getString("apel_usua"), rs.getString("corr_usua"), rs.getString("user_usua"), rs.getString("pass_usua"),null)));
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
    
    public Encargado cons(int codi_enca){
      Encargado resp = null;
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select a.codi_enca, a.dui_enca, a.tele_enca, b.codi_escu, "
                   + "b.nomb_escu, b.dire_escu, u.codi_usua, u.nomb_usua, u.apel_usua, u.corr_usua, u.user_usua, u.pass_usua from encargado a, escuela b, usuario u where\n" 
                   +" a.codi_escu=b.codi_escu and a.codi_usua = u.codi_usua and a.codi_enca = ?";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, codi_enca);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp= new Encargado(rs.getInt(1), rs.getString(2), rs.getInt(3), new Escuela(rs.getInt("codi_escu"), rs.getString("nomb_escu"),rs.getString("dire_escu")), new Usuario(rs.getInt("codi_usua"), rs.getString("nomb_usua"), rs.getString("apel_usua"), rs.getString("corr_usua"), rs.getString("user_usua"), rs.getString("pass_usua"),null));
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
    
    public boolean modi(Encargado obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE encargado SET dui_enca=?, tele_enca=?, codi_escu=? WHERE codi_enca=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getDuiEnca());
            cmd.setInt(2, obje.getTeleEnca());
            cmd.setInt(3, obje.getCodiEscu().getCodiEscu());
            cmd.setInt(4, obje.getCodiEnca());
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
    public boolean elim(Encargado obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM encargado WHERE codi_enca=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiEnca());
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
}
