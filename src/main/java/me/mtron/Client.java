package me.mtron;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable{

    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean done;
    @Override
    public void run() {
        try {
            client = new Socket("127.0.0.1", 6969);
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();

            String inMessage;
            while ((inMessage = dis.readUTF()) != null){
                System.out.println(inMessage);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            shutdown();
        }
    }

    public void shutdown(){
        done=true;
        try {
            dis.close();
            dos.close();
            if(!client.isClosed()){
                client.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    class InputHandler implements Runnable{
        @Override
        public void run() {
            try {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
                while (!done){
                    String message = inReader.readLine();
                    if(message.equals("/quit")){
                        dos.writeUTF(message);
                        inReader.close();
                        shutdown();
                    }else{
                        dos.writeUTF(message);
                        dos.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                shutdown();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
