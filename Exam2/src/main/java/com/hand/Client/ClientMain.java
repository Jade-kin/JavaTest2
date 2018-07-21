package com.hand.Client;


public class ClientMain {

    public static void main( String[] args ) {
        ChatSocket chatSocket = new ChatSocket();
        chatSocket.start();
    }

}
