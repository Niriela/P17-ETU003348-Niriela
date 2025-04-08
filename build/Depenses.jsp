<%@ page import="servlets.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>


<%
    Vector<Credit> credits= ( Vector<Credit> ) request.getAttribute("credits");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1> Ajouter une ligne de depense: </h1>
    <form action="DepensesServlet" method="post">
        <p> Credit:
            <select name="id_credit">
                 <% for(int i = 0; i < credits.size(); i++) { %>
                     <option value='<%= credits.get(i).getId_credit() %>'>  <%= credits.get(i).getLibelle() %> </option>
                 <% } %>
             </select>
         </p>
        
        Montant <input type="number" name="montant" required> <br>
       <button type="submit"> Valider </button> 
    </form>

   <a href="FormCredit"> <button> ajout ligne de credit </button></a>
    
</body>
</html>