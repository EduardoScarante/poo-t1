import java.util.ArrayList;
import java.util.Iterator;

// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Filme>{
	private ArrayList<Filme> lista;


	public Lista() {
		lista = new ArrayList<Filme>();
	}

	public void append(Filme filme){
        lista.add(filme);
    }

	public ArrayList<Filme> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Filme> lista) {
		this.lista = lista;
	}

	@Override
	public Iterator<Filme> iterator() {
		return lista.iterator();
	}
	
	// toString

}
