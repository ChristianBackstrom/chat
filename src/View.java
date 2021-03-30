import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel panel;
    private JList messages;
    private JTextField sendMessage;
    private JButton sendClient;
    private JButton sendServer;
    private DefaultListModel list;

    public String getSendMessage() {
        return sendMessage.getText();
    }

    public View(boolean client) {
        list = new DefaultListModel();

        panel = new JPanel();
        messages = new JList(list);
        sendMessage = new JTextField(70);
        panel.add(messages);
        panel.add(sendMessage);
        if (client == true){
            sendClient = new JButton("send");
            panel.add(sendClient);
        } else {
            sendServer = new JButton("send");
            panel.add(sendClient);
        }
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void chatUpdate(String msg){
        list.addElement(msg);
    }

    void addSendClientListener(ActionListener listenForLoadListener) { this.sendClient.addActionListener(listenForLoadListener); }
    void addSendServerListener(ActionListener listenForLoadListener) { this.sendServer.addActionListener(listenForLoadListener); }
}