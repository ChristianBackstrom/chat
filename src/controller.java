import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller {
    private View view;
    private clientModel clientModel;
    private serverModel serverModel;

    public void serverController() {
        this.view = new View(false);
        this.serverModel = new serverModel(this);
        this.view.addSendServerListener(new sendClientMessage());
    }

    public void clientController() {
        this.view = new View(true);
        this.clientModel = new clientModel(this);
        this.view.addSendClientListener(new sendClientMessage());
    }

    public void messageUpdate(String msg){
        view.chatUpdate(msg);
    }

    private class sendClientMessage implements ActionListener {
        public void actionPerformed(ActionEvent e){
            clientModel.sendMessage(view.getSendMessage());
        }
    }

    private class sendServerMessage implements ActionListener {
        public void actionPerformed(ActionEvent e){
            serverModel.sendMessage(view.getSendMessage());
        }
    }
}