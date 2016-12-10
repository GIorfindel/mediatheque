/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.AuteurFacadeLocal;
import entite.Edition;
import entite.EditionFacadeLocal;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/AjoutAuteurMedia"})
public class AjoutAuteurMedia extends HttpServlet {
    @EJB
    EditionFacadeLocal editionFacade;
    @EJB
    AuteurFacadeLocal auteurFacade;

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
        //On récupère les paramètres du formulaires
        int mId = Integer.parseInt(request.getParameter("mediaId"));
        int aId = Integer.parseInt(request.getParameter("autId"));
        //On parcours la liste des éditions pour savoir si l'auteur est déjà listé comme auteur du média auquel on veut l'ajouter
        if(editionFacade.findAll().stream().anyMatch(x -> x.getEditionId().equals(mId)&&x.getAuteurCollection().stream().anyMatch(y->y.getAuteurId().equals(aId))))
        {
            request.getSession().setAttribute("errAe", "<span class='err'>L'auteur est déjà listé pour ce média</span>");
        }
        else
        {
            //Si l'auteur n'est pas déjà listé dans l'édition alors on l'y ajoute
            Edition e = editionFacade.find(mId);
            e.getAuteurCollection().add(auteurFacade.find(aId));
            editionFacade.edit(e);
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
