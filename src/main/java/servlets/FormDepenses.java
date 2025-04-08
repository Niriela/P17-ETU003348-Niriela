package servlets;

import java.io.IOException;
import java.util.Vector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormDepenses extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      try {

         Vector <Credit> credits= Credit.findAll();
           req.setAttribute("credits", credits);

          RequestDispatcher dispat = req.getRequestDispatcher("Depenses.jsp");
          dispat.forward(req, res);

      } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e.getMessage());
      }
   }
}
