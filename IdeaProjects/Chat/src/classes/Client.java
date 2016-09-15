package classes;

import java.net.*;
import java.io.*;

/**
 * Created by Влад on 9/15/2016.
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1",1201);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msgInput="",msgOutput="";
            while(!msgInput.equals("end!")){
                msgInput = inputStream.readUTF();
                System.out.println(msgInput);
                msgOutput = reader.readLine();
                outputStream.writeUTF(msgOutput);
                outputStream.flush();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
