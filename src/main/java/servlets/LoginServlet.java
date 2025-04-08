package servlets;

import java.io.IOException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les valeurs du formulaire
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("password");

        try {
            if (match(nom, mdp)) {
                // Authentification réussie, créer une session
                HttpSession session = req.getSession();
                session.setAttribute("user_name", nom); // tu peux récupérer l’utilisateur plus tard
                session.setAttribute("user_mdp", mdp); // tu peux récupérer l’utilisateur plus tard

                // Redirection vers page de succès
                resp.sendRedirect("Credit.jsp");  // à toi de créer cette page
            } else {
                // Échec de connexion, redirection vers le formulaire
                resp.sendRedirect("index.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("index.jsp?error=exception");
        }
    }

    // Méthode pour vérifier les identifiants dans la base de données
    protected Boolean match(String nom, String mdp) throws Exception {
        String name="user";
        String pwd="user";

       if(name.equals(nom) && mdp.equals(pwd)){
        return true;
       }
       return false;
    }
}
