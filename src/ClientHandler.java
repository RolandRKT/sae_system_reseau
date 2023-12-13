package src;

import java.io.*;
import java.net.*;

/**
 * La classe `ClientHandler` représente un gestionnaire de client côté serveur.
 * Chaque instance de cette classe est créée pour gérer la communication avec un client particulier.
 * Elle implémente l'interface Runnable pour permettre l'exécution dans un thread dédié.
 *
 * Fonctionnalités :
 *  - Établit des flux de sortie vers le client pour lui envoyer des messages.
 *  - Établit des flux d'entrée depuis le client pour recevoir des messages.
 *  - Lit les messages du client, les affiche côté serveur et répond au client.
 *  - La boucle de traitement s'arrête lorsque le client ferme la connexion.
 *
 * @author Roland RAKOTOMALALA / Rebson Dodji DAHOUEDE
 * @version 1.0
*/
public class ClientHandler implements Runnable {
    private Socket clientSocket;

    /**
     * Constructeur de la classe `ClientHandler`.
     *
     * @param clientSocket Le socket du client avec lequel la communication sera gérée.
     */
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * Méthode exécutée lorsqu'un thread est démarré pour ce gestionnaire de client.
     * Gère la communication avec le client en lisant et en traitant les messages.
     */
    @Override
    public void run() {
        try {
            // Flux de sortie vers le client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Flux d'entrée depuis le client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lire le message du client et diffuser à tous les autres clients
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Message du client : " + clientMessage);

                // Répondre au client
                writer.println("Message reçu : " + clientMessage);
            }

            // Fermer la connexion
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
