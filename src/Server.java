package src;

import java.io.*;
import java.net.*;

/**
 * La classe `Serveur` représente le serveur qui écoute les connexions des clients.
 * Elle implémente l'interface Runnable pour permettre l'exécution dans un thread dédié.
 *
 * Fonctionnalités :
 *  - Crée un serveur socket et attend les connexions entrantes.
 *  - À chaque nouvelle connexion, crée une instance de `ClientHandler` dans un nouveau thread
 *    pour gérer la communication avec le client.
 *  - Boucle indéfiniment, acceptant les connexions et déléguant leur gestion à `ClientHandler`.
 *  - Ferme la connexion du serveur lorsqu'il est interrompu ou lorsqu'il détecte une erreur.
 *
 * Utilisation :
 * 1. Instancie un objet `Serveur` en spécifiant le numéro de port.
 * 2. Crée un thread pour le serveur à partir de l'objet `Serveur`.
 * 3. Démarre le thread du serveur pour écouter les connexions des clients.
 *
 * Exemple d'utilisation :
 * public static void main(String[] args) {
 *     Serveur serveur = new Serveur(8888);
 *     Thread serverThread = new Thread(serveur);
 *     serverThread.start();
 * }
 *
 * @author Roland RAKOTOMALALA / Rebson Dodji DAHOUEDE
 * @version 1.0
 */
public class Server implements Runnable {
    private int numPort;
    private ServerSocket serverSock;

    /**
     * Constructeur de la classe `Serveur`.
     *
     * @param numPort Le numéro de port sur lequel le serveur écoutera les connexions des clients.
     */
    public Server(int numPort) {
        this.numPort = numPort;
    }

    /**
     * Méthode exécutée lorsqu'un thread est démarré pour ce serveur.
     * Gère la création d'un socket serveur, l'attente des connexions entrantes,
     * et la création de gestionnaires de client pour chaque connexion.
     */
    @Override
    public void run() {
        try {
            this.serverSock = new ServerSocket(this.numPort);
            System.out.println("Serveur en attente de connexions...");

            while (true) {
                Socket clientSocket = serverSock.accept();
                System.out.println("Nouveau client connecté : " + clientSocket.getInetAddress().getHostAddress());

                // Créer un gestionnaire de client dans un nouveau thread
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.serverSock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
