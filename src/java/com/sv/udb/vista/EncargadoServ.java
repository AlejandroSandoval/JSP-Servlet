/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.UsuarioCtrl;
import com.sv.udb.controlador.EncargadoCtrl;
import com.sv.udb.modelo.TipoUsuario;
import com.sv.udb.modelo.Usuario;
import com.sv.udb.modelo.Encargado;
import com.sv.udb.modelo.Escuela;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aleso
 */
@WebServlet(name = "EncargadoServ", urlPatterns = {"/EncargadoServ"})
public class EncargadoServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("cursBton");
            if(CRUD.equals("Guardar"))
            {
                if(!new UsuarioCtrl().consUser(request.getParameter("user_usua"), 0)){
                    if(!new UsuarioCtrl().consCorr(request.getParameter("corr_usua"), 0)){
                        if(request.getParameter("pass_usua").equals(request.getParameter("confi_usua"))){
                            Usuario Usua = new Usuario();
                            TipoUsuario TipoUsua = new TipoUsuario();
                            TipoUsua.setCodiTipoUsua(2);
                            Usua.setCodiTipo(TipoUsua);
                            Usua.setNombUsua(request.getParameter("nomb_usua"));
                            Usua.setApelUsua(request.getParameter("apel_usua"));
                            Usua.setCorrUsua(request.getParameter("corr_usua"));
                            Usua.setUserUsua(request.getParameter("user_usua"));
                            Usua.setPassUsua(request.getParameter("pass_usua"));
                            if(Usua != null)
                            {
                               new UsuarioCtrl().guar(Usua);
                               Encargado Enca = new Encargado();
                               Escuela Escu = new Escuela();
                               Escu.setCodiEscu(Integer.parseInt(request.getParameter("codi_escu")));
                               Enca.setCodiEscu(Escu);
                               Enca.setDuiEnca(request.getParameter("dui_enca"));
                               Enca.setTeleEnca(Integer.parseInt(request.getParameter("tele_enca")));
                               if(Enca != null)
                               {
                                   mens = new EncargadoCtrl().guar(Enca) ? "Datos guardados" : "Datos NO guardados";
                               }
                            }
                        }
                else{
                    mens = "Las contraseñas no coinciden.";
                }
                }
                else{
                    mens = "Este Correo electronico ya ha sido ingresado.";
                }
                }
                else{
                    mens = "Este Username ya ha sido ingresado.";
                }
            }
            else if(CRUD.equals("Modificar"))
            {
                if(!new UsuarioCtrl().consUser(request.getParameter("user_usua"), Integer.parseInt(request.getParameter("codi_usua")))){
                if(!new UsuarioCtrl().consCorr(request.getParameter("corr_usua"), Integer.parseInt(request.getParameter("codi_usua")))){
                Usuario Usua = new Usuario();
                TipoUsuario TipoUsua = new TipoUsuario();
                TipoUsua.setCodiTipoUsua(2);
                Usua.setCodiTipo(TipoUsua);
                Usua.setCodiUsua(Integer.parseInt(request.getParameter("codi_usua")));
                Usua.setNombUsua(request.getParameter("nomb_usua"));
                Usua.setApelUsua(request.getParameter("apel_usua"));
                Usua.setCorrUsua(request.getParameter("corr_usua"));
                Usua.setUserUsua(request.getParameter("user_usua"));
                if(Usua != null)
                {
                    new UsuarioCtrl().modi(Usua);
                    Encargado Enca = new Encargado();
                    Escuela Escu = new Escuela();
                    Escu.setCodiEscu(Integer.parseInt(request.getParameter("codi_escu")));
                    Enca.setCodiEscu(Escu);
                    Enca.setDuiEnca(request.getParameter("dui_enca"));
                    Enca.setTeleEnca(Integer.parseInt(request.getParameter("tele_enca")));
                    Enca.setCodiEnca(Integer.parseInt(request.getParameter("codi_enca")));
                    if(Enca != null)
                    {
                        mens = new EncargadoCtrl().modi(Enca) ? "Datos modificados" : "Datos NO modificados";
                    }
                }
                }
                else{
                    mens = "Este Correo electronico ya ha sido ingresado.";
                }
                }
                else{
                    mens = "Este Username ya ha sido ingresado.";
                }
            }
            else if(CRUD.equals("Eliminar"))
            {
                Encargado Enca = new Encargado();
                Enca.setCodiEnca(Integer.parseInt(request.getParameter("codi_enca")));
                Usuario Usua = new Usuario();
                Usua.setCodiUsua(Integer.parseInt(request.getParameter("codi_usua")));
                if(Enca != null)
                {
                    new EncargadoCtrl().elim(Enca);
                    mens = new UsuarioCtrl().elim(Usua) ? "Datos eliminados" : "Datos NO eliminados";
                }
            }
            else if(CRUD.equals("Consultar"))
            {
                int codi_enca = Integer.parseInt(request.getParameter("codiRadioUsua") == null ? "0" : request.getParameter("codiRadioUsua"));
                Encargado Enca = new EncargadoCtrl().cons(codi_enca);
                if(Enca != null)
                {
                    request.setAttribute("codi_enca", codi_enca);
                    request.setAttribute("codi_usua", Enca.getCodiUsua().getCodiUsua());
                    request.setAttribute("codi_escu", Enca.getCodiEscu().getCodiEscu());
                    request.setAttribute("nomb_usua", Enca.getCodiUsua().getNombUsua());
                    request.setAttribute("apel_usua", Enca.getCodiUsua().getApelUsua());
                    request.setAttribute("corr_usua", Enca.getCodiUsua().getCorrUsua());
                    request.setAttribute("user_usua", Enca.getCodiUsua().getUserUsua());
                    request.setAttribute("pass_usua", 1);
                    request.setAttribute("dui_enca", Enca.getDuiEnca());
                    request.setAttribute("tele_enca", Enca.getTeleEnca());
                }
            }
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/encargado.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/encargado.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
