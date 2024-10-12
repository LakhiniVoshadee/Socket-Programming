import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            //remote socket

            // request to the server
            Socket socket = new Socket("localhost", 5000);
            // data write


            System.out.println("Server Accepted!");
           while (true) {

               System.out.println("Enter message");
               String message = scanner.nextLine();
               DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
               dataOutputStream.writeUTF(message);
               dataOutputStream.flush();

               DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
               String serverMessage = dataInputStream.readUTF();
               System.out.println(serverMessage);
               if (serverMessage.equals("exit")) {
                   break;
               }

           }
            socket.close();



            /*   String message = "Hello I'm from client!";*/


            //send the data





            //close the connection

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }




}
