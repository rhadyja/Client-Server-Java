import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		try {
		//Declarar o socket cliente
		Socket cliente = new Socket("127.0.0.1", 7000);
		
		//receber informações do teclado do cliente
		Scanner teclado = new Scanner(System.in);

		//servidor vai informar ao cliente alguns dados de entrada
		// receber os dados que o servidor vai estar digitando
		// e mostrar ao cliente 
		Scanner chegada = new Scanner(cliente.getInputStream());
		
		// Fluxo de dados pra envio
		//saida de dados 
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		

		String mensagem = ""; //oq o cliente vai enviar
		do{
			System.out.println("Informe a mensagem a ser enviada para o servidor: ");
			mensagem = teclado.nextLine(); //quando der enter vai mandar essa mensagem pro servidor
			saida.println(mensagem);//mandando a mensagem para o servidor
			//aguarda o servidor responder
			String resposta = chegada.nextLine(); //quando o servidor der enter lá o cliente recebe a resposta
			System.out.println("A resposta para a |" + mensagem + "| foi: "+ resposta);
			System.out.println("/////////////////////");
		}while(mensagem.length()!=0);

		cliente.close(); //fechamento da conexão

		} catch (Exception e) {
			System.out.println("Ocorreu um erro durante a conexao");
		}
		 

	}

}
