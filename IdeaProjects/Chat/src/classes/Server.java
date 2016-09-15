package classes;

import java.net.*;
import java.io.*;

/**
 * Created by Влад on 9/15/2016.
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(1201);
            Socket socket = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String msgInput=" ",msgOutput=" ";

            while(!msgInput.equals("end!")){
                msgInput = inputStream.readUTF();
                System.out.println(msgInput);
                msgOutput = reader.readLine();
                outputStream.writeUTF(msgOutput);
                outputStream.flush();
            }
            socket.close();
        }
        catch(Exception e){e.printStackTrace();}
    }
}
