/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.MarcaCtrl;
import com.sv.udb.modelo.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseph
 */
@WebServlet(name = "MarcaServ", urlPatterns = {"/MarcaServ"})
public class MarcaServ extends HttpServlet {

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
                Marca objeEqui = new Marca();
                objeEqui.setNombMarc(request.getParameter("NombMarc"));
                mens = new MarcaCtrl().guar(objeEqui) ? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                int CodiMarc = Integer.parseInt(request.getParameter("codiMarcRadi") == null ? 
                        "0" : request.getParameter("codiMarcRadi"));
                Marca objeEqui = new MarcaCtrl().cons(CodiMarc);
                if(objeEqui != null)
                {
                    request.setAttribute("CodiMarc", objeEqui.getCodiMarc());
                    request.setAttribute("NombMarc", objeEqui.getNombMarc());
                      
                }
            }
            
            else if(CRUD.equals("Modificar")){
                Marca objeEqui = new Marca();
                objeEqui.setNombMarc(request.getParameter("NombMarc"));
                objeEqui.setCodiMarc(Integer.parseInt(request.getParameter("CodiMarc")));
                mens = new MarcaCtrl().modi(objeEqui) ? "Datos modificados" : "Datos no modificados";
            }
            
            else if(CRUD.equals("Eliminar")){
                Marca objeEqui = new Marca();
                objeEqui.setCodiMarc(Integer.parseInt(request.getParameter("CodiMarc")));
                mens = new MarcaCtrl().elim(objeEqui) ? "Datos Eliminados" : "Datos no eliminados";
            }
            
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/marca.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/piezasbens.jsp");
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
