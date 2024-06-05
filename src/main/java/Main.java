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
     clientSocket.getOutputStream().write(
      "HTTP/1.1 200 OK\r\n\r\n".getBytes()
     );

      } catch (IOException e) {

         System.out.println("IOException: " + e.getMessage());
        }
  }
}
