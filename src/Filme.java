
public class Filme implements Comparable<Filme> {
	private String filme;
	private int nota; // de 0 a 5
	private boolean favorito;
	private String comentario;
	private String genero;

	//Construtor
	public Filme(String filme, int nota, boolean favorito, String comentario, String genero) {
		this.filme = filme;
		this.nota = nota;
		this.favorito = favorito;
		this.comentario = comentario;
		this.genero = genero;
	}

	// Getters

	public String getFilme() {
		return filme;
	}
	public int getNota() {
		return nota;
	}
	public boolean isFavorito() {
		return favorito;
	}
	public String getComentario() {
		return comentario;
	}
	public String getGenero() {
		return genero;
	}

	// Setters
	
	public void setFilme(String filme) {
		this.filme = filme;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	// ToString

	@java.lang.Override
	public java.lang.String toString() {
		return "Filme{" +
				"filme='" + filme + '\'' +
				", nota=" + nota +
				", favorito=" + favorito +
				", comentario='" + comentario + '\'' +
				", genero='" + genero + '\'' +
				'}';
	}

	
	@Override
	public int compareTo(Filme filme) {
		// TODO 
		return 0;
	}

}
