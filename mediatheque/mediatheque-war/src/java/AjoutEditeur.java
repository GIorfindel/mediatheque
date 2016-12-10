/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.AdresseFacadeLocal;
import entite.Editeur;
import entite.EditeurFacadeLocal;
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
@WebServlet(urlPatterns = {"/AjoutEditeur"})
public class AjoutEditeur extends HttpServlet {
    @EJB
    EditeurFacadeLocal editeurFacade;
    @EJB
    AdresseFacadeLocal adresseFacade;
    
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
        //On récupère les paramètres du formulaire
        String nom = request.getParameter("nom");
        String adrId = request.getParameter("adrId");

        //On vérifie que les inputs correspondent aux expressions régulières
        if (nom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", nom)) {
            request.getSession().setAttribute("errNom", "<span class='err'>Le nom doit contenir 5 à 20 lettres</span>");
        }
        //On parcours la liste des éditeurs pour vérifier que personne n'utilise déjà ce nom
        else if (editeurFacade.findAll().stream().anyMatch(x -> x.getNom().equals(nom))) {
            request.getSession().setAttribute("errNomU", "<span class='err'>Un éditeur utilise déjà ce nom</span>");
        }
        //On vérifie qu'une adresse est présente
        else if (adrId == null || adrId.trim().equals("")) {
            request.getSession().setAttribute("errSadr", "<span class='err'>Vous devez d'abord ajouter une adresse</span>");
        } else {
            //Si les inputs sont corrects alors on ajoute l'éditeur
            Editeur e = new Editeur();
            e.setNom(nom);
            e.setAdresseId(adresseFacade.find(Integer.parseInt(adrId)));
            editeurFacade.create(e);
        }
        //On redirige vers la page appelante
        response.sendRedirect(referer);
        processRequest(request, response);    }

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
