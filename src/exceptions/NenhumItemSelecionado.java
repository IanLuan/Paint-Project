package exceptions;

/**
 * Exception usada para verificar se o usu�rio selecionou alguma figura antes de apertar nos bot�es de excluir/editar.
 * @author Mellany Linhares
 *
 */
public class NenhumItemSelecionado extends Exception{
	
	/**
	 * Construtor para o lan�amento da exception.
	 * @param message String - Mensagem de erro que ser� mostrada ao usu�rio.
	 */
	public NenhumItemSelecionado(String message) {
		super(message);
	}

}
