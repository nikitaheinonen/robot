import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HTTPEcho {


  public static void main( String[] args) throws IOException{
      String http = "HTTP/1.1 200 OK\r\n\r\n";
      String check;
      int PORT_NUMBER = Integer.parseInt(args[0]);
      ServerSocket serverSock = new ServerSocket(PORT_NUMBER);
      while(true){
        Socket connectSock = serverSock.accept();
        PrintWriter toClient = new PrintWriter(connectSock.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(connectSock.getInputStream()));
        toClient.print(http);//print the http response
        //Read one line at a time, check if line exists and that its not 0
        while((check = in.readLine()) != null && check.length() != 0){
          toClient.print(check);//send back the line with carriage return
          toClient.print("\r\n");
        }
        toClient.close();
        in.close();
        connectSock.close();


      }
  }
}
