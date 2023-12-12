package src;
import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Flux de sortie vers le client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Flux d'entrée depuis le client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lire le message du client
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
