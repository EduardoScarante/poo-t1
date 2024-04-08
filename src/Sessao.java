import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao implements Comparable<Sessao>{
	private Filme filme;
	private Local local;
	private float preco;
	private String comentario;
	private LocalDateTime data_hora;

	//CONSTRUTOR
	public Sessao(Filme filme, Local local, float preco, String comentario, LocalDateTime data_hora) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.comentario = comentario;
		this.data_hora = data_hora;
	}

	// GETTERS

	public Filme getFilme() {
		return filme;
	}

	public Local getLocal() {
		return local;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public String getComentario() {
		return comentario;
	}
		
	public LocalDateTime getData_hora() {
		return data_hora;
	}

	//SETTERS
	public void setLocal(Local local) {
		this.local = local;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	@Override
	public java.lang.String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE - HH'h'mm");
		return filme.getFilme() + " (" + data_hora.format(formatter) + ") - " + local.getLocal() + " - " + local.getFranquia();
	}
	
	@Override
    public int compareTo(Sessao sessao) {
        return this.filme.getFilme().compareToIgnoreCase(sessao.getFilme().getFilme());
    }
}
