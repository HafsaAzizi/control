# control
# Système de Gestion des Événements et des Participants

Application web développée avec **Spring Boot** et **Thymeleaf** pour la gestion des événements et l'inscription des participants.

## Énoncé

Développer une application permettant de gérer des événements et d’inscrire des participants. Chaque participant peut s'inscrire à plusieurs événements, et chaque événement peut accueillir plusieurs participants.

## Entités

### Événement
- **Nom** : Le nom de l'événement.
- **Lieu** : Le lieu où se déroule l'événement.
- **Date** : La date de l'événement.
- **Description** : Une brève description de l'événement.

### Participant
- **Nom** : Le nom du participant.
- **Email** : L'adresse email du participant.
- **Événements inscrits** : La liste des événements auxquels le participant est inscrit.

## Pages Web à mettre en place

### Page de Liste des Événements
- Permet aux utilisateurs de consulter les événements disponibles.
- Offre une option pour s'inscrire à un événement.

### Page de Détail d’un Événement
- Affiche les détails de l'événement sélectionné.
- Affiche la liste des participants inscrits à cet événement.

## Technologies Utilisées

- **Backend** : Spring Boot
- **Frontend** : Thymeleaf, HTML, CSS
- **Base de Données** : MySQL

## Structure du Projet

src/ ├── main/ │ ├── java/com/example/devoir/ │ │ ├── controllers/ │ │ ├── entities/ │ │ └── repository/ │ └── resources/ │ ├── static/ │ └── templates/


## Installation

1. Cloner le projet.
2. Configurer `application.properties` :

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/event
spring.datasource.username = root
spring.datasource.password =
```
##Démarrer l'application :

mvn spring-boot:run


##Accéder à l'application via
http://localhost:8080.


##Video Demo



https://github.com/user-attachments/assets/79b22ed3-4bee-4d54-ae6f-bc9168fc362a



--

