package exceptions;

import java.awt.Color;

/**
 * Exception para verificar os campos vazios nas telas de desenho e edi��o.
 * @author Mellany Linhares
 *
 */

public class CampoVazio extends Exception{
	
	private String base = "1", altura = "1", raio = "1", x = "1", y = "1"; 
	private Color cor;
	
	/**
	 * Construtor usado para verificar campos vazios na tela de desenho de tri�ngulos e ret�ngulos.
	 * @param base String - Base da forma.
	 * @param altura - Altura da forma.
	 * @param cor - Cor da forma.
	 */
	public CampoVazio(String base,String altura, Color cor) { 
		super();		
		this.base = base;
		this.altura = altura;
		this.cor = cor;
	}
	
	/**
	 * Construtor usado para verificar campos vazios na tela de edi��o de tri�ngulos e ret�ngulos.
	 * @param x String - Posi��o X da forma.
	 * @param y String - Posi��o Y da forma.
	 * @param base String - Base da forma.
	 * @param altura - Altura da forma.
	 * @param cor - Cor da forma.
	 */
	public CampoVazio(String x, String y, String base,String altura, Color cor) {
		super();		
		this.x = x;
		this.y = y;
		this.base = base;
		this.altura = altura;
		this.cor = cor;
	}
	
	/**
	 * Construtor usado para verificar campos vazios na tela de edi��o de c�rculos.
	 * @param x String - Posi��o X da forma.
	 * @param y String - Posi��o Y da forma.
	 * @param raio String - Raio da forma.
	 * @param cor - Cor da forma.
	 */
	public CampoVazio(String x, String y, String raio, Color cor) { 
		super();		
		this.x = x;
		this.y = y;
		this.raio = raio;
		this.cor = cor;
	}
	
	/**
	 * Construtor usado para verificar campos vazios na tela de desenho de c�rculos.
	 * @param raio String - Raio da forma.
	 * @param cor - Cor da forma.
	 */
	public CampoVazio(String raio, Color cor) { 
		super();		
		this.raio = raio;
		this.cor = cor;
	}
	
	/**
	 * M�todo que sobrescreve o m�todo getMessage para retornar uma mensagem personalizada para o usu�rio, informando-o que campos est�o vazios.
	 * @return String - Mensagem de erro que ser� exibida ao usu�rio.
	 */
	public String getMessage() { 
		
		StringBuffer message = new StringBuffer();
		
		message.append("Os seguintes campos est�o vazios:");
		
		
		if(x.equals("")) {
			message.append(" - Posi��o X");
		}
		if(y.equals("")) {
			message.append(" - Posi��o Y");
		}
		if(base.equals("")) {
			message.append(" - Base");
		}
		
		if(altura.equals("")) {
			message.append(" - Altura");
		}
		
		if(raio.equals("")) {
			message.append(" - Raio");
		}
		
		if(cor == null) {
			message.append(" - Cor");
		}
		
		message.append(". Preencha-os antes de continuar.");
		
		return message.toString();
		
	}

}
