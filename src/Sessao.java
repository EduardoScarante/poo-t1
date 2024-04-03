import java.time.LocalDateTime;

public class Sessao{
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
		return "******* Filme ***** \n\n" +
				"Nome: " + filme.getFilme() +
				"\nFavorito: " + "IMPLEMENTAR" +
				"\nData: " + data_hora +
				"\nPreço: " + preco +
				"\nLocal: " + local + 
				"\nComentário da Sessão: " + comentario + 
				"\nComentário do Filme: " + filme.getComentario();
	}


	/* Nome: Capitã Marvel
	Nota: 4
	Favorito: não
	Data: 17/mar/2022, dom – 21h30
	Preço: R$ 15,00
	Local: Pátio Batel
	Comentário do filme: Superou a expectativa, apresentou bem a personagem e seus poderes, o que servirá para 
   encaixar a personagem no cânone do UCM.
	Comentário da sessão: Apesar do horário tardio o cinema estava lotado, antes do filme fomos ao BK lanchar. */
}
