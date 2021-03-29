public class clientController {
    public static void main(String[] args) {
        clientModel model = new clientModel();
        View view = new View();


        model.sendMessage(view.sendMSG());
    }
}
