/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.EnsambladoraCtrl;
import com.sv.udb.controlador.EscuelaCtrl;
import com.sv.udb.modelo.Ensambladora;
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
@WebServlet(name = "EnsambladoraServ", urlPatterns = {"/EnsambladoraServ"})
public class EnsambladoraServ extends HttpServlet {

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
                Ensambladora objeEqui = new Ensambladora();
                objeEqui.setNombEnsa(request.getParameter("NombEnsa"));
                objeEqui.setDireEnsa(request.getParameter("DireEnsa"));
                mens = new EnsambladoraCtrl().guar(objeEqui) ? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                int CodiEscu = Integer.parseInt(request.getParameter("codiEnsaRadi") == null ? 
                        "0" : request.getParameter("codiEnsaRadi"));
                Ensambladora objeEqui = new EnsambladoraCtrl().cons(CodiEscu);
                if(objeEqui != null)
                {
                    request.setAttribute("CodiEnsa", objeEqui.getCodiEnsa());
                    request.setAttribute("NombEnsa", objeEqui.getNombEnsa());
                    request.setAttribute("DireEnsa", objeEqui.getDireEnsa());
                      
                }
            }
            
            else if(CRUD.equals("Modificar")){
                Ensambladora objeEqui = new Ensambladora();
                objeEqui.setNombEnsa(request.getParameter("NombEnsa"));
                objeEqui.setDireEnsa(request.getParameter("DireEnsa"));
                objeEqui.setCodiEnsa(Integer.parseInt(request.getParameter("CodiEnsa")));
                mens = new EnsambladoraCtrl().modi(objeEqui) ? "Datos modificados" : "Datos no modificados";
            }
            
            else if(CRUD.equals("Eliminar")){
                Ensambladora objeEqui = new Ensambladora();
                objeEqui.setCodiEnsa(Integer.parseInt(request.getParameter("CodiEnsa")));
                mens = new EnsambladoraCtrl().elim(objeEqui) ? "Datos Eliminados" : "Datos no eliminados";
            }
            
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/ensambladora.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/ensambladora.jsp");
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
