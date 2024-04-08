import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

		RegistroDefault();

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
			teclado.nextLine();
			switch (opcao) {
				case 1:
					lista.add(CadastrarSessao());
					break;
				case 2:
					VerDetalhesSessao();
					break;
				case 3:
					break;
				case 4:
					System.out.println("**** Ordem Alfabética");
					lista.ordenarAZ();
					mostrarLista();
					break;
				case 5:
					System.out.println("**** Ordem Por Nota");
					lista.ordenarPorNota();
					MostrarFilmesPorNota();
					break;
				case 6:
					System.out.println("**** Ordem Por Data");
					lista.ordenarPorData();
					mostrarFilmeOrdemCronologica();
					break;
				case 7:
					System.out.println("**** Meus Filmes Favoritos");
					mostrarFavoritos();
					break;
				case 8:
					escolherLocal();
					break;
			}
		} while (opcao != 0);

	}

	// CRIA REGISTRO PARA DESENV
	public static void RegistroDefault() {
		Local l1 = new Local("Jockey Placa", "Cinemark", "um bom lugar");
		Local l2 = new Local("Cidade", "Cinemark da China", "lugar bem ruim");
		locais.add(l1);
		locais.add(l2);

		Filme f1 = new Filme("Meu Malvado Favorito", 5, true, "um bom filme", "Comédia");
		Filme f2 = new Filme("Meu Malvado Favorito 2", 5, true, "um filmaço", "Comédia");
		Filme f3 = new Filme("Homem Aranha", 3, false, "Mais o menos", "Ação");
		Filme f4 = new Filme("Bob Esponja", 5, true, "um filme excelente", "Animação");

		lista.add(new Sessao(f1, l1, 10, "Boa sessão", LocalDateTime.of(2014, 4, 28, 16, 0)));
		lista.add(new Sessao(f2, l2, 12, "Mais o menos", LocalDateTime.of(2014, 4, 28, 16, 0)));
		lista.add(new Sessao(f3, l1, 12.50F, "Top", LocalDateTime.of(2014, 4, 28, 16, 0)));
		lista.add(new Sessao(f4, l1, 12, "Top", LocalDateTime.of(2014, 4, 28, 16, 0)));
	}

	// MOSTRA E CLASSIFICA FILMES POR NOTA
	public static void MostrarFilmesPorNota() {
		System.out.println("\n*** Listagem de Filmes ***\n");
		Iterator<Sessao> il = lista.iterator();
		while (il.hasNext()) {
			Sessao sessao = il.next();
			System.out.println("Nota: " + sessao.getFilme().getNota() + " - " + sessao);
		}
	}

	// MOSTRAR LISTA EM ORDEM CRONOLÒGICA
	public static void mostrarFilmeOrdemCronologica() {
		System.out.println("\n*** Listagem de Filmes - Ordem Cronológica***\n");
		Iterator<Sessao> il = lista.iterator();
		while (il.hasNext()) {
			Sessao sessao = il.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd (EEE, HH'h'mm)");
			DateTimeFormatter formatterMesAno = DateTimeFormatter.ofPattern("MMMM/YYYY");
			System.out.println(sessao.getData_hora().format(formatterMesAno));
			System.out.println(sessao.getData_hora().format(formatter) + " - " + sessao.getFilme().getFilme() + " - "
					+ sessao.getLocal().getLocal());
		}
	}

	// MOSTRA FILMES FAVORITOS
	public static void mostrarFavoritos() {
		System.out.println("\n*** Listagem de Filmes Favoritos***\n");
		Iterator<Sessao> il = lista.iterator();
		while (il.hasNext()) {
			Sessao sessao = il.next();
			if (sessao.getFilme().isFavorito() == true) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(dd/MMM/yyyy, EEE)");
				System.out.println(sessao.getFilme().getFilme() + " - " + sessao.getData_hora().format(formatter)
						+ " - " + sessao.getLocal().getLocal());
			}
		}
	}

	// CADASTRA SESSÃO
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

		System.out.print("Preço: ");
		String preco = teclado.nextLine();
		System.out.print("Data [dd/mm/yyyy]: ");
		String data = teclado.nextLine();
		System.out.print("Hora [HH:MM]: ");
		String hora = teclado.nextLine();
		System.out.print("Comentário sobre a sessão: ");
		String comentarioSessao = teclado.nextLine();

		String dataSeparada[] = data.split("/");
		String horaSeparada[] = hora.split(":");
		int dia = Integer.parseInt(dataSeparada[0]);
		int mes = Integer.parseInt(dataSeparada[1]);
		int ano = Integer.parseInt(dataSeparada[2]);
		int horaInt = Integer.parseInt(horaSeparada[0]);
		int minuto = Integer.parseInt(horaSeparada[1]);

		Local localDaSessao = escolherLocal();

		LocalDateTime dataEHoraFormatada = LocalDateTime.of(ano, mes, dia, horaInt, minuto);

		Filme filmeCadastrado = new Filme(filme, Integer.valueOf(nota), Boolean.valueOf(favorito), comentarioDoFilme,
				genero);
		return (new Sessao(filmeCadastrado, localDaSessao, Float.valueOf(preco), comentarioSessao,
				dataEHoraFormatada));
	}

	// MOSTRA LOCAIS CADASTRADOS
	public static void mostrarLocais() {
		Iterator<Local> il = locais.iterator();
		while (il.hasNext()) {
			Local locais = il.next();
			System.out.println(locais.toString());
		}
	}

	// ESCOLHE LOCAL OU CADASTRA UM NOVO
	public static Local escolherLocal() {
		System.out.println("\n*** Listagem de Locais ***\n");
		Iterator<Local> il = locais.iterator();

		while (il.hasNext()) {
			Local locais = il.next();
			System.out.println(locais.toString());
		}

		System.out
				.print("\nQual foi o nome do local da sessão? Se nenhum?! P/ cadastrar digite 'S' p/ cadastrar \n");

		String nomeLocal = teclado.nextLine();
		for (Local local : locais) {
			if (local.getLocal().toUpperCase().contains(nomeLocal.toUpperCase())) {
				System.out.println("Achei " + local.getLocal());
				System.out.println("É o local procurado <S/N>? ");
				String conf = teclado.nextLine();
				if (conf.toUpperCase().charAt(0) == 'S')
					locais.add(local);
					return null;
			}
		}

		if (nomeLocal.toUpperCase().charAt(0)=='S') {
			System.out.print("Nome do lugar: ");
			String lugar = teclado.nextLine();
			System.out.print("Nome da Franquia: ");
			String franquia = teclado.nextLine();
			System.out.print("Comentário sobre o local: ");
			String comentarioLocal = teclado.nextLine();
			return (new Local(lugar, franquia, comentarioLocal));
		}

		return new Local();
	}

	// CADASTRAR FILME E SESSÃO
	public static void VerDetalhesSessao() {
		mostrarLista();

		System.out.print("\nQual foi o nome do filme? \n");
		String filme = teclado.nextLine();
		for (Sessao sessao : lista) {
			if (sessao.getFilme().getFilme().toUpperCase().contains(filme.toUpperCase())) {
				System.out.println("Achei " + sessao.getFilme().getFilme());
				System.out.println("É o filme procurado <S/N>? ");
				String conf = teclado.nextLine();
				if (conf.toUpperCase().charAt(0) == 'S') {
					String IsFavorito = sessao.getFilme().isFavorito() ? "Sim" : "Não";
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE - HH'h'mm");
					System.out.println(
							"******* Filme ***** \n\n" +
									"Nome: " + sessao.getFilme().getFilme() +
									"\nNota: " + sessao.getFilme().getNota() +
									"\nFavorito: " + IsFavorito +
									"\nData: " + sessao.getData_hora().format(formatter) +
									"\nPreço: " + sessao.getPreco() +
									"\nLocal: " + sessao.getLocal().getLocal() + " - " + sessao.getLocal().getFranquia()+
									"\nComentário da Sessão: " + sessao.getComentario() +
									"\nComentário do Filme: " + sessao.getFilme().getComentario());
				}
			}
		}
	}

	// MOSTRA LISTA DAS SESSOES SIMPLIFICADA
	public static void mostrarLista() {
		Iterator<Sessao> il = lista.iterator();
		while (il.hasNext()) {
			Sessao sessao = il.next();
			System.out.println(sessao.toString());
		}
	}
}
