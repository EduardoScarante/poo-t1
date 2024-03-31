import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacao {

	// usar a lista de sessões
	private static Lista lista; // IDEM a turma do Projeto Usuario8
	// para simular o banco de dados dos locais
	private ArrayList<Local> locais; // IDEM turma, main7, Projeto Usuario6
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		lista = new Lista();
		int opcao;
		do {
			System.out.println("\n*** Menu principal ***\n");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar filme");
			System.out.println("2 - Mostrar dados filme (filme, sessão)");
			System.out.println("3 - Editar Filme");
			System.out.println("4 - Listagem ordem alfabética");
			System.out.println("5 - Listagem ordem avaliação");
			System.out.println("6 - Listagem cronológica");
			System.out.println("7 - Listagem favoritos");
			System.out.print("\n>> Opcao?  ");

			opcao = teclado.nextInt();
			teclado.nextLine(); // consumir o enter que ficou no buffer
			switch (opcao) {
				case 1:
					lista.append(CadastrarFilme());
					break;
				case 2:
					MostrarFilmesCadastrados();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
			}
		} while (opcao != 0);

	}

	public static void MostrarFilmesCadastrados(){
		System.out.println("\n*** Listagem de filmes ***\n");
        Iterator<Filme> ic = lista.iterator();
        while (ic.hasNext()){ 
            Filme filmes = ic.next(); 
            System.out.println(filmes.toString());
        }
	}

	public static Filme CadastrarFilme() {
		System.out.println("\n --- Cadastrar Filme: --- \n");
		System.out.print("Filme: ");
		String filme = teclado.nextLine();
		System.out.print("Nota: [De 1 a 5 estrelas] ");
		String nota = teclado.nextLine();
		System.out.print("Filme favorito? ");
		String favorito = teclado.nextLine();
		System.out.print("Genero: ");
		String genero = teclado.nextLine();
		System.out.print("Comentário: ");
		String comentario = teclado.nextLine();

		return (new Filme(filme, Integer.valueOf(nota), Boolean.valueOf(favorito), comentario, genero));
	}
}
