import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Cliente{
    public static void main(String[] args){
        try{
            Socket sock = new Socket("localhost", 9999);
            
            PrintStream pr = new PrintStream(sock.getOutputStream());
            
            System.out.print("Operacao: ");
            
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader ed = new BufferedReader(rd);
            
            String temp = ed.readLine();
            
            pr.println(temp);
        }
        catch(Exception ex){
            
        }
    }
}