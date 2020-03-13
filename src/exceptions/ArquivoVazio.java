
package exceptions;

/**
 * Exception para verificar se o ArrayList est� vazio antes de salvar o arquivo.
 * @author Mellany Linhares
 *
 */
public class ArquivoVazio extends Exception{
	
	/**
	 * Construtor para o lan�amento da exception.
	 * @param message String - Mensagem de erro que ser� mostrada ao usu�rio.
	 */
	public ArquivoVazio(String message) {
		super(message);
	}

}
