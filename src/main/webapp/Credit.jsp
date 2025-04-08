<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1> Ajouter une ligne de credit </h1>
    <form action="CreditServlet" method="post">
        Libelle <input type="text" name="libelle" required> <br>
        Montant <input type="number" name="montant" required> <br>
       <button type="submit"> Valider </button> 
    </form>

    <a href="FormDepenses"> <button> ajout ligne de depense </button></a>
    <a href="FormListDepense"> <button> Dashboard </button></a>
    
</body>
</html>