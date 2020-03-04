import java.net.*;
import java.io.*;

public class HTTPAsk {
    public static void main( String[] args) throws IOException {
      String http_ok = "HTTP/1.1 200 OK\r\n\r\n";
      String http_404 = "HTTP/1.1 404 Not Found\r\n\r\n";
      String http_400 = "HTTP/1.1 400 Bad Request\r\n\r\n";
      String urlString;
      String string = "";
      String host = "";
      int port = 0;
      int PORT_NUMBER = Integer.parseInt(args[0]);
      ServerSocket serverSock = new ServerSocket(PORT_NUMBER);
      try{
        while(true){
          Socket connectSock = serverSock.accept();
          PrintWriter toClient = new PrintWriter(connectSock.getOutputStream());
          BufferedReader in = new BufferedReader(new InputStreamReader(connectSock.getInputStream()));
          urlString = in.readLine();
          if(!checkRequest(urlString)){
            toClient.print(http_400);
            toClient.close();
            in.close();
            connectSock.close();
          }else{
            String[] url = urlString.split("[\\=&?\\u0020]");
            for(int i = 0; i < url.length - 1; i++){
              if(url[i].equals("hostname")){
                host = url[i + 1];
              }else if(url[i].equals("port")){
                port = Integer.parseInt(url[i + 1]);
              }else if(url[i].equals("string")){
                string = url[i + 1];
              }
            }
            if(string == ""){
              String resp1 = TCPClient.askServer(host, port);
              toClient.print(http_ok);
              toClient.print(resp1);
              toClient.close();
              in.close();
              connectSock.close();
            }else{
              String resp2 = TCPClient.askServer(host, port, string);
              toClient.print(http_ok);
              toClient.print(resp2);
              toClient.close();
              in.close();
              connectSock.close();
            }
          }
      }
      }catch(IOException x){
        System.out.println(x);
      }

    }
    public static boolean checkRequest(String s){
      if(s == null){
        return false;
      }
      if(s.contains("GET") && s.contains("/ask")){
        return true;
      }
      return false;
    }


}
