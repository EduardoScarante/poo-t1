import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
public class Lista implements Iterable<Sessao> {
	private ArrayList<Sessao> lista;

	public Lista() {
		lista = new ArrayList<Sessao>();
	}

	public void add(Sessao filme) {
		lista.add(filme);
	}

	public ArrayList<Sessao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Sessao> lista) {
		this.lista = lista;
	}

	public void ordenarAZ() {
		Collections.sort(lista);
	}

	public void ordenarPorNota() {
		Collections.sort(lista, new Comparator<Sessao>() {
			@Override
			public int compare(Sessao s1, Sessao s2) {
				Integer n1 = s1.getFilme().getNota();
				Integer n2 = s2.getFilme().getNota();
				return n2.compareTo(n1);
			}
		});
	}

	public void ordenarPorData() {
		Collections.sort(lista, new Comparator<Sessao>() {
			@Override
			public int compare(Sessao s1, Sessao s2) {
				LocalDateTime n1 = s1.getData_hora();
				LocalDateTime n2 = s2.getData_hora();
				return n2.compareTo(n1);
			}
		});
	}

	@Override
	public Iterator<Sessao> iterator() {
		return lista.iterator();
	}
}
