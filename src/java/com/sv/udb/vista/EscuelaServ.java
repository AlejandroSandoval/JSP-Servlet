/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.EscuelaCtrl;
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
 * @author joseph
 */
@WebServlet(name = "EscuelaServ", urlPatterns = {"/EscuelaServ"})
public class EscuelaServ extends HttpServlet {

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
                Escuela objeEqui = new Escuela();
                objeEqui.setNombEscu(request.getParameter("NombEscu"));
                objeEqui.setDireEscu(request.getParameter("DireEscu"));
                mens = new EscuelaCtrl().guar(objeEqui) ? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                int CodiEscu = Integer.parseInt(request.getParameter("codiEscuRadi") == null ? 
                        "0" : request.getParameter("codiEscuRadi"));
                Escuela objeEqui = new EscuelaCtrl().cons(CodiEscu);
                if(objeEqui != null)
                {
                    request.setAttribute("CodiEscu", objeEqui.getCodiEscu());
                    request.setAttribute("NombEscu", objeEqui.getNombEscu());
                    request.setAttribute("DireEscu", objeEqui.getDireEscu());
                      
                }
            }
            
            else if(CRUD.equals("Modificar")){
                Escuela objeEqui = new Escuela();
                objeEqui.setNombEscu(request.getParameter("NombEscu"));
                objeEqui.setDireEscu(request.getParameter("DireEscu"));
                objeEqui.setCodiEscu(Integer.parseInt(request.getParameter("CodiEscu")));
                mens = new EscuelaCtrl().modi(objeEqui) ? "Datos modificados" : "Datos no modificados";
            }
            
            else if(CRUD.equals("Eliminar")){
                Escuela objeEqui = new Escuela();
                objeEqui.setCodiEscu(Integer.parseInt(request.getParameter("CodiEscu")));
                mens = new EscuelaCtrl().elim(objeEqui) ? "Datos Eliminados" : "Datos no eliminados";
            }
            
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/escuela.jsp").forward(request, response);
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
