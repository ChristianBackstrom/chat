import javax.swing.*;
import java.awt.event.ActionListener;

public class view extends JFrame{
    private JPanel panel;
    private JList messages;
    private JTextField sendMessage;
    private JButton send;
    private DefaultListModel list;

    public String getSendMessage() {
        return sendMessage.getText();
    }

    public void view() {
        list = new DefaultListModel();

        panel = new JPanel();
        messages = new JList(list);
        sendMessage = new JTextField();
        send = new JButton("send");
        panel.add(messages);
        panel.add(sendMessage);
        panel.add(send);
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void chatUpdate(String msg){
        list.addElement(msg);
    }

    void addSendListener(ActionListener listenForLoadListener) { this.send.addActionListener(listenForLoadListener); }
}
