import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
    private Socket socket;
    private OutputStream os;

    public void connect() throws IOException {
        this.socket = new Socket("192.168.11.2", 3007);
        this.os = socket.getOutputStream();
    }

    public void setUserName(String name) throws IOException {
        String message = "set#" + name;
        os.write(message.getBytes());
    }

    public void matchWord(String word) throws IOException {
        String message = "match#" + word;
        os.write(message.getBytes());
    }
}
