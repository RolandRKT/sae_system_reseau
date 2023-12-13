package src;

/**
 * La classe `ServerMain` représente la classe principale pour le programme serveur.
 * Elle est responsable de créer une instance de la classe `Serveur` et de démarrer un thread pour le serveur.
 *
 * Utilisation :
 * 1. Instancie un objet `Serveur` en spécifiant le numéro de port.
 * 2. Crée un thread pour le serveur à partir de l'objet `Serveur`.
 * 3. Démarre le thread du serveur pour écouter les connexions des clients.
 *
 * Exemple d'utilisation :
 * public static void main(String[] args) {
 *     Serveur serveur = new Serveur(8000);
 *     Thread serverThread = new Thread(serveur);
 *     serverThread.start();
 * }
 *
 * @author Roland RAKOTOMALALA / Rebson Dodji DAHOUEDE
 * @version 1.0
*/
public class ServerMain {
    /**
     * Le point d'entrée principal du programme serveur.
     */
    public static void main(String[] args) {
        // Instancie un objet Serveur avec le numéro de port 4444
        Serveur serveur = new Serveur(4444);

        // Crée un thread pour le serveur et le démarre
        Thread serverThread = new Thread(serveur);
        serverThread.start();
    }
}

