/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.AuteurFacadeLocal;
import entite.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author florian
 */
@WebServlet(urlPatterns = {"/SupAuteur"})
public class SupAuteur extends HttpServlet {

    @EJB
    AuteurFacadeLocal auteurFacade;
    @EJB
    PersonneFacadeLocal personneFacade;

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
        //On récupère l'adresse de la page appelante
        String referer = request.getHeader("Referer");
        //On récupère l'ID de l'auteur
        int id = Integer.parseInt(request.getParameter("atId"));
        //On parcours la liste d'auteur et on vérifie qu'il n'est auteur d'aucun média
        if (!auteurFacade.findAll().stream().anyMatch(x -> x.getAuteurId().equals(id) && x.getEditionCollection().isEmpty())) {
            request.getSession().setAttribute("errEd", "<span class='err'>Vous ne pouvez pas supprimer un auteur tant qu'il est auteur d'un média</span>");
        }
        else
        {
            //S'il n'est auteur d'aucun média alors on peut supprimer l'auteur et la personne correspondant
            auteurFacade.remove(auteurFacade.find(id));
            personneFacade.remove(personneFacade.find(id));
        }
        //On redirige vers la page appelante
        response.sendRedirect(referer);
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
