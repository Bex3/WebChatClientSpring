package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bearden-tellez on 9/23/16.
 */
public class Server {

    public static void main(String[] args) {
        System.out.println("Booting server");
        Server myServer = new Server();
        myServer.StartServer();
    }


    public void StartServer() {
        System.out.println("Booting server");
        try {
            ServerSocket serverListener = new ServerSocket(8005); //8005?
            System.out.println("Ready to listen");

            while (true) {
                Socket incomingConnection = serverListener.accept();
                ConnectionHandler handler = new ConnectionHandler(incomingConnection);
                Thread runningThreadServer = new Thread(handler);
                runningThreadServer.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

