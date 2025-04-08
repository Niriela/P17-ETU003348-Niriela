<%@ page import="java.util.*" %>
<%@ page import="servlets.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>Liste de tous les credits </h1>
    <% Vector<Credit> depenses = (Vector<Credit>) request.getAttribute("depenses"); %>

    <table width=700 border=1>
        <tr> 
            <th>Credit</th>
            <th>Montant</th>
            <th>DepenseTotal</th>
            <th>Reste</th>
        </tr>
        <% for(Credit c : depenses) { %>
            <tr> 
                <td><%= c.getLibelle() %></td>
                <td><%= c.getMontant() %></td>
                <td><%= c.SumDepenses() %></td>
                <td><%= c.getMontant() - c.SumDepenses() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>