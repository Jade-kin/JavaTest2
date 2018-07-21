package com.hand.Server;

public class ServerMain {

    public static void main( String[] args ) {
        ServerListener serverListener = new ServerListener();
        serverListener.start();
        serverListener.interrupt();
    }
}
