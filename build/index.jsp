<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1> Nom: user </h1>
    <h1> mot de passe: user </h1>
    <p> mes informations sont stockes en dur </p>

    <form action="LoginServlet" method="post">
        Nom: <input type="text" name="nom" required><br>
        Mot de passe: <input type="password" name="password" required><br>
        <input type="submit" value="Connexion">
        <% if ("true".equals(request.getParameter("error"))) { %>
            <p style="color: red;">Nom ou mot de passe incorrect</p>
        <% } else if ("exception".equals(request.getParameter("error"))) { %>
            <p style="color: red;">Erreur lors de l’authentification</p>
        <% } %>
    </form>
</body>
</html>