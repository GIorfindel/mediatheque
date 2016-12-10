/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Adherent;
import entite.AdherentFacadeLocal;
import entite.Edition;
import entite.EditionFacadeLocal;
import entite.Emprunte;
import entite.EmprunteFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
@WebServlet(urlPatterns = {"/EmprunterMedia"})
public class EmprunterMedia extends HttpServlet {
    @EJB
    EditionFacadeLocal editionFacade;
    @EJB
    AdherentFacadeLocal adherentFacade;
    @EJB
    EmprunteFacadeLocal emprunteFacade;

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
        List<Edition> ed = new ArrayList();
        for (Edition e : editionFacade.findAll())
        {
            if (emprunteFacade.findAll().stream().filter(x -> x.getEmpruntePK().getIdMedia()==e.getIdMedia().getMediaId()).count() < e.getIdMedia().getNbexemplaires())
            {
                ed.add(e);
            }
        }
        request.setAttribute("mdList", ed);
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
        int aId = Integer.parseInt(request.getParameter("adId"));
        int mId = Integer.parseInt(request.getParameter("mdId"));
        //Emprunte e = new Emprunte();
        //e.setAdherent(adherentFacade.find(aId));
        //e.setMedia(editionFacade.find(mId).getIdMedia());
        Edition ed = editionFacade.find(mId);
        if (emprunteFacade.findAll().stream().anyMatch(x -> x.getEmpruntePK().getIdAdherent()==aId && x.getEmpruntePK().getIdMedia()==mId))
        {
            request.getSession().setAttribute("errEa", "<span class='err'>Cet adhérent à déjà emprunté ce livre</span>");
        }
        else if(emprunteFacade.findAll().stream().filter(x -> x.getEmpruntePK().getIdAdherent()==aId && x.getEmpruntePK().getIdMedia()==mId).count() == ed.getIdMedia().getNbexemplaires())
        {
            request.getSession().setAttribute("errEa", "<span class='err'>Ce livre n'est plus disponible<span>");      
        }
        else
        {
            Date dEmprunt = new Date();
            int noOfDays = 14; //i.e two weeks
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dEmprunt);            
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            Date dRetour = calendar.getTime();  
            Emprunte e = new Emprunte(dEmprunt,dRetour,mId,aId);
            Adherent a = adherentFacade.find(aId);
            a.getEmprunteCollection().add(e);
            emprunteFacade.create(e);
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
