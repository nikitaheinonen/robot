package tcpclient;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TCPClient {
  private static int BUFFERSIZE = 1024;
  private static int TIMEOUT = 3000; //time in ms

    /*
    @param hostname ----------  name of host
    @param port --------------  port number of server
    @param ToServer ----------  Message to server*/
    public static String askServer(String hostname, int port, String ToServer) throws  IOException {
      byte[] fromUserBuffer = new byte[BUFFERSIZE];
      byte[] fromServerBuffer = new byte[BUFFERSIZE];
      Socket clientSocket = new Socket(hostname, port);
      clientSocket.setSoTimeout(TIMEOUT);//throw a timeout if socket doesnt get any data from server
      fromUserBuffer = ToServer.getBytes(); //store message to server in bytes
      int fromUserLength = fromUserBuffer.length;
      clientSocket.getOutputStream().write(fromUserBuffer, 0, fromUserLength);
      clientSocket.getOutputStream().write('\n');
      String response = getRespose(fromServerBuffer, clientSocket);
      return response;
    }
    /*@param hostname ----------  name of host
      @param port --------------  port number of server */
    public static String askServer(String hostname, int port) throws  IOException {
      byte[] fromServerBuffer = new byte[BUFFERSIZE]; //array buffer to response form server
      Socket clientSocket = new Socket(hostname, port); //connect new socket
      clientSocket.setSoTimeout(TIMEOUT);
      String response = getRespose(fromServerBuffer, clientSocket);
      return response;
    }
    //helpmethod to avoid code duplication
    private static String getRespose(byte[] b, Socket socket) throws IOException{
      int len = socket.getInputStream().read(b);//put stream from server in serverbuffer
      String decodedMessage = new String(b, 0, len, StandardCharsets.UTF_8);//decode message form bytes
      socket.close();
      return decodedMessage;
    }

}
