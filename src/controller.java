import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller {
    private View view;
    private clientModel clientModel;
    private serverModel serverModel;
    private String lastMSG;

    public void serverController() {
        this.view = new View(false);
        this.serverModel = new serverModel(this);
        this.view.addSendServerListener(new sendServerMessage());
    }

    public void clientController() {
        this.view = new View(true);
        this.clientModel = new clientModel(this);
        this.view.addSendClientListener(new sendClientMessage());
    }

    public void messageUpdate(String msg){
        System.out.println("updated");
        if (msg != null && !msg.isEmpty())
            if (!msg.equals(lastMSG))
                view.chatUpdate(msg);
    }

    private class sendClientMessage implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.chatUpdate("client: " + view.getClientMessage());
            clientModel.sendMessage(view.getClientMessage());
            view.clearmsg();
        }
    }

    private class sendServerMessage implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.chatUpdate("server: " + view.getServerMessage());
            serverModel.sendMessage(view.getServerMessage());
            view.clearmsg();
        }
    }
}