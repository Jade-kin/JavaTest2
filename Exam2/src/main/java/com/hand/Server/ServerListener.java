package com.hand.Server;

import com.hand.Client.ChatSocket;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(43251);
            while (true){
                Socket socket = serverSocket.accept();
                ChatSocket chatSocket = new ChatSocket();
                chatSocket.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
