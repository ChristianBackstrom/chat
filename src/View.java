import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel panel;
    private JList messages;
    private JTextField ServerMessage;
    private JButton sendClient;
    private JButton sendServer;
    private JTextField ClientMessage;
    private DefaultListModel list;

    public String getServerMessage() {
        return ServerMessage.getText();
    }

    public String getClientMessage() { return ClientMessage.getText(); }

    public View(boolean client) {
        list = new DefaultListModel();

        panel = new JPanel();
        messages = new JList(list);

        if (client == true){
            ClientMessage = new JTextField(80);
            panel.add(ClientMessage);
            sendClient = new JButton("send");
            panel.add(sendClient);
        } else {
            ServerMessage = new JTextField(80);
            panel.add(ServerMessage);
            sendServer = new JButton("send");
            panel.add(sendServer);
        }
        panel.add(messages);
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void clearmsg(){
        ServerMessage.setText(null);
        ClientMessage.setText(null);
    }

    public void chatUpdate(String msg){
        list.addElement(msg);
    }

    void addSendClientListener(ActionListener listenForLoadListener) {
        this.sendClient.addActionListener(listenForLoadListener);
        this.ClientMessage.addActionListener(listenForLoadListener);
    }
    void addSendServerListener(ActionListener listenForLoadListener) {
        this.sendServer.addActionListener(listenForLoadListener);
        this.ServerMessage.addActionListener(listenForLoadListener);
    }
}