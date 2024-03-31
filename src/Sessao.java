import java.time.LocalDateTime;

public class Sessao {
	private Filme filme;
	private Local local;
	private float preco;
	private String comentario;
	private String data_hora;

	public Sessao(Filme filme, Local local, float preco, String comentario, String data_hora) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.comentario = comentario;
		this.data_hora = data_hora;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Sessao{" +
				"filme=" + filme +
				", local=" + local +
				", preco=" + preco +
				", comentario='" + comentario + '\'' +
				", data_hora=" + data_hora +
				'}';
	}
}
