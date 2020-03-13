
package exceptions;

/**
 * Exception para verificar os valores inv�lidos nas telas de desenho e edi��o.
 * @author Mellany Linhares
 *
 */
public class ValoresInvalidos extends Exception{
	
	private int base = 1, altura = 1, raio = 1, x = 1, y = 1; 
	

	/**
	 * Construtor usado para verificar valores inv�lidos na tela de desenho de tri�ngulos e ret�ngulos.
	 * @param base int - Base da forma.
	 * @param altura int - Altura da forma.
	 */
	public ValoresInvalidos(int base,int altura) { 
		super();		
		this.base = base;
		this.altura = altura;
	}
	
	/**
	 * Construtor usado para verificar valores inv�lidos na tela de edi��o de tri�ngulos e ret�ngulos.
	 * @param x int - Posi��o X da forma.
	 * @param y int - Posi��o Y da forma.
	 * @param base int - Base da forma.
	 * @param altura int - Altura da forma.
	 */
	public ValoresInvalidos(int x, int y, int base,int altura) { 
		super();		
		this.x = x;
		this.y = y;
		this.base = base;
		this.altura = altura;
	}
	
	/**
	 * Construtor usado para verificar valores inv�lidos na tela de desenho de c�rculos.
	 * @param raio int - Raio da forma.
	 */
	public ValoresInvalidos(int raio) {
		super();		
		this.raio = raio;
	}
	
	/**
	 * Construtor usado para verificar valores inv�lidos na tela de edi��o de c�rculos.
	 * @param x int - Posi��o X da forma.
	 * @param y int - Posi��o Y da forma.
	 * @param raio int - Raio da forma.
	 */
	public ValoresInvalidos(int x, int y, int raio) { 
		super();		
		this.x = x;
		this.y = y;
		this.raio = raio;
	}
	
	/**
	 * M�todo que sobrescreve o m�todo getMessage para retornar uma mensagem personalizada para o usu�rio, informando-o que campos possuem valores inv�lidos.
	 * @return String - Mensagem de erro que ser� exibida ao usu�rio.
	 */
	public String getMessage() { 
		
		StringBuffer message = new StringBuffer();
		
		message.append("Os seguintes campos possuem valores inv�lidos (iguais ou menores que 0):");
		
		if(x < 0) {
			message.append(" - Posi��o X");
		}
		if(y < 0) {
			message.append(" - Posi��o Y");
		}
		if(base <= 0) {
			message.append(" - Base");
		}
		
		if(altura <= 0) {
			message.append(" - Altura");
		}
		
		if(raio <= 0) {
			message.append(" - Raio");
		}
		
		message.append(". Informe valores v�lidos antes de continuar.");
		
		return message.toString();
		
	}

}
