# Mon Application Spring Boot

Bienvenue dans l'application Spring Boot qui gère la gestion de produits. Cette application vous permet de créer, mettre à jour, supprimer et récupérer des informations sur les produits.

## Configuration Requise

Avant de commencer, assurez-vous que vous avez les éléments suivants installés sur votre système :

- Java (version 17)
- Spring Boot 3.x
- Maven (version x.x.x)
- MySQL Server (version x.x.x) - (ou la base de données de votre choix)

## Installation

1. Clonez ce dépôt sur votre machine locale
2. Configurez la base de données :
    Modifiez le fichier src/main/resources/application.properties pour définir les informations de connexion à votre base de données MySQL.
3.mvn spring-boot:run

## Utilisation

Vous pouvez utiliser l'API REST pour interagir avec l'application. Voici quelques exemples d'endpoints disponibles :

    GET /products : Récupère la liste de tous les produits.
    GET /products/{id} : Récupère les détails d'un produit spécifique.
    POST /products : Crée un nouveau produit.
    PATCH /products/{id} : Met à jour partiellement un produit existant.
    DELETE /products/{id} : Supprime un produit existant.

Assurez-vous de consulter la documentation Swagger à l'adresse http://localhost:8080/swagger-ui.html pour obtenir une liste complète des endpoints et tester l'API.

Projet Full Stack

La project en entier de ce projet se trouve dans le référentiel suivant : https://github.com/MatteiT/Alten_FullStack.git
