package exceptions;

/**
 * Exception para verificar se a tela est� vazia quando o usu�rio selecionar limpar a tela.
 * @author Mellany Linhares
 *
 */

public class TelaVazia extends Exception{
	
	/**
	 * Construtor para o lan�amento da exception.
	 * @param message String - Mensagem de erro que ser� mostrada ao usu�rio.
	 */
	public TelaVazia(String message) {
		super(message);
	}

}
