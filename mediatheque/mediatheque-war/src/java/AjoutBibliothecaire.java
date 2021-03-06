/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Adresse;
import entite.AdresseFacadeLocal;
import entite.Bibliothecaire;
import entite.BibliothecaireFacadeLocal;
import entite.Personne;
import entite.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glorfindel
 */
public class AjoutBibliothecaire extends HttpServlet {

    @EJB
    private PersonneFacadeLocal personneFacade;
    @EJB
    private AdresseFacadeLocal adresseFacade;
    @EJB
    private BibliothecaireFacadeLocal bibliothecaireFacade;

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
        //On récupère la liste des paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("tel");
        String adrId = request.getParameter("adrId");
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");

        //On vérifie que les inputs correspondent aux expressions régulières, sinon on renvoie une erreur
        if (nom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", nom)) {
            request.getSession().setAttribute("errNom", "<span class='err'>Le nom doit contenir 5 à 20 lettres</span>");
        }else if (prenom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", prenom)) {
            request.getSession().setAttribute("errPrenom", "<span class='err'>Le prénom doit contenir 5 à 20 lettres</span>");
        }else if (tel.trim().equals("") || !Pattern.matches("0[0-9]{9,9}", tel)) {
            request.getSession().setAttribute("errTel", "<span class='err'>Un numéro de téléphone contient 10 chiffres et commence par 0</span>");
        }else if (pseudo.trim().equals("") || !Pattern.matches(".{5,20}", pseudo)) {
            request.getSession().setAttribute("errPseudo", "<span class='err'>Votre pseudo doit contenir 5 à 20 caractères</span>");
        }
        //On parcours la liste des bibliothécaires pour savoir si quelqu'un utilise déjà le pseudo, si oui alors on renvoie une erreur
        else if (bibliothecaireFacade.findAll().stream().anyMatch(x -> x.getLogin().equals(pseudo))) {
            request.getSession().setAttribute("errPseudo", "<span class='err'>Ce pseudo est déjà utilisé</span>");
        }
        else if (mdp.trim().equals("") || !Pattern.matches(".{5,20}", mdp)) {
            request.getSession().setAttribute("errMdp", "<span class='err'>Votre pseudo doit contenir 5 à 20 caractères</span>");
        }
        //On vérifie qu'au moins une adresse à été ajoutée
        else if (adrId == null || adrId.trim().equals("")) {
            request.getSession().setAttribute("errSadr", "<span class='err'>Vous devez d'abord ajouter une adresse</span>");
        }
        else {
            //Si les inputs sont corrects alors ont créé la personne puis on lui lie le nouveau bibliothécaire
            Personne p = new Personne();
            p.setNom(nom);
            p.setPrenom(prenom);
            p.setTelephone(tel);
            Adresse a = new Adresse(Integer.parseInt(adrId));
            p.setAdresseId(a);
            Bibliothecaire b = new Bibliothecaire();
            b.setLogin(pseudo);
            b.setMdp(mdp);
            personneFacade.create(p, b);
        }
        //On redirige vers la page d'administration
        response.sendRedirect("admin.jsp");
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
