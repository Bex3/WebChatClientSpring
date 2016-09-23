package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by bearden-tellez on 9/23/16.
 */
public class ConnectionHandler implements Runnable {
    Socket clientSocket = null;

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    private String clientUserName = null;

    public void run() {
        try {
            handleIncomingConnections(clientSocket);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }


    public ConnectionHandler(Socket incomingConnection) {
        this.clientSocket = incomingConnection;
    }


    private void handleIncomingConnections(Socket incomingConnection) throws IOException {

        System.out.println("Connected");

        System.out.println("clientSocket = " + incomingConnection);

        System.out.println("Connected with " + incomingConnection.getInetAddress().getHostAddress());

        PrintWriter out = new PrintWriter(incomingConnection.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(incomingConnection.getInputStream()));

        //String clientInput= in.readLine();


        String clientInput;
//        while (true) {
        if ((clientInput = in.readLine()) != null){
            System.out.println("Client said " + clientInput); //in.toString())
            out.println("Message received: " + clientInput);
//            } else {

//            }
            clientSocket.close();
        }

    }
}
