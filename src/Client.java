package src;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connexion au serveur
            Socket socket = new Socket("127.0.0.1", 4444);

            // Flux de sortie vers le serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer un message au serveur
            writer.println("Bonjour, serveur!");

            // Flux d'entrée depuis le serveur
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Lire la réponse du serveur
            String response = reader.readLine();
            System.out.println("Réponse du serveur : " + response);

            // Fermer la connexion
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
