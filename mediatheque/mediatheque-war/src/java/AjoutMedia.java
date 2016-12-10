/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.EditeurFacadeLocal;
import entite.Edition;
import entite.EditionFacadeLocal;
import entite.Livre;
import entite.LivreFacadeLocal;
import entite.Media;
import entite.MediaFacadeLocal;
import entite.TypeFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glorfindel
 */
@WebServlet(urlPatterns = {"/AjoutMedia"})
public class AjoutMedia extends HttpServlet {

    @EJB
    EditionFacadeLocal editionFacade;
    @EJB
    MediaFacadeLocal mediaFacade;
    @EJB
    TypeFacadeLocal typeFacade;
    @EJB
    EditeurFacadeLocal editeurFacade;
    @EJB
    LivreFacadeLocal livreFacade;

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
        String nom = request.getParameter("nom");
        String pub = request.getParameter("date");
        String type = request.getParameter("typeId");
        String editeur = request.getParameter("editeurId");
        String nbe = request.getParameter("nbe");
        String isbn = request.getParameter("isbn");

        if (nom.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", nom)) {
            request.getSession().setAttribute("errNom", "<span class='err'>Le nom doit contenir 5 à 20 lettres</span>");
        } else if (pub.trim().equals("") || !Pattern.matches("(0?\\d|[12]\\d|3[01])-(0?\\d|1[012])-((?:19|20)\\d{2})", pub)) {
            request.getSession().setAttribute("errPub", "<span class='err'>La date doit être au format jj-mm-aaaa</span>");
        } else if (nbe.trim().equals("") || Integer.parseInt(nbe) < 1 || Integer.parseInt(nbe) > 20) {
            request.getSession().setAttribute("errNbE", "<span class='err'>Vous pouvez ajouter entre 1 et 20 exemplaires</span>");
        } else if (isbn.trim().equals("") && typeFacade.find(Integer.parseInt(type)).getNom().equals("livre")) {
            request.getSession().setAttribute("errIsbn", "<span class='err'>Vous devez renseigner l'ISBN si vous ajoutez un livre</span>");
        }
        else if (livreFacade.findAll().stream().anyMatch(x -> x.getIsbn().equals(isbn))) {
            request.getSession().setAttribute("errIsbn", "<span class='err'>Ce numéro ISBN est déjà utilisé</span>");
        }else if (typeFacade.find(Integer.parseInt(type)).getNom().equals("livre") && !Pattern.matches("[0-9]{13}", isbn)) {
            request.getSession().setAttribute("errIsbn", "<span class='err'>Le numéro ISBN doit contenir 13 chiffres</span>");
        } else if (type.trim().equals("")) {
            request.getSession().setAttribute("errType", "<span class='err'>Vous devez choisir une type</span>");
        } else if (editeur==null) {
            request.getSession().setAttribute("errEd", "<span class='err'>Vous devez choisir un éditeur</span>");
        }else {
            Edition ed = new Edition();
            ed.setNom(nom);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                ed.setPublication(formatter.parse(pub));
            } catch (ParseException ex) {
                Logger.getLogger(AjoutMedia.class.getName()).log(Level.SEVERE, null, ex);
            }
            editionFacade.create(ed);
            Media m = new Media();
            m.setNbexemplaires(Integer.parseInt(nbe));
            m.setTypeId(typeFacade.find(Integer.parseInt(type)));
            mediaFacade.create(m);
            ed.setIdMedia(m);
            editionFacade.edit(ed);
            if (typeFacade.find(m.getTypeId().getTypeId()).getNom().equals("livre")) {
                Livre l = new Livre();
                l.setLivreId(m);
                l.setIsbn(isbn);
                livreFacade.create(l);
            }
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
