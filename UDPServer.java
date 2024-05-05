import java.io.*;
import java.net.*;

public class UDPServer {
    public static final int PORT = 9876;
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Server Started");

            byte[] receiveData = new byte[BUFFER_SIZE];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("RECEIVED: " + message);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String response = "Echo: " + message;
                sendData = response.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Echoing: " + message);

                if (message.equals("END"))
                    break;

                // Clear receiveData buffer for next iteration
                receiveData = new byte[BUFFER_SIZE];
            }

            System.out.println("Closing server");
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
