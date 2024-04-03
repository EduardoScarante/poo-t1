import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacao {
	private static Scanner teclado = new Scanner(System.in);

	private static Lista lista;
	private static Local locais;

	public static void main(String[] args) {
		lista = new Lista();
		locais = new Local();

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
			System.out.println("8 - Extra - Listagem locais");
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
				case 8:
					escolherLocal();
					break;
			}
		} while (opcao != 0);

	}

	public static void setarLocaisDefault() {
		locais.add(new Local("Jockey Placa", "Cinemark", "um bom lugar"));
		locais.add(new Local("Cidade", "Cinemark da China", "lugar bem ruim"));
	}

	public static void MostrarFilmesCadastrados() {
		System.out.println("\n*** Listagem de Filmes ***\n");
		Iterator<Sessao> il = lista.iterator();
		while (il.hasNext()) {
			Sessao sessao = il.next();
			System.out.println(sessao.getFilme().toString());
		}

		System.out.print("\nQual foi o nome do filme? \n");
		String filme = teclado.nextLine();
		for (Sessao sessao: lista){
			if (sessao.getFilme().getFilme().toUpperCase().contains(filme.toUpperCase())){
				System.out.println("Achei "+ sessao.getFilme().toString());
				System.out.println("É o filme procurado <S/N>? ");
				String conf = teclado.nextLine();
				if (conf.toUpperCase().charAt(0)=='S')
					System.out.println(sessao.toString());
			}
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

		Filme filmeCadastrado = new Filme(filme, Integer.valueOf(nota), Boolean.valueOf(favorito), comentarioDoFilme,
				genero);
		return (new Sessao(filmeCadastrado, localDaSessao, Integer.valueOf(preco), comentarioSessao, dataEhora));
	}

	public static void mostrarLocais() {
		Iterator<Local> il = locais.iterator();
		while (il.hasNext()) {
			Local locais = il.next();
			System.out.println(locais.toString());
		}
	}

	public static Local escolherLocal(){
		System.out.println("\n*** Listagem de Locais ***\n");
        Iterator<Local> il = locais.iterator();
		
        while (il.hasNext()){ 
            Local locais = il.next(); 
            System.out.println(locais.toString());
        }

		System.out.print("\nQual foi o nome do local da sessão? Se nenhum?! P/ cadastrar digite 'new' p/ cadastrar \n");
	
		String nomeLocal = teclado.nextLine();
		for (Local local: locais){
			if (local.getLocal().toUpperCase().contains(nomeLocal.toUpperCase())){
				System.out.println("Achei "+ local.getLocal());
				System.out.println("É o local procurado <S/N>? ");
				String conf = teclado.nextLine();
				if (conf.toUpperCase().charAt(0)=='S')
					return local;
			}
		}

		if(nomeLocal == "new"){
			System.out.print("Nome do lugar: \n");
			String lugar = teclado.nextLine();
			System.out.print("Nome da Franquia: \n");
			String franquia = teclado.nextLine();
			System.out.print("Comentário sobre o local: \n");
			String comentarioLocal = teclado.nextLine();
			return (new Local(lugar, franquia, comentarioLocal));
		}

		return new Local();
}}
