/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Type;
import entite.TypeFacadeLocal;
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
@WebServlet(urlPatterns = {"/AjoutType"})
public class AjoutType extends HttpServlet {

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
        //on récupère le nom du type à ajouter
        String nom = request.getParameter("nom");
        //On vérifie que le nom correspond à l'expression régulière
        if (nom.trim().equals("") || !Pattern.matches("[A-z|-]{2,20}", nom)) {
            request.getSession().setAttribute("errNomT", "<span class='err'>Le nom doit contenir 2 à 20 lettres</span>");
        }
        //On parcours la liste des types pour vérifier que le type à ajouter n'y figure pas déjà
        else if (typeFacade.findAll().stream().anyMatch(x -> x.getNom().equals(nom))) {
            request.getSession().setAttribute("errNomT", "<span class='err'>Le type existe déjà</span>");
        }
        else
        {
            //Si le nom est correct alors on ajoute le nouveau type
            Type t = new Type();
            t.setNom(nom);
            typeFacade.create(t);
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
