import java.util.ArrayList;
import java.util.Iterator;

// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Sessao>{
	private ArrayList<Sessao> lista;

	public Lista() {
		lista = new ArrayList<Sessao>();
	}

	public void add(Sessao filme){
        lista.add(filme);
    }

	public ArrayList<Sessao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Sessao> lista) {
		this.lista = lista;
	}

	@Override
	public Iterator<Sessao> iterator() {
		return lista.iterator();
	}
	
	// toString

}
