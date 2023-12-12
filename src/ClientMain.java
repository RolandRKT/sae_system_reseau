package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Connectez-vous au serveur
            Socket socket = new Socket("127.0.0.1", 4444);

            // Flux de sortie vers le serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Flux d'entrée depuis le serveur
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Lire l'entrée utilisateur et envoyer au serveur en boucle
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Entrez un message pour le serveur (ou 'exit' pour quitter) : ");
                String message = userInput.readLine();

                // Vérifier si l'utilisateur souhaite quitter
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Envoyer le message au serveur
                writer.println(message);

                // Lire la réponse du serveur
                String response = reader.readLine();
                System.out.println("Réponse du serveur : " + response);

                // Attendre 5 secondes avant de demander le prochain message
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Fermer la connexion
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
