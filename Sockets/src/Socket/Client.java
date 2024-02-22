package Socket;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	static Scanner sc;
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        sc = new Scanner(System.in);
        String input = null;
        while(true) {
            //establish socket connection to server
            socket = new Socket("127.0.0.1", 9876);
            
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            
            //get manual input
            input = sc.nextLine();
            oos.writeObject(input);
            if(input.equals("exit")) break;
            else if(input.equals("abmelden")) abmelden();
            
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            
            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
	private static void abmelden() throws IOException {
		// creating list of process
        List<String> list = new ArrayList<String>();
        list.add("");
 
        // create the process
        ProcessBuilder build = new ProcessBuilder(list);
 
        // checking the command i list
        System.out.println("command: " + build.command());
        
        build.start();
	}
}