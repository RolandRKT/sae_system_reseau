package src;
import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Création du socket serveur
            ServerSocket serverSocket = new ServerSocket(4444);

            // Attente d'une connexion cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion d'un client");

            // Flux d'entrée depuis le client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lire le message du client
            String message = reader.readLine();
            System.out.println("Message du client : " + message);

            // Flux de sortie vers le client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Envoyer une réponse au client
            writer.println("Bonjour, client!");

            // Fermer la connexion
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
