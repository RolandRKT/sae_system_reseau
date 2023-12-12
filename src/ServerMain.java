package src;

public class ServerMain {
    public static void main(String[] args) {
        Serveur serveur = new Serveur(4444);
        Thread serverThread = new Thread(serveur);
        serverThread.start();
    }
}
