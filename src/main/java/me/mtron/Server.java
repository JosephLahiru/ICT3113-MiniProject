package me.mtron;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server implements Runnable{

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;

    public Server(){
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(6969);
            pool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            shutdown();
        }
    }

    public void broadcast(String message) {
        for(ConnectionHandler ch: connections){
            if(ch!=null){
                ch.sendMessage(message);
            }
        }
    }

    public void shutdown() {
        try {
            done = true;
            pool.shutdown();
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections) {
                ch.shutdown();
            }
            pool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    class ConnectionHandler implements Runnable{

        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String nickname;

        public ConnectionHandler(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try (Socket client = this.client;
                 DataInputStream dis = new DataInputStream(client.getInputStream());
                 DataOutputStream dos = new DataOutputStream(client.getOutputStream())) {
                this.dis = dis;
                this.dos = dos;

                dos.writeUTF("/nick");
                dos.flush();

                nickname = dis.readUTF();
                System.out.println(nickname + " connected!");
                broadcast(nickname + " joined the chat!");

                String message;
                while ((message = dis.readUTF()) != null) {
                    if (message.startsWith("/quit")) {
                        broadcast(nickname + " left the chat!");
                        shutdown();
                    } else {
                        broadcast(nickname + ": " + message);
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
                shutdown();
            }
        }

        public void sendMessage(String message) {
            try {
                if (dos != null) {
                    dos.writeUTF(message);
                    dos.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void shutdown(){
            try {
                if (dis != null) {
                    dis.close();
                }
                if (dos != null) {
                    dos.close();
                }
                if(client != null && !client.isClosed()){
                    client.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }
}
