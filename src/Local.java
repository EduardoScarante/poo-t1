import java.util.ArrayList;
import java.util.Iterator;

public class Local implements Iterable<Local>{
	private Integer id; 
	private String local; 
	private String franquia; 
	private String comentarios;

	private ArrayList<Local> listaLocais;

	public Local() {
		listaLocais = new ArrayList<Local>();
	}

	public void add(Local local){
        listaLocais.add(local);
    }

	public Local getLocal(Integer i) {
		return listaLocais.get(i);
	}


	@Override
    public Iterator<Local> iterator() {
        return listaLocais.iterator();
    }


	public Local(Integer id, String local, String franquia, String comentarios) {
		this.id = id;
		this.local = local;
		this.franquia = franquia;
		this.comentarios = comentarios;
	}


	@java.lang.Override
	public java.lang.String toString() {
		return id + " - "  + local + " - " + franquia + " - " +  comentarios;
	}
}
