public class serverModel {
    private Server server;

    public serverModel(controller controller) {
        this.server = new Server();
        this.server.connect(controller);
    }

    public void sendMessage(String msg){
        this.server.chat(msg);
    }
}
