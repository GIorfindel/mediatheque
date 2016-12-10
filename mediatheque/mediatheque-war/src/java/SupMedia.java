/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Edition;
import entite.EditionFacadeLocal;
import entite.EmprunteFacadeLocal;
import entite.Livre;
import entite.LivreFacadeLocal;
import entite.MediaFacadeLocal;
import entite.TypeFacadeLocal;
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
@WebServlet(urlPatterns = {"/SupMedia"})
public class SupMedia extends HttpServlet {
    @EJB
    EditionFacadeLocal editionFacade;
    @EJB
    MediaFacadeLocal mediaFacade;
    @EJB
    EmprunteFacadeLocal emprunteFacade;
    @EJB
    LivreFacadeLocal livreFacade;
    @EJB
    TypeFacadeLocal typeFacade;

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
        //on récupère l'ID su média à supprimer
        int med = Integer.parseInt(request.getParameter("mdId"));
        Edition e = editionFacade.find(med);
        //Avant de supprimer le média on vérifie qu'aucun exmeplaire n'est emprunté
        if (emprunteFacade.findAll().stream().anyMatch(x -> x.getEmpruntePK().getIdMedia()==med))
        {
            request.getSession().setAttribute("errSupM", "<span class='err'>Vous ne pouvez pas supprimer un média tant qu'il est emprunté</span>");
        }
        else
        {
            //Si le média est un livre alors on le supprime
            for (Livre l : livreFacade.findAll())
            {
                if (l.getLivreId().getMediaId()==med)
                {
                    livreFacade.remove(l);
                }
            }
            //On supprime ensuite l'édition et le média
            editionFacade.remove(e);
            mediaFacade.remove(e.getIdMedia());
        }
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
