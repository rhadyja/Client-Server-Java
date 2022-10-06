import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AtendeCliente extends Thread {
	Socket cliente;

	AtendeCliente(Socket cli) {
		this.cliente = cli;
	}

	@Override
	public void run() {

		System.out.println("Cliente conectado com thread (" + this.getId() + 
				") : " + cliente.getInetAddress());

		Scanner teclado = new Scanner(System.in); //servidor vai digitar
		Scanner chegada; // cliente está digitando ou vai digitar

		InputStreamReader fluxoDados;

		try {
			chegada = new Scanner(cliente.getInputStream()); //chegada da mensagem que o cliente mandou
			
			PrintStream saida = new PrintStream(cliente.getOutputStream()); // a saida da mensagem do servidor vai para o cliente

			while (chegada.hasNextLine()) { //enquanto o meu cliente estiver mandando mensagem
				String msgChegadaCliente = chegada.nextLine();
				System.out.println("Responda para (" + msgChegadaCliente + "):");
				String msgResposta = teclado.nextLine(); //mensagem digitada pelo servidor
				saida.println(msgResposta); //a resposta saiu para ser enviada ao cliente
				System.out.println("/-----------------------------------/");
			}

			System.out.println("Cliente Finalizado: " + cliente.getInetAddress() + 
					" da thread (" + this.getId() + ")");

			cliente.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
