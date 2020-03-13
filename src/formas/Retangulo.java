package formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.CampoVazio;
import exceptions.FigurasIguais;
import exceptions.ValoresInvalidos;

/**
 * Classe Ret�ngulo, que extende a classe Forma, para a cria��o de objetos do tipo Ret�ngulo
 * @author Mellany Linhares
 */
public class Retangulo extends Forma{
	
	private int base;
	private int altura;
	
	/**
	 * Construtor para a cria��o de um ret�ngulo
	 * @param px int - Posi��o X inicial do ret�ngulo
	 * @param py int - Posi��o Y inicial do ret�ngulo
	 * @param cor Color - Cor do ret�ngulo
	 * @param preenchido boolean - Informa se o ret�ngulo est� preenchido ou n�o 
	 * @param base String - Base do ret�ngulo
	 * @param altura String - Altura do ret�ngulo
	 * @throws CampoVazio - Verifica se a base, a altura ou a cor est�o vazios
	 * @throws ValoresInvalidos - Verifica se a base ou altura possuem valores menores ou iguais a 0
	 * @throws NumberFormatException - Verifica se h� algum valor n�o num�rico na base ou na altura
	 */
	public Retangulo(int px, int py,Color cor,boolean preenchido, String base, String altura) { 
		super(px,py,cor,preenchido);
		try {
			
			if((base.equals(""))||(altura.equals(""))||(cor == null)) { 
				throw new CampoVazio(base,altura,cor);
			}
			
			if((Integer.parseInt(base) <= 0)||(Integer.parseInt(altura) <=0)) { 
				throw new ValoresInvalidos(Integer.parseInt(base),Integer.parseInt(altura));
			}
			
			this.setBase(Integer.parseInt(base)); 
			this.setAltura(Integer.parseInt(altura));
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
	 * M�todo para retorno da base do ret�ngulo
	 * @return int - base do ret�ngulo
	 */
	public int getBase() {
		return base;
	}

	/**
	 * M�todo para setar o valor da base do ret�ngulo
	 * @param base int - base do ret�ngulo
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * M�todo para retorno da altura do ret�ngulo
	 * @return int - altura do ret�ngulo
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * M�todo para setar o valor da altura do ret�ngulo
	 * @param altura int - altura do ret�ngulo
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * M�todo para desenhar um ret�ngulo na tela. Caso ele esteja preenchido, usa o m�todo fillRect para desenhar. Caso contr�rio,
	 * utiliza-se o drawRect.
	 * @param g Graphics - Objeto necess�rio para desenhar o ret�ngulo na tela
	 */

	@Override
	public void desenhar(Graphics g) { 
		g.setColor(cor);
		if(isPreenchido) {
			g.fillRect(posicaoX, posicaoY, base, altura);		
		}
		else {
			g.drawRect(posicaoX, posicaoY, base, altura);
		}
	}
	
	/**
	 * M�todo que sobrescreve o m�todo toString() para a exibi��o das informa��es do ret�ngulo no JList. A cor � exibida
	 * em hexadecimal.
	 * @return s String - uma String que representa, em forma de texto, o ret�ngulo
	 */
	public String toString() { 
		
		StringBuffer s = new StringBuffer();
		
		s.append("<html>Ret�ngulo - ");
		s.append("<br>Posi��o X: "+posicaoX+"px - ");
		s.append("Posi��o Y: "+posicaoY+"px -<br>");
		if(isPreenchido) {
			s.append("Preenchido: Sim - ");
		}
		else {
			s.append("Preenchido: N�o - ");
		}
		s.append("Cor: "+toHexString()+" - ");
		s.append("<br>Base: "+base+"px - ");
		s.append("Altura: "+altura+"px.</html>");
		
		return s.toString();
	}
	
	/**
	 * M�todo que sobrescreve o m�todo equals() para a compara��o de um ret�ngulo e uma forma. 
	 * O m�todo retorna true caso todas as informa��es sejam iguais e a forma passada como par�metro seja um ret�ngulo. Caso contr�rio, retorna false.
	 * @param forma Forma - um objeto do tipo Forma para ser comparado com o ret�ngulo que chama esse m�todo
	 * @return boolean - true se for igual, false se for diferente
	 */
	public boolean equals(Forma forma) { 
		if(forma instanceof Retangulo) {
			
			Retangulo rect = (Retangulo) forma;
			
			if((posicaoX == rect.getPosicaoX())&&(posicaoY == rect.getPosicaoY())&&(cor.equals(rect.getCor()))&&(isPreenchido == rect.isPreenchido())&&(base == rect.getBase())&&(altura == rect.getAltura())) {
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
	 * M�todo para a edi��o do ret�ngulo. 
	 * Utiliza-se um ArrayList auxiliar para verificar se a forma editada � igual a alguma j� existente no ArrayList de formas.
	 * Por isso, retira-se a forma selecionada do ArrayList auxiliar
	 * @param x int - nova posi��o X inicial do ret�ngulo
	 * @param y int - nova posi��o Y inicial do ret�ngulo
	 * @param cor Color - nova cor do ret�ngulo
	 * @param preenchido boolean - novo valor booleano para verificar se o ret�ngulo � preenchido ou n�o
	 * @param base String - nova base do ret�ngulo
	 * @param altura String - nova altura do ret�ngulo
	 * @param formas Formas - objeto Formas, que gerencia todas as formas contidas na tela
	 * @param formaSelecionada int - posi��o da forma que ser� editada
	 * @throws CampoVazio - Verifica se a base, a altura, a posi��o X/Y ou a cor est�o vazios
	 * @throws ValoresInvalidos - Verifica se a base ou a altura tem valores menores ou iguais a 0 ou a posi��o X/Y tem valores negativos
	 * @throws FigurasIguais - Verifica se j� existe uma figura igual a essa no array de figuras
	 * @throws NumberFormatException - Verifica se h� algum valor n�o num�rico na base, na altura ou na posi��o X/Y
	 * @return boolean para verificar se a edi��o foi bem sucedida ou n�o
	 */
	public boolean editarRetangulo(String x, String y, Color cor, boolean preenchido, String base, String altura, Formas formas, int formaSelecionada) {
		try {
			
			ArrayList<Forma> f = new ArrayList();
			Retangulo rect;
			
			for(Forma forma: formas.getFormas()) {
				f.add(forma);
			}
			
			f.remove(formaSelecionada); 
			
			if((altura.equals(""))||(base.equals(""))||(x.equals(""))||(y.equals(""))||(cor == null)) { 
				throw new CampoVazio(x,y,base,altura,cor);
			}
			
			if((Integer.parseInt(altura) <= 0)||(Integer.parseInt(base) <= 0)||(Integer.parseInt(x) < 0)||(Integer.parseInt(y) < 0)) {
				throw new ValoresInvalidos(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(base),(Integer.parseInt(altura)));
			}
			
			
			for(Forma forma : f) {
				if(forma instanceof Retangulo) {
					rect = (Retangulo) forma;
					if((rect.getPosicaoX() == Integer.parseInt(x))&&(rect.getPosicaoY() == Integer.parseInt(y))&&(rect.getCor().equals(cor))&&(rect.isPreenchido() == preenchido)&&(rect.getBase() == Integer.parseInt(base))&&(rect.getAltura() == Integer.parseInt(altura))) {  
						throw new FigurasIguais();
					}
				}
				
			}
			
			
			this.setPosicaoX(Integer.parseInt(x));
			this.setPosicaoY(Integer.parseInt(y));
			this.setCor(cor);
			this.setPreenchido(preenchido);
			this.setBase(Integer.parseInt(base));
			this.setAltura(Integer.parseInt(altura));

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
