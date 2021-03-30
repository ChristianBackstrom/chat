public class clientModel {
    private Client client;


    public clientModel(controller controller) {
        this.client = new Client();
        this.client.connect();
        this.client.listener(controller);
    }

    public void sendMessage(String msg){
        client.chat(msg);
    }
}
