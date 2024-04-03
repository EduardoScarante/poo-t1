import java.util.ArrayList;
import java.util.Iterator;

public class Local implements Iterable<Local>, Comparable<Local>{
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


	public Local(String local, String franquia, String comentarios) {
		this.local = local;
		this.franquia = franquia;
		this.comentarios = comentarios;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Local> getListaLocais() {
		return listaLocais;
	}

	public void setListaLocais(ArrayList<Local> listaLocais) {
		this.listaLocais = listaLocais;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return local + " - " + franquia + " - " +  comentarios;
	}

	@Override
    public int compareTo(Local local) {
        return this.local.compareToIgnoreCase(local.local);
    }

}
