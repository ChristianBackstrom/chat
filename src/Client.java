import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author magnus
 */
public class Client {
    private Socket socket;
    private PrintWriter out = null;

    public void connect(){
        String ip = (String) JOptionPane.showInputDialog(null,"IP?","Connect to..",JOptionPane.QUESTION_MESSAGE);
        int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Connect to..",JOptionPane.QUESTION_MESSAGE));       ;

        try {
            socket = new Socket(ip,port);
        } catch (Exception e) {
            System.out.println("Client failed to connect");
            System.exit(0);
        }
    }

    public void listener(controller controller){
        ListenerThread in = null;
        try {
            in = new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())), controller);
            Thread listener = new Thread(in);
            listener.start();
        } catch (IOException e) {
            System.out.println("Client failed to communicate");
        }
    }

    public void chat(String msg) {
        try {
            out = new PrintWriter(socket.getOutputStream(),true);

            out.println("client: " + msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }
}