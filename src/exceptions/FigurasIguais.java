package exceptions;

/**
 * Exception para verificar se j� existe alguma figura igual no ArrayList antes de adicion�-la.
 * @author Mellany Linhares
 *
 */
public class FigurasIguais extends Exception{
	
	/**
	 * Construtor que ser� acionado ao lan�ar a exception.
	 */
	public FigurasIguais() {
		super("N�o � poss�vel adicionar formas iguais.");
	}

}
