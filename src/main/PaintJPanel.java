package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import formas.Forma;
import formas.Formas;
import formas.Retangulo;
import telas.CadastrarCirculo;
import telas.CadastrarRetangulo;
import telas.CadastrarTriangulo;

/**
 * JPanel personalizado com o paintComponent implementado e eventos do mouse para abertura das telas para cria��o de formas.
 * @author Mellany Linhares
 *
 */
public class PaintJPanel extends JPanel {
	
	private Formas f;
	private PaintJPanel p;
	private DefaultListModel modelo;
	int x = 0,y = 0;
	int selecaoBotao;
	
	/**
	 * M�todo para setar o objeto Formas, a tela de desenho e a listagem exibida no JList. 
	 * @param f Formas - Objeto Formas, que gerencia o ArrayList de formas.
	 * @param p PaintJPanel - Tela de desenho.
	 * @param modelo DefaultListModel - Listagem para exibi��o no JList de todas as formas desenhadas pelo usu�rio
	 */
	public void setInformacoes(Formas f, PaintJPanel p, DefaultListModel modelo) {
		this.f = f;
		this.p = p;
		this.modelo = modelo;
	}
	
	/**
	 * M�todo para setar o bot�o selecionado, para o panel saber qual tela abrir.
	 * @param botao int - Valor do bot�o selecionado.
	 */
	public void setBotao(int botao) {
		this.selecaoBotao = botao;
	}
	
	public PaintJPanel() { 
		setPreferredSize(new Dimension(10000,10000));
		addMouseListener(mouseListener);
    }
	
	/**
	 * MouseListener que ser� acionado toda vez que o usu�rio clicar na tela de desenho. Ser�o atribu�dos, tamb�m, as posi��es X e Y onde o usu�rio clicou,
	 * para a cria��o da forma.
	 * Ele ir� verificar o valor do selecaoBotao quando o usu�rio clicou na tela. Caso seja 1, ir� abrir a tela CadastrarRet�ngulo. Caso seja 2, ir� abrir
	 * a tela de CadastrarTri�ngulo. Caso seja 3, ir� abrir a tela de CadastrarC�rculo.
	 */
	MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(selecaoBotao == 1) { 
				CadastrarRetangulo rect = new CadastrarRetangulo(x,y,f,p,modelo);
				rect.setVisible(true);
			}
			if(selecaoBotao == 2) { 
				CadastrarTriangulo triangulo = new CadastrarTriangulo(x,y,f,p,modelo);
				triangulo.setVisible(true);
			}
			if(selecaoBotao == 3) {
				CadastrarCirculo circulo = new CadastrarCirculo(x,y,f,p,modelo);
				circulo.setVisible(true);
			}
			repaint();
        }
        
      };
	
    /**
     * O paintComponent desenha as formas contidas no array de Formas toda vez que o repaint � chamado.
     */
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		f.desenharFormas(g);
		
	}

}
