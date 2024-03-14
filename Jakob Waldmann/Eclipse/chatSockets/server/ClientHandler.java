import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Server chatServer;
    private Socket connectionToClient;

    private String name;

    private BufferedReader fromClientReader;
    private PrintWriter toClientWriter;

    public ClientHandler(Server chatServer, Socket connectionToClient) {
        this.chatServer = chatServer;
        this.connectionToClient = connectionToClient;

        name = connectionToClient.getInetAddress().getHostAddress();

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            fromClientReader = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
            toClientWriter = new PrintWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            chatServer.broadcastMessage(name + " connected.");

            String message = fromClientReader.readLine();
            while (message != null) {
                chatServer.broadcastMessage(name + ": " + message);
                message = fromClientReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            chatServer.removeClient(this);
            chatServer.broadcastMessage(name + " disconnected.");

            if (fromClientReader != null) {
                try {
                    fromClientReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (toClientWriter != null) {
                toClientWriter.close();
            }
        }
    }

    public void sendMessage(String message) {
        toClientWriter.println(message);
        toClientWriter.flush();
    }
}