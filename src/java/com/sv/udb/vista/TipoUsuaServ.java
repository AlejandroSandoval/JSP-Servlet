/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.TipoUsuarioCtrl;
import com.sv.udb.modelo.TipoUsuario;
import com.sv.udb.recursos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author joseph
 */
@WebServlet(name = "TipoUsuaServ", urlPatterns = {"/TipoUsuaServ"})
public class TipoUsuaServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
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
                TipoUsuario objeEqui = new TipoUsuario();
                objeEqui.setNombTipoUsua(request.getParameter("nomb_tipo"));
                mens = new TipoUsuarioCtrl().guar(objeEqui) ? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                int CodiTipo = Integer.parseInt(request.getParameter("codiRadioTipo") == null ? 
                        "0" : request.getParameter("codiRadioTipo"));
                TipoUsuario objeEqui = new TipoUsuarioCtrl().cons(CodiTipo);
                if(objeEqui != null)
                {
                    request.setAttribute("codi_tipo", objeEqui.getCodiTipoUsua());
                    request.setAttribute("nomb_tipo", objeEqui.getNombTipoUsua());
                }
            }
            
            else if(CRUD.equals("Modificar")){
                TipoUsuario objeEqui = new TipoUsuario();
                objeEqui.setNombTipoUsua(request.getParameter("nomb_tipo"));
                objeEqui.setCodiTipoUsua(Integer.parseInt(request.getParameter("codi_tipo")));
                mens = new TipoUsuarioCtrl().modi(objeEqui) ? "Datos modificados" : "Datos no modificados";
            }
            
            else if(CRUD.equals("Eliminar")){
                TipoUsuario objeEqui = new TipoUsuario();
                objeEqui.setCodiTipoUsua(Integer.parseInt(request.getParameter("codi_tipo")));
                mens = new TipoUsuarioCtrl().elim(objeEqui) ? "Datos Eliminados" : "Datos no eliminados";
            }
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/TipoUsuario.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/TipoUsuario.jsp");
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
         String text = "some text";
        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(text);
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
