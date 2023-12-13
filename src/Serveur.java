package src;

import java.io.*;
import java.net.*;

public class Serveur implements Runnable {
    private int numPort;
    private ServerSocket serverSock;

    public Serveur(int numPort) {
        this.numPort = numPort;
    }

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

