/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.AdresseFacadeLocal;
import entite.EditeurFacadeLocal;
import entite.PersonneFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glorfindel
 */
public class SupAdresse extends HttpServlet {

    @EJB
    private PersonneFacadeLocal personneFacade;
    @EJB
    private AdresseFacadeLocal adresseFacade;
    @EJB
    private EditeurFacadeLocal editeurFacade;

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
        //On récupère l'ID de l'adresse
        int id = Integer.parseInt(request.getParameter("adrId"));
        //On vérifie d'abord que l'adresse n'est pas utilisée par quelqu'un
        if (personneFacade.findAll().stream().anyMatch(x -> x.getAdresseId().getAdresseId().equals(id))) {
            request.getSession().setAttribute("errAdr", "<span class='err'>L'adresse ne peut pas être supprimée tant qu'elle est liée à une personne</span>");
        }
        else if (editeurFacade.findAll().stream().anyMatch(x -> x.getAdresseId().getAdresseId().equals(id))) {
            request.getSession().setAttribute("errAdr", "<span class='err'>L'adresse ne peut pas être supprimée tant qu'elle est liée à une personne</span>");
        }
        else {
            //Si elle n'est pas utilisée alors on peut la supprimée
            adresseFacade.remove(adresseFacade.find(id));
        }
        //On rédirige vers la page appelante
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
