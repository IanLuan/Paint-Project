package formas;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**Classe m�e Forma (abstrata) 
 * @author Mellany Linhares
 */

public abstract class Forma implements Serializable{
	
	protected int posicaoX;
	protected int posicaoY;
	protected Color cor;
	protected boolean isPreenchido;
	
	
	/**
	 * Construtor base para a cria��o de uma forma
	 * @param px int - Posi��o inicial X da forma 
	 * @param py int - Posi��o inicial Y da forma
	 * @param cor Color - Cor da forma
	 * @param preenchido boolean - Informa se a forma est� preenchida ou n�o 
	 */
	public Forma(int px, int py, Color cor, boolean preenchido) { 
		this.setCor(cor);
		this.setPosicaoX(px);
		this.setPosicaoY(py);
		this.setPreenchido(preenchido);
	}
	
	/**
	 * M�todo para retorno do atributo boolean que informa se a forma est� preenchida ou n�o 
	 * @return boolean - forma preenchida (true) ou forma n�o preenchida (false)
	 */
	public boolean isPreenchido() {
		return isPreenchido;
	}

	/**
	 * M�todo para setar o valor do atributo preenchido
	 * @param isPreenchido boolean - informa se a forma est� preenchida ou n�o 
	 */
	public void setPreenchido(boolean isPreenchido) {
		this.isPreenchido = isPreenchido;
	}

	/**
	 * M�todo para retorno da posi��o inicial X da forma
	 * @return int - posi��o inicial X da forma
	 */
	public int getPosicaoX() {
		return posicaoX;
	}

	/**
	 * M�todo para setar o valor da posi��o inicial X
	 * @param posicaoX int - posi��o inicial X da forma
	 */
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	/**
	 * M�todo para retorno da posi��o inicial Y da forma
	 * @return int - posi��o inicial Y da forma
	 */
	public int getPosicaoY() {
		return posicaoY;
	}

	/**
	 * M�todo para setar o valor da posi��o inicial Y
	 * @param posicaoY int - posi��o inicial Y da forma
	 */
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	/**
	 * M�todo para retorno da cor da forma
	 * @return Color - cor da forma
	 */
	public Color getCor() {
		return cor;
	}

	/**
	 * M�todo para setar a cor
	 * @param cor Color - cor da forma
	 */
	public void setCor(Color cor) {
		this.cor = cor;
	}

	/**
	 * M�todo abstrato para desenhar uma forma na tela
	 * @param g Graphics - Objeto necess�rio para desenhar a forma na tela
	 */
	public abstract void desenhar(Graphics g);
	
	/**
	 * M�todo abstrato que sobrescreve o m�todo toString()
	 * @return String - uma String que representa a forma 
	 */
	public abstract String toString();
	
	/**
	 * M�todo abstrato que sobrescreve o m�todo equals() para a compara��o de duas formas
	 * @param forma Forma - um objeto do tipo Forma para ser comparado com o outro objeto que chama esse m�todo
	 * @return boolean - true se for igual, false se for diferente
	 */
	public abstract boolean equals(Forma forma); 
		
	/**
	 * M�todo para converter a cor RGB em hexadecimal para exibi��o no JList
	 * @return String - o hexadecimal correspondente � cor da forma
	 */
	public String toHexString() throws NullPointerException{ 
		String hex = Integer.toHexString(cor.getRGB() & 0xffffff);
		
		if(hex.length() < 6) {
			hex = "000000".substring(0, 6-hex.length()) + hex;
		}
		
		
		return "#"+hex;
	}
	

}
