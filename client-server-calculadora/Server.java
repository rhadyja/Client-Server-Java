import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
        try{
            ServerSocket ser = new ServerSocket(9999);
            Socket sock = ser.accept();
            
            
            BufferedReader ed = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tmp = ed.readLine();
            
            String[] str = tmp.split(" ");
            
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[2]);
            
            
            double o = 0;

            switch (str[1].charAt(0)) {
                case '+':
                    o = num1 + num2;
                    break;

                case '-':
                    o = num1 - num2;
                    break;

                case '*':
                    o = num1 * num2;
                    break;

                case '/':
                    o = num1 / num2;
                    break;

                default:
                    System.out.println("ERRO!");
                    break;
            }
            
            System.out.println(num1 + " " + str[1] + " " + num2 + " = " + o);
            
        }catch(Exception ex){
            
        }
    }
}