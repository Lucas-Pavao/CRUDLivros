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
import java.util.List;


/**
 *
 * @author lucas
 */
@WebServlet(name = "ApresentaLivrosController", urlPatterns = {"/ApresentaLivrosController"})
public class ApresentaLivrosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Livro> livros = LivroRep.lerTudo();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Livros Cadastrados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livros Cadastrados</h1>");
            out.println("<a href=\"index.html\">home</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>id</th><th>Nome</th><th>autor</th><th>categoris</th></tr>");
            
            for(Livro l: livros){
                
                out.println("<tr><td>"+l.getId()+"</td><td>"+l.getNome()+"</td>"
                    + "<td>"+l.getAutor()+"</td><td>"+l.getCategoria()+"</td>"
                            + "<td><a href='VizualizaLivroController?id="+l.getId()+"'>visualizar</a>"
                                    + "<a href='ApresentaAlteracaoLivroController?id="+l.getId()+"'> alterar</a>"
                                    + "<a href='DeletarLivroController?id="+l.getId()+"'> deletar</a></td></tr>");
                
            }
            
            out.println("</table>");
            
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
