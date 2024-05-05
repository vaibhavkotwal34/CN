import java.io.*;
import java.net.*;

public class UDPClient {
    public static final int SERVER_PORT = 9876;
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            byte[] sendData;
            byte[] receiveData = new byte[BUFFER_SIZE];

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter the message to send to server:");
                String message = userInput.readLine();

                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("FROM SERVER: " + response);

                if (message.equals("END"))
                    break;
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
