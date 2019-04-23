import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.Socket;

import java.io.*;



public class Client {

  public static void main(String[] args) {

    String temp;

    String displayBytes;

    try {

      BufferedReader inFromUser = new BufferedReader(new 
InputStreamReader(System.in));

      Socket clientSocket = new Socket("192.168.188.133",5000);

      DataOutputStream outToServer =

      new DataOutputStream(clientSocket.getOutputStream());

      System.out.print("Message To Server: ");

      BufferedReader inFromServer =

      new BufferedReader(new 
InputStreamReader(clientSocket.getInputStream()));

      //System.out.print("Message From Server: ");

      temp = inFromUser.readLine();

      outToServer.writeBytes(temp);

      //read line from server
      //displayBytes = inFromServer.readLine();

      while((displayBytes = inFromServer.readLine()) != null) {

        System.out.print(displayBytes);

      }

      clientSocket.close();

    }

    catch(Exception ex) {

    }

  }

}
