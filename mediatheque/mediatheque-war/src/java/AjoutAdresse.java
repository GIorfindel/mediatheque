/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Adresse;
import entite.AdresseFacadeLocal;
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
public class AjoutAdresse extends HttpServlet {

    @EJB
    private AdresseFacadeLocal adresseFacade;

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
        String pays = request.getParameter("pays");
        String ville = request.getParameter("ville");
        String rue = request.getParameter("rue");
        int numero = Integer.parseInt(request.getParameter("num"));
        //On vérifie les inputs et on revoie des erreurs s'ils ne correspondent pas à l'expression régulière
        if (pays.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", pays)) {
            request.getSession().setAttribute("errPays", "<span class='err'>Le pays doit contenir 5 à 20 lettres</span>");
        } else if (ville.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", ville)) {
            request.getSession().setAttribute("errVille", "<span class='err'>La ville doit contenir 5 à 20 lettres</span>");
        } else if (rue.trim().equals("") || !Pattern.matches("[A-z|-]{5,20}", rue)) {
            request.getSession().setAttribute("errVille", "<span class='err'>La rue doit contenir 5 à 20 lettres</span>");
        } else if (numero < 1 || numero > 300) {
            request.getSession().setAttribute("errNum", "<span class='err'>Le numéro doit être compris entre 1 et 300</span>");
        } else if (adresseFacade.findAll().stream().anyMatch(x -> x.getNumero().equals(numero) && x.getPays().equals(pays) && x.getRue().equals(rue) && x.getVille().equals(ville))) {
            request.getSession().setAttribute("errAdrE", "<span class='err'>L'adresse existe déjà</span>");
        } else {
            //Si les inputs sont corrects alors ajoute l'adresse
            Adresse a = new Adresse();
            a.setNumero(numero);
            a.setPays(pays);
            a.setRue(rue);
            a.setVille(ville);
            adresseFacade.create(a);
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
