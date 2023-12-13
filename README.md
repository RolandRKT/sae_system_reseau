# sae_system_reseau

## Duo
- Roland RAKOTOMALALA
- Resbon Dodji Dahouede

## Information supplémentaire sur les classes

### ClientHandler.java
- **Objectif :** Cette classe représente un gestionnaire de clients côté serveur. Chaque instance de cette classe est créée pour gérer la communication avec un client particulier.
- **Fonctionnalité :**
  - Établit des flux d'entrée/sortie avec le client via un socket.
  - Lit les messages du client, les affiche, et répond au client.
  - La boucle de traitement s'arrête si le client envoie le message "exit".
  - Ferme la connexion avec le client.

### ClientMain.java
- **Objectif :** Ce fichier contient la classe principale pour le programme client.
- **Fonctionnalité :**
  - Établit une connexion avec le serveur en utilisant un socket.
  - Crée des flux de sortie et d'entrée pour communiquer avec le serveur.
  - Permet à l'utilisateur d'envoyer des messages au serveur depuis la console.
  - Affiche les réponses du serveur.
  - La boucle principale continue jusqu'à ce que l'utilisateur entre "exit", fermant ainsi la connexion.

### ServerMain.java
- **Objectif :** Ce fichier contient la classe principale pour le programme serveur.
- **Fonctionnalité :**
  - Crée une instance de la classe Serveur et démarre un thread pour le serveur.

### Server.java
- **Objectif :** Cette classe représente le serveur qui écoute les connexions des clients.
- **Fonctionnalité :**
  - Crée un serveur socket et attend les connexions entrantes.
  - À chaque nouvelle connexion, crée une instance de ClientHandler dans un nouveau thread pour gérer la communication avec le client.
  - Boucle indéfiniment, acceptant les connexions et déléguant leur gestion à ClientHandler.
  - Ferme la connexion du serveur lorsqu'il est interrompu ou lorsqu'il détecte une erreur.

À noter que `Server` est responsable de la gestion des connexions entrantes et de la création de nouvelles instances de `ClientHandler` pour chaque client, tandis que ClientHandler est responsable de la gestion de la communication avec un client spécifique.