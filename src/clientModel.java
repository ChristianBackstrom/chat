public class clientModel {
    private Client client;


    public clientModel() {
        this.client.connect();
        this.client.listener();
    }

    public void sendMessage(String msg){
        client.chat(msg);
    }
}
