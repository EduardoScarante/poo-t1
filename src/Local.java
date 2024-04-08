public class Local{
	private String local; 
	private String franquia; 
	private String comentarios;


	//CONSTRUTORES
	public Local(){
		this.local = "Não Informado";
		this.franquia = "Não Informado";
		this.comentarios = "Não Informado";
	}


	public Local(String local, String franquia, String comentarios) {
		this.local = local;
		this.franquia = franquia;
		this.comentarios = comentarios;
	}


	// GETTERS
	public String getLocal() {
		return local;
	}

	public String getFranquia() {
		return franquia;
	}

	public String getComentarios() {
		return comentarios;
	}

	// SETTERS
	public void setLocal(String local) {
		this.local = local;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public String toString() {
		return local + " - " + franquia + " - " +  comentarios;
	}

}
