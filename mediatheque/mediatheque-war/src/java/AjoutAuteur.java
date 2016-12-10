/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Adresse;
import entite.Auteur;
import entite.Personne;
import entite.PersonneFacadeLocal;
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
@WebServlet(urlPatterns = {"/AjoutAuteur"})
public class AjoutAuteur extends HttpServlet {
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
        //On récupère l'url de la page appelante
        String referer = request.getHeader("Referer");
        //On récupère les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("tel");
        String adrId = request.getParameter("adrId");

        //On vérifie que les inputs correspondent aux expressions régulières, sinon on renvoie une erreur
        if (nom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", nom)) {
            request.getSession().setAttribute("errNom", "<span class='err'>Le nom doit contenir 5 à 20 lettres</span>");
        } else if (prenom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", prenom)) {
            request.getSession().setAttribute("errPrenom", "<span class='err'>Le prénom doit contenir 5 à 20 lettres</span>");
        } else if (tel.trim().equals("") || !Pattern.matches("0[0-9]{9,9}", tel)) {
            request.getSession().setAttribute("errTel", "<span class='err'>Un numéro de téléphone contient 10 chiffres et commence par 0</span>");
        } else if (adrId == null || adrId.trim().equals("")) {
            request.getSession().setAttribute("errSadr", "<span class='err'>Vous devez d'abord ajouter une adresse</span>");
        } else {
            //Si les inputs sont corrects, on créé la personne puis on lui lie le nouvel auteur
            Personne p = new Personne();
            p.setNom(nom);
            p.setPrenom(prenom);
            p.setTelephone(tel);
            Adresse a = new Adresse(Integer.parseInt(adrId));
            p.setAdresseId(a);
            Auteur at = new Auteur();
            at.setPersonne(p);
            personneFacade.create(p,at);
        }
        response.sendRedirect("gestionAuteurs.jsp");
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
