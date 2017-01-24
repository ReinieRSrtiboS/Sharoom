package com.syntesizer.reinier2.sharoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Connection {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    int id = 404;

    //maakt de connectie aan
    protected Connection() {
        try {
//            socket = new Socket("10.53.159.89", 8080);  //ip-adres, port
            socket = new Socket("192.168.2.84", 7070);
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void sendFeedBack(int feedback) {
        System.out.println(feedback);
        try {
            out.writeInt(feedback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void sendQuestion(String text) {
        try {
            out.writeInt(999);
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int getID() {
        return id;
    }

    protected void Close() {
        try {
            out.writeInt(404);  //data voor server om af te sluiten
            socket.close();     // sluit de connectie
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getQuestion() {
        List<String> result = new ArrayList<>();
        try {
            out.writeInt(997);
            in = new DataInputStream(socket.getInputStream());
            while(in.readInt() != 999) {
                result.add(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Socket getSocket() {
        return socket;
    }
}