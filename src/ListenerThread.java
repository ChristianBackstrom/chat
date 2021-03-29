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

    public ListenerThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
                System.out.println(msg);
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