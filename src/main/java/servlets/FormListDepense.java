package servlets;

import java.io.IOException;
import java.util.Vector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormListDepense extends HttpServlet {
     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      try {

         Vector <Credit>depensesCredit= Credit.findAll();
           req.setAttribute("depenses", depensesCredit);

          RequestDispatcher dispat = req.getRequestDispatcher("ListDepenses.jsp");
          dispat.forward(req, res);

      } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e.getMessage());
      }
   }
}
