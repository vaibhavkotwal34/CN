import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                System.out.print("Enter message to send to server: ");
                message = userInput.readLine();
                out.println(message);

                String response = in.readLine();
                System.out.println("Server response: " + response);

                if (message.equals("END"))
                    break;
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
