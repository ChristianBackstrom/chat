import java.util.Scanner;

public class View {
    private Scanner in;

    public View() {
        this.in = new Scanner(System.in);
    }

    public String sendMSG(){
        return in.nextLine();
    }
}
