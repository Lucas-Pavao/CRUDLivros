/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Model.Livro;
import Repositorios.LivroRep;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ApresentaAlteracaoLivroController", urlPatterns = {"/ApresentaAlteracaoLivroController"})
public class ApresentaAlteracaoLivroController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Livro l = LivroRep.ler(id);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Apresenta alteracao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Altere o Livro</h1>");
            out.println("<a href='ApresentaLivrosController'>Livros</a><br>");
            out.println("<form method='post' action='AlteraLivroController'>");
            out.println("<input type='hidden' name='id' value='"+l.getId()+"'/>");
            out.println("Nome: <input type=\"text\" name=\"nome\" value='"+l.getNome()+"'><br>");
            out.println("Contato1: <input type=\"text\" name=\"autor\" value='"+l.getAutor()+"'><br>");
            out.println("Contato2: <input type=\"text\" name=\"categoria\" value='"+l.getCategoria()+"'><br>");
            out.println("<input type='submit' value='enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
