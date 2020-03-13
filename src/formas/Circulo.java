package formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.CampoVazio;
import exceptions.FigurasIguais;
import exceptions.ValoresInvalidos;

/**
 * Classe C�rculo, que extende a classe Forma, para a cria��o de objetos do tipo C�rculo
 * @author Mellany Linhares
 */

public class Circulo extends Forma{
	
	private int raio;
	
	/**
	 * Construtor para a cria��o de um c�rculo
	 * @param px int - Posi��o X do centro do c�rculo
	 * @param py int - Posi��o Y do centro do c�rculo
	 * @param cor Color - Cor do c�rculo
	 * @param preenchido boolean - Informa se o c�rculo est� preenchido ou n�o 
	 * @param raio String - Raio do c�rculo
	 * @throws CampoVazio - Verifica se o raio ou a cor est�o vazios
	 * @throws ValoresInvalidos - Verifica se o raio possui valor menor ou igual a 0
	 * @throws NumberFormatException - Verifica se h� algum valor n�o num�rico no raio
	 */
	public Circulo(int px, int py,Color cor,boolean preenchido, String raio) { 
		super(px,py,cor,preenchido);
			try {
			
			if((raio.equals(""))||cor == null) {
				throw new CampoVazio(raio,cor);
			}
			
			if((Integer.parseInt(raio) <= 0)) { 
				throw new ValoresInvalidos(Integer.parseInt(raio));
			}
			
			this.setRaio(Integer.parseInt(raio)); 
		}
		catch(CampoVazio e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		catch(ValoresInvalidos e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null, "Os campos de texto para desenho s� aceitam n�meros. Repita a opera��o.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M�todo para retorno do raio do c�rculo
	 * @return int - raio do c�rculo
	 */
	public int getRaio() {
		return raio;
	}

	/**
	 * M�todo para setar o valor do raio do c�rculo
	 * @param raio int - raio do c�rculo
	 */
	public void setRaio(int raio) {
		this.raio = raio;
	}

	/**
	 * M�todo para desenhar um c�rculo na tela. Caso ele esteja preenchido, usa o m�todo fillOval para desenhar. Caso contr�rio,
	 * utiliza-se o drawOval.
	 * @param g Graphics - Objeto necess�rio para desenhar o c�rculo na tela
	 */
	@Override
	public void desenhar(Graphics g) { 
		g.setColor(cor);
		if(isPreenchido) {
			g.fillOval(posicaoX-raio, posicaoY-raio, raio*2, raio*2);		
		}
		else {
			g.drawOval(posicaoX-raio, posicaoY-raio, raio*2, raio*2);		
		}
	}
	
	/**
	 * M�todo que sobrescreve o m�todo equals() para a compara��o de um c�rculo e uma forma. 
	 * O m�todo retorna true caso todas as informa��es sejam iguais e a forma passada como par�metro seja um c�rculo. Caso contr�rio, retorna false.
	 * @param forma Forma - um objeto do tipo Forma para ser comparado com o c�rculo que chama esse m�todo
	 * @return boolean - true se for igual, false se for diferente
	 */
	public boolean equals(Forma forma) { 

		if(forma instanceof Circulo) {

			Circulo circle = (Circulo) forma;
			
			if((posicaoX == circle.getPosicaoX())&&(posicaoY == circle.getPosicaoY())&&(cor.equals(circle.getCor()))&&(isPreenchido == circle.isPreenchido())&&(raio == circle.getRaio())) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}		
	}
	
	/**
	 * M�todo que sobrescreve o m�todo toString() para a exibi��o das informa��es do c�rculo no JList. A cor � exibida
	 * em hexadecimal.
	 * @return s String - uma String que representa, em forma de texto, o c�rculo
	 */
	public String toString() { 
		
		StringBuffer s = new StringBuffer();
		
		s.append("<html>C�rculo - ");
		s.append("<br>Posi��o X: "+posicaoX+"px - ");
		s.append("Posi��o Y: "+posicaoY+"px -<br>");
		if(isPreenchido) {
			s.append("Preenchido: Sim - ");
		}
		else {
			s.append("Preenchido: N�o - ");
		}
		s.append("Cor: "+toHexString()+" -<br>");
		s.append("Raio: "+raio+"px.</html>");
		
		return s.toString();
	}

	
	/**
	 * M�todo para a edi��o do c�rculo. 
	 * Utiliza-se um ArrayList auxiliar para verificar se a forma editada � igual a alguma j� existente no ArrayList de formas.
	 * Por isso, retira-se a forma selecionada do ArrayList auxiliar
	 * @param x int - nova posi��o X do centro do c�rculo
	 * @param y int - nova posi��o Y do centro do c�rculo
	 * @param cor Color - nova cor do c�rculo
	 * @param preenchido boolean - novo valor booleano para verificar se o c�rculo � preenchido ou n�o
	 * @param raio String - novo raio do c�rculo
	 * @param formas Formas - objeto Formas, que gerencia todas as formas contidas na tela
	 * @param formaSelecionada int - posi��o da forma que ser� editada
	 * @throws CampoVazio - Verifica se o raio, a posi��o X/Y ou a cor est�o vazios
	 * @throws ValoresInvalidos - Verifica se o raio tem valores menores ou iguais a 0 ou a posi��o X/Y tem valores negativos
	 * @throws FigurasIguais - Verifica se j� existe uma figura igual a essa no array de figuras
	 * @throws NumberFormatException - Verifica se h� algum valor n�o num�rico no raio ou na posi��o X/Y
	 * @return boolean para verificar se a edi��o foi bem sucedida ou n�o
	 */
	public boolean editarCirculo(String x, String y, Color cor, boolean preenchido, String raio, Formas formas, int formaSelecionada) {
		try {
			
			ArrayList<Forma> f = new ArrayList();
			Circulo circle;
			
			for(Forma forma: formas.getFormas()) {
				f.add(forma);
			}
			
			f.remove(formaSelecionada); 
			
			if((raio.equals(""))||(x.equals(""))||(y.equals(""))||(cor == null)) { 
				throw new CampoVazio(x,y,raio,cor);
			}
			
			if((Integer.parseInt(raio) <= 0)||(Integer.parseInt(x) < 0)||(Integer.parseInt(y) < 0)) { 
				throw new ValoresInvalidos(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(raio));
			}
			
			for(Forma forma : f) {
				if(forma instanceof Circulo) {
					circle = (Circulo) forma;
					if((circle.getPosicaoX() == Integer.parseInt(x))&&(circle.getPosicaoY() == Integer.parseInt(y))&&(circle.getCor().equals(cor))&&(circle.isPreenchido() == preenchido)&&(circle.getRaio() == Integer.parseInt(raio))) { 
						throw new FigurasIguais();
					}
				}
				
			}
			
			this.setPosicaoX(Integer.parseInt(x));
			this.setPosicaoY(Integer.parseInt(y));
			this.setCor(cor);
			this.setPreenchido(preenchido);
			this.setRaio(Integer.parseInt(raio));
			
			return true;
		}
		catch(CampoVazio e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(ValoresInvalidos e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null, "Os campos de texto para desenho s� aceitam n�meros. Repita a opera��o.", "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(FigurasIguais e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}


}
