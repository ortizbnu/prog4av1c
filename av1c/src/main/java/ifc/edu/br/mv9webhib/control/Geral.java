/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.mv9webhib.control;

import ifc.edu.br.mv9webhib.dao.DAO;
import ifc.edu.br.mv9webhib.model.Cargo;
import ifc.edu.br.mv9webhib.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author friend
 */
@WebServlet(name = "Geral", urlPatterns = {"/Geral"})
public class Geral extends HttpServlet {
    
    DAO dao = new DAO();

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
        if (request.getParameter("visualizar") != null) {
            request.setAttribute("pessoas", dao.consultarPessoas());
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        } else if (request.getParameter("cadastroPessoa") != null) {
            request.setAttribute("cargos", dao.consultarCargos());
            getServletContext().getRequestDispatcher("/cadastro.jsp").forward(request, response);
        } else if (request.getParameter("cadastroCargo") != null) {
            getServletContext().getRequestDispatcher("/cadastroCargo.jsp").forward(request, response);
        }
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
        if ("pessoa".equals(request.getParameter("parent"))) {
            Pessoa p = new Pessoa();
            p.setNome(request.getParameter("nome"));
            p.setEmail(request.getParameter("email"));
            p.setSalario(validaFloat(request.getParameter("salario")));
            p.setCargo(dao.consultarCargo(validaLong(request.getParameter("cargos"))));
            dao.inserirPessoa(p);
        } else if ("cargo".equals(request.getParameter("parent"))) {
            Cargo c = new Cargo();
            c.setNome(request.getParameter("nome"));
            dao.inserirCargo(c);    
        }
        request.setAttribute("msg", "Cadastro realizado com sucesso!");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
    }
    
    private Float validaFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch(Exception e) {
            return 0F;
        }
    }
    
    private Long validaLong(String s) {
        try {
            return Long.parseLong(s);
        } catch(Exception e) {
            return 0L;
        }
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
