import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * This is a class
 * Created 2021-03-16
 *
 * @author Magnus Silverdal
 */
public class ListenerThread implements Runnable{
    private BufferedReader in;
    private controller controller;

    public ListenerThread(BufferedReader in, controller controller) {
        this.in = in;
        this.controller = controller;
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
                controller.messageUpdate(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop()  {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}