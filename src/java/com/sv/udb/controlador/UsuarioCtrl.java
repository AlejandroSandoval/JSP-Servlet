/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoUsuario;
import com.sv.udb.modelo.Usuario;
import com.sv.udb.recursos.Conexion;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author gersonfrancisco
 */
public class UsuarioCtrl {
    
    private static final String Patron_Correo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public boolean ValidarCorreo(String Corr) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(Patron_Correo);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(Corr);
        return matcher.matches();
 
    }
    
    public String Encriptar(String Pass){
        
        String Resultado = "";
        try{
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        md.update(Pass.getBytes());
        Resultado = String.valueOf(Hex.encodeHex(md.digest())); 
        }
        catch(Exception ex){
            
        }
        return Resultado;
    }
    
    public boolean guar(Usuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO usuario VALUES(NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombUsua());
            cmd.setString(2, obje.getApelUsua());
            cmd.setString(3, obje.getCorrUsua());
            cmd.setString(4, obje.getUserUsua());
            cmd.setString(5, Encriptar(obje.getPassUsua()));
            cmd.setInt(6, obje.getCodiTipo().getCodiTipoUsua());
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
    
    public boolean consUser(String User, int Codigo){
      int cont=0;
      boolean resp= false;
      Connection cn = new Conexion().getConn();
      try{
          if(Codigo==0){
             String Consulta="select * from usuario WHERE user_usua='"+User+"'";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               cont=cont+1;
           }
           if(cont >0){
           resp=true;
          }
          }
          else{
              String Consulta="select * from usuario WHERE user_usua='"+User+"' and codi_usua!="+Codigo;
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               cont=cont+1;
           }
           if(cont >0){
           resp=true;
          }
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
    
    public boolean consCorr(String Corr, int Codigo){
      int cont=0;
      boolean resp= false;
      Connection cn = new Conexion().getConn();
      try{
          if(Codigo==0){
             String Consulta="select * from usuario WHERE corr_usua='"+Corr+"'";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               cont=cont+1;
           }
           if(cont >0){
           resp=true;
          }
          }
          else{
              String Consulta="select * from usuario WHERE corr_usua='"+Corr+"' and codi_usua!="+Codigo;
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               cont=cont+1;
           }
           if(cont >0){
           resp=true;
          }
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
    
    public int UltimoID(){
      int resp= 0;
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select MAX(codi_usua) from usuario";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp = rs.getInt(1);
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
    
    public List<Usuario> consTodo(){
      List <Usuario> resp = new ArrayList<>();
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select a.codi_usua, a.nomb_usua, a.apel_usua, a.corr_usua, a.user_usua, a.pass_usua, b.codi_tipo, "
                   + "b.nomb_tipo from usuario a, tipo_usuario b where\n" 
                   +" a.codi_tipo=b.codi_tipo";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
               new TipoUsuario(rs.getInt("codi_tipo"), rs.getString("nomb_tipo"))));
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
    
    public Usuario cons(int codiUsua)
    {
        Usuario resp = null;
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "select a.codi_usua, a.nomb_usua, a.apel_usua, a.corr_usua, a.user_usua, a.pass_usua, b.codi_tipo, "
                   + "b.nomb_tipo from usuario a, tipo_usuario b where\n" 
                   +" a.codi_tipo=b.codi_tipo and codi_usua = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiUsua);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp= new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
               new TipoUsuario(rs.getInt("codi_tipo"), rs.getString("nomb_tipo")));
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
    
    public boolean modi(Usuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE usuario SET nomb_usua=?, apel_usua=?, corr_usua=?, user_usua=?, codi_tipo=? WHERE codi_usua=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombUsua());
            cmd.setString(2, obje.getApelUsua());
            cmd.setString(3, obje.getCorrUsua());
            cmd.setString(4, obje.getUserUsua());
            cmd.setInt(5, obje.getCodiTipo().getCodiTipoUsua());
            cmd.setInt(6, obje.getCodiUsua());
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
    public boolean elim(Usuario obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM usuario WHERE codi_usua=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiUsua());
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
