import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

 public class TCPAsk {
    public static void main( String[] args) {
        String hostname;
        int port;
        String serverInput = null;
        String serverOutput;

        try {
            hostname = args[0];
            port = Integer.parseInt(args[1]);
            if (args.length >= 3) {
                // Collect remaining arguments into a single string
                StringBuilder builder = new StringBuilder();
                boolean first = true;
                for (int i = 2; i < args.length; i++) {
                    if (first)
                        first = false;
                    else
                        builder.append(" ");
                    builder.append(args[i]);
                }
                serverInput = builder.toString();
            }
        }
        catch (Exception ex) {
            System.err.println("Usage: TCPAsk host port <data to server>");
            return;
        }
        try {
            if(serverInput != null){
              serverOutput = TCPClient.askServer(hostname, port, serverInput);
            }else{
              serverOutput = TCPClient.askServer(hostname, port);
            }
            System.out.printf("%s:%d says:\n%s\n", hostname, port, serverOutput);
        } catch(IOException ex) {
            System.err.println(ex);
        }
    }
}
