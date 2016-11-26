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
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 *
 * @author glorfindel
 */
public class AjoutBibliothecaire extends HttpServlet {

    @EJB
    private PersonneFacadeLocal personneFacade;
    private AdresseFacadeLocal adresseFacade;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjoutBibliothecaire</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutBibliothecaire at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("tel");
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setTelephone(tel);
        int adrId = Integer.parseInt(request.getParameter("adrId"));
        Adresse a = new Adresse(adrId);
        p.setAdresseId(a);
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");

        //b.setPersonne(personneFacade.find(p));
        Bibliothecaire b = new Bibliothecaire();
        b.setLogin("test");
        b.setMdp("test");
        personneFacade.create(p,b);

        //b.setBibliothecaireId(new Personne(7).getPersonneId());
        //b.setPersonne(new Personne(7));
        //if (mdp!=null && pseudo != null)
        //{
        //    bibliothecaireFacade.create(b);
        //}
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
