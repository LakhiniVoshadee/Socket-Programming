import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    public static void main(String[] args) throws IOException {

        //================ STEPS =======================


        //create server socket


        try {
           ServerSocket serverSocket = new ServerSocket(5000);

        //create local socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted!");

            Scanner input = new Scanner(System.in);
            while (true) {
                //data reading

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                //sout - read data

                String message = dataInputStream.readUTF();
                System.out.println(message);

                System.out.println("Input massage: ");
                String severMessage = input.nextLine();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(severMessage);
                dataOutputStream.flush();
                if(message.equals("exit")){
                    break;
                }
            }
            socket.close();



        //sout


        //close the connection

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}