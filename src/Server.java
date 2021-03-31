import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author magnus
 */
public class Server {

    private boolean run;
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out = null;


    public void connect(controller controller) {
        int port = 1234;
        boolean run = true;
        System.out.println("Server started.");
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Waiting for connections!");
        try {
            socket = serverSocket.accept();
            System.out.println("connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
        listener(controller);
    }

    public void listener(controller controller){
            ListenerThread in = null;
            try {
                in = new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())), controller);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread listen = new Thread(in);
        listen.start();
    }

    public void chat(String msg){
        try {
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("SERVER: " + msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void close() throws IOException {
        out.close();
        socket.close();
    }
}