package br.com.calebematos.desafio.nasa.model;

/**
 *
 * @author Lucas Calebe
 * 
 */
public class MensagemErro {

	private String codigo;
	private String erro;

	public MensagemErro(String erro) {
		this.codigo = erro;
	}

	public MensagemErro(String erro, String mensagem) {
		this.codigo = erro;
		this.erro = mensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	@Override
	public String toString() {
		return codigo + " " + erro;
	}
}
