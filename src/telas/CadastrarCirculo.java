package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import formas.Circulo;
import formas.Forma;
import formas.Formas;
import formas.Retangulo;
import main.PaintJPanel;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * JDialog que ser� usado para o usu�rio selecionar as informa��es necess�rias para desenhar um c�rculo na tela. 
 * @author Mellany Linhares
 *
 */
public class CadastrarCirculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRaio;
	private Color corSelecionada;
	
	/**
	 * Construtor para a cria��o do JDialog.
	 * @param x int - Valor da posi��o X que o usu�rio clicou na tela.
	 * @param y int - Valor da posi��o Y que o usu�rio clicou na tela.
	 * @param formas Formas - Objeto que gerencia o ArrayList de formas.
	 * @param panel PaintJPanel - Tela de desenho.
	 * @param modelo DefaultListModel - Listagem para exibi��o no JList de todas as formas desenhadas pelo usu�rio
	 */
	
	public CadastrarCirculo(int x, int y, Formas formas, PaintJPanel panel,DefaultListModel modelo) {
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle("Desenhar c�rculo");
		setBounds(100, 100, 442, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.decode("#cce6ff"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(12, 24, 24, 0);
			contentPanel.add(label);
		}
		
		JLabel lblNewLabel = new JLabel("Raio (px):");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 13, 75, 18);
		contentPanel.add(lblNewLabel);
		
		txtRaio = new JTextField();
		txtRaio.setBounds(159, 13, 150, 22);
		contentPanel.add(txtRaio);
		txtRaio.setColumns(10);
		{
			JLabel lblCor = new JLabel("Cor:");
			lblCor.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCor.setBounds(12, 41, 75, 18);
			contentPanel.add(lblCor);
		}
		
		
			JLabel mostrarCor = new JLabel("");
			mostrarCor.setBounds(305, 41, 34, 24);
			contentPanel.add(mostrarCor);
		
		/**
		 * Quando o usu�rio selecionar o bot�o de selecionar cor, ser� aberto um JColorChooser para a sele��o da cor da forma. 
		 * Ap�s a sele��o, a cor selecionada ser� setada em um label para o usu�rio poder saber que cor foi escolhida.
		 */
		JButton btnSelecionarCor = new JButton("Selecionar cor");
		btnSelecionarCor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				corSelecionada = JColorChooser.showDialog( CadastrarCirculo.this,"Selecione uma cor", corSelecionada );
				mostrarCor.setOpaque(true);
				mostrarCor.setBackground(corSelecionada);
			}
		});
		
		btnSelecionarCor.setBounds(159, 41, 134, 25);
		btnSelecionarCor.setBackground(Color.white);
		contentPanel.add(btnSelecionarCor);
		
		JLabel lblSelecioneOTipo = new JLabel("Tipo de \r\nc\u00EDrculo:");
		lblSelecioneOTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelecioneOTipo.setBounds(12, 70, 108, 27);
		contentPanel.add(lblSelecioneOTipo);
		
		JComboBox cbPreenchido = new JComboBox();
		cbPreenchido.setOpaque(true);
		cbPreenchido.setBackground(Color.WHITE);
		cbPreenchido.setModel(new DefaultComboBoxModel(new String[] {"N�o Preenchido", "Preenchido"}));
		cbPreenchido.setBounds(159, 70, 150, 22);
		contentPanel.add(cbPreenchido);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.decode("#cce6ff"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * Quando o usu�rio clicar no bot�o de desenhar, a forma ser� criada. Para isso, ser�o recolhidas as informa��es dadas pelo usu�rio no JDialog.
				 * Foi utilizada uma vari�vel de controle para saber se a forma foi criada ou n�o. Caso ela n�o tenha sido criada, a vari�vel recebe false.
				 * Caso ela tenha sido criada, a forma � adicionada no ArrayList de formas e, caso ela tenha sido adicionada no array, a tela de desenho � repintada e o JDialog � fechado.
				 */
				JButton btnDesenhar = new JButton("Desenhar");
				btnDesenhar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						boolean preenchido = true;
						boolean contrl = true;
						
						
						if(cbPreenchido.getSelectedItem().equals("N�o Preenchido")) {
							preenchido = false;
						}
						
						Circulo circle = new Circulo(x,y,corSelecionada,preenchido,txtRaio.getText()); 
						
						
						if(circle.getRaio() == 0) {
							contrl = false;
						}
						
						if(contrl == true) { 
							if(formas.addFormas(circle,modelo)) { 
                            	panel.repaint();
                                dispose();
                            }
						}
					}
				});
				btnDesenhar.setOpaque(true);
				btnDesenhar.setBackground(Color.WHITE);
				btnDesenhar.setFont(new Font("Arial", Font.PLAIN, 14));
				buttonPane.add(btnDesenhar);
				getRootPane().setDefaultButton(btnDesenhar);
			}
			{
				/**
				 * Caso o usu�rio aperte no bot�o de cancelar, a tela � fechada.
				 */
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) { 
						
						dispose();
						
					}
				});
				btnCancelar.setOpaque(true);
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
	}
}
