package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DepensesServlet extends HttpServlet{
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      try {
        int id_credit= Integer.parseInt(req.getParameter("id_credit"));
        Credit c= Credit.findById(id_credit);

        Float montant = Float.parseFloat(req.getParameter("montant"));
        
        Depenses dep= new Depenses(c, montant);
        dep.CheckIfCreditSuperieur(c);
        dep.Save();

        res.sendRedirect("Credit.jsp");

      } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e.getMessage());
      }
   }
}
