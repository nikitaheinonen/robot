import java.lang.Runnable;
import java.net.*;
import java.io.*;

public class ConcHTTPAsk {
    public static void main( String[] args) throws IOException {
      int PORT_NUMBER = Integer.parseInt(args[0]);
      ServerSocket serverSock = new ServerSocket(PORT_NUMBER);
      while(true){
        MyRunnable mr = new MyRunnable(serverSock.accept());
        Thread thread = new Thread(mr);
        thread.start();
      }
    }


}
