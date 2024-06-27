import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//Test comment

public class Main {
  public static void main(String[] args) {
    System.out.println("Logs from your program will appear here!");

    
   ServerSocket serverSocket = null;
   Socket clientSocket = null;
   
   try {

     serverSocket = new ServerSocket(4221);
     serverSocket.setReuseAddress(true);
     clientSocket = serverSocket.accept(); 
     System.out.println("accepted new connection");
     InputStream input = clientSocket.getInputStream();
     BufferedReader reader = new BufferedReader(new InputStreamReader(input));
     String line = reader.readLine();
     String[] HttpRequest = line.split(" ", 0);
     OutputStream output = clientSocket.getOutputStream();
     if (HttpRequest[1].equals("/")) {
       output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
     } else {
       output.write("HTTP/1.1 404 Not Found\r\n\r\n".getBytes());
     }
     clientSocket.getOutputStream().write(output.toString().getBytes());

      } catch (IOException e) {

         System.out.println("IOException: " + e.getMessage());
        }
  }
}
