import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * La classe `ClientMain` représente un programme client simple qui établit une connexion de socket
 * vers un serveur et permet à l'utilisateur d'envoyer des messages au serveur. Elle lit l'entrée
 * utilisateur, envoie le message au serveur, puis attend une réponse. Le client peut être arrêté
 * en entrant la commande '/exit'.
 *
 * Utilisation :
 * 1. Le client se connecte à un serveur en utilisant un socket à l'adresse IP et au port spécifiés.
 * 2. Il crée des flux de sortie et d'entrée pour envoyer et recevoir des messages vers/depuis le serveur.
 * 3. L'utilisateur est invité à saisir des messages, qui sont ensuite envoyés au serveur.
 * 4. Le client attend la réponse du serveur et l'affiche.
 * 5. Le client peut être arrêté en entrant '/exit'.
 *
 * Remarque : Un délai de 3 secondes a été placé entre chaque envoie de messages au serveur.
 *
 * @author Roland RAKOTOMALALA / Rebson Dodji DAHOUEDE
 * @version 1.0
*/

public class ClientMain {
    /**
     * Le point d'entrée principal du programme client.
    */
    public static void main(String[] args) {
        try {
            // Connection au serveur
            Socket socket = new Socket("127.0.0.1", 4444);

            // Flux de sortie vers le serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Flux d'entrée depuis le serveur
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Lire l'entrée utilisateur et envoyer au serveur en boucle
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Entrez un message pour le serveur (ou '/exit' pour quitter) : ");
                String message = userInput.readLine();

                if ("/exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Envoyer le message au serveur
                writer.println(message);

                // Lire la réponse du serveur
                String response = reader.readLine();
                System.out.println("Réponse du serveur : " + response);

                // Attente de 3 secondes avant de pouvoir relancer un message
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
