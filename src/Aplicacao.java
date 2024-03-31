import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacao {
	private static Scanner teclado = new Scanner(System.in);

	private static Lista lista; 
	private static ArrayList<Local> locais = new ArrayList<>();

	public static void main(String[] args) {
		lista = new Lista();
		int opcao;

		setarLocaisDefault();

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
					lista.add(CadastrarSessao());
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

	public static void setarLocaisDefault(){
		locais.add(new Local(0, "Jockey Placa", "Cinemark", "um bom lugar"));
		locais.add(new Local(1, "Cidade", "Cinemark da China", "lugar bem ruim"));
	}

	public static void MostrarFilmesCadastrados(){
		System.out.println("\n*** Listagem de filmes ***\n");
        Iterator<Sessao> ic = lista.iterator();
        while (ic.hasNext()){ 
            Sessao sessao = ic.next(); 
            System.out.println(sessao.toString());
        }
	}

	public static Sessao CadastrarSessao() {
		System.out.println("\n --- Informar Filme: --- \n");
		System.out.print("Filme: ");
		String filme = teclado.nextLine();
		System.out.print("Nota: [De 1 a 5 estrelas] ");
		String nota = teclado.nextLine();
		System.out.print("Filme favorito? ");
		String favorito = teclado.nextLine();
		System.out.print("Genero: ");
		String genero = teclado.nextLine();
		System.out.print("Comentário sobre o filme: ");
		String comentarioDoFilme = teclado.nextLine();

		System.out.print("Preço: [00.00]");
		String preco = teclado.nextLine();
		System.out.print("Data e hora: [dd/mm/yy - HH:mm]");
		String dataEhora = teclado.nextLine();
		System.out.print("Comentário sobre a sessão: ");
		String comentarioSessao = teclado.nextLine();

		Local localDaSessao = escolherLocal();

		Filme filmeCadastrado = new Filme(filme, Integer.valueOf(nota), Boolean.valueOf(favorito), comentarioDoFilme, genero);
		return (new Sessao(filmeCadastrado, localDaSessao, Integer.valueOf(preco), comentarioSessao, dataEhora));
	}

	public static Local escolherLocal(){
		System.out.println("\n*** Listagem de Locais ***\n");
        Iterator<Local> il = locais.iterator();
		
        while (il.hasNext()){ 
            Local locais = il.next(); 
            System.out.println(locais.toString());
        }

		System.out.print("Qual foi o id do local da sessão? [id] \n");
		System.out.print("Se nenhum: n \n");

		
		String localId = teclado.nextLine();

		return locais.get(Integer.valueOf(localId));
	}
}
