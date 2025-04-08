package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreditServlet extends HttpServlet{
  
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      try {
        String libelle= req.getParameter("libelle");
        Float montant = Float.parseFloat(req.getParameter("montant"));

        Credit c= new Credit(libelle, montant);
        c.Save();

        RequestDispatcher dispat = req.getRequestDispatcher("Credit.jsp");
        dispat.forward(req, res);

      } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e.getMessage());
      }
   }
}
