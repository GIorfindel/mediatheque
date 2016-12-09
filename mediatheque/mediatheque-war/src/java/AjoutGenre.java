/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Edition;
import entite.EditionFacadeLocal;
import entite.Genre;
import entite.GenreFacadeLocal;
import entite.Type;
import java.io.IOException;
import java.util.regex.Pattern;
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
@WebServlet(urlPatterns = {"/AjoutGenre"})
public class AjoutGenre extends HttpServlet {
    @EJB
    GenreFacadeLocal genreFacade;
    @EJB
    EditionFacadeLocal editionFacade;

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
        String referer = request.getHeader("Referer");
        int mId = Integer.parseInt(request.getParameter("mediaId"));
        String g = request.getParameter("genre");
        if (g.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", g)) {
            request.getSession().setAttribute("errGenre", "<span class='err'>Le genre doit contenir 5 à 20 lettres</span>");
        }
        else
        {
            Edition e = editionFacade.find(mId);
            if(genreFacade.findAll().stream().anyMatch(x -> x.getNom().equals(g)))
            {
                e.getIdMedia().getGenreCollection().add(genreFacade.find(g));
            }
            else
            {
                Genre ge = new Genre();
                ge.setNom(g);
                genreFacade.create(ge);
                e.getIdMedia().getGenreCollection().add(ge);
            }
            editionFacade.edit(e);
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
