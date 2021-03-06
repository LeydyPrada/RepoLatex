package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import ceaser.CifradoCesar;
import monoalfabetico.CifradoMonoalfabetico;

public class Principal {

	private JFrame frmCifrado;
	private JTextField textTextoCifrar;
	private JTextField textCodigo;
	private JTextField textPalabraClave;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmCifrado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCifrado = new JFrame();
		frmCifrado.setTitle("CIFRADO");
		frmCifrado.setBounds(100, 100, 545, 493);
		frmCifrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTextoACifrar = new JLabel("Texto a Cifrar/Descifrar:");
		
		textTextoCifrar = new JTextField();
		textTextoCifrar.setColumns(10);
		
		JLayeredPane lpCeaser = new JLayeredPane();
		lpCeaser.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		
		JLayeredPane lpMonoalfabetico = new JLayeredPane();
		lpMonoalfabetico.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		
		final JRadioButton rdbtnCifrarMonoalfabetico = new JRadioButton("Cifrar Monoalfabetico");
		rdbtnCifrarMonoalfabetico.setSelected(true);
		buttonGroup_1.add(rdbtnCifrarMonoalfabetico);
		rdbtnCifrarMonoalfabetico.setBounds(18, 72, 222, 23);
		lpMonoalfabetico.add(rdbtnCifrarMonoalfabetico);
		
		final JRadioButton rdbtnDescifrarMonoalfabetico = new JRadioButton("Descifrar Monoalfabetico");
		buttonGroup_1.add(rdbtnDescifrarMonoalfabetico);
		rdbtnDescifrarMonoalfabetico.setBounds(18, 98, 222, 23);
		lpMonoalfabetico.add(rdbtnDescifrarMonoalfabetico);
		
		JLabel lblPalabraClave = new JLabel("Palabra Clave:");
		lblPalabraClave.setBounds(10, 11, 109, 14);
		lpMonoalfabetico.add(lblPalabraClave);
		
		textPalabraClave = new JTextField();
		textPalabraClave.setColumns(10);
		textPalabraClave.setBounds(10, 31, 230, 20);
		lpMonoalfabetico.add(textPalabraClave);
		
		JLayeredPane lpRespuesta = new JLayeredPane();
		lpRespuesta.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		
		JLabel lblRespuesta = new JLabel("RESPUESTA:");
		lblRespuesta.setBounds(10, 11, 106, 14);
		lpRespuesta.add(lblRespuesta);
		GroupLayout groupLayout = new GroupLayout(frmCifrado.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lpRespuesta, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lpCeaser, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(lpMonoalfabetico, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
							.addComponent(lblTextoACifrar)
							.addComponent(textTextoCifrar)))
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTextoACifrar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textTextoCifrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lpCeaser, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addComponent(lpMonoalfabetico, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lpRespuesta, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		final JLabel lblRespuestaFinal = new JLabel("");
		lblRespuestaFinal.setBounds(10, 36, 410, 77);
		lpRespuesta.add(lblRespuestaFinal);
		
		JButton btnMonoalfabetico = new JButton("MONOALFABETICO");
		btnMonoalfabetico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textTextoCifrar.getText();
				String palabra = textPalabraClave.getText();
				
				if(rdbtnCifrarMonoalfabetico.isSelected()) {
					lblRespuestaFinal.setText(CifradoMonoalfabetico.cifrarMonoalfabetico(texto, palabra));
				}
				if(rdbtnDescifrarMonoalfabetico.isSelected()) {
					lblRespuestaFinal.setText(CifradoMonoalfabetico.descifrarMonoalfabetico(texto, palabra));
				}
			}
		});
		btnMonoalfabetico.setBounds(33, 151, 175, 23);
		lpMonoalfabetico.add(btnMonoalfabetico);
		
		final JRadioButton rdbtnCifrarCeasar = new JRadioButton("Cifrar Ceasar");
		rdbtnCifrarCeasar.setSelected(true);
		buttonGroup.add(rdbtnCifrarCeasar);
		rdbtnCifrarCeasar.setBounds(18, 72, 110, 23);
		lpCeaser.add(rdbtnCifrarCeasar);
		
		final JRadioButton rdbtnDescifrarCeasar = new JRadioButton("Descifrar Ceasar");
		buttonGroup.add(rdbtnDescifrarCeasar);
		rdbtnDescifrarCeasar.setBounds(18, 98, 128, 23);
		lpCeaser.add(rdbtnDescifrarCeasar);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		lpCeaser.add(lblCdigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(10, 28, 86, 20);
		lpCeaser.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnCeasar = new JButton("CEASAR");
		btnCeasar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textTextoCifrar.getText();
				int codigo = Integer.parseInt(textCodigo.getText());
				
				if(rdbtnCifrarCeasar.isSelected()) {
					lblRespuestaFinal.setText(CifradoCesar.cifradoCesar(texto, codigo));
				}
				if(rdbtnDescifrarCeasar.isSelected()) {
					lblRespuestaFinal.setText(CifradoCesar.descifradoCesar(texto, codigo));
				}
			}
		});
		btnCeasar.setBounds(55, 150, 91, 23);
		lpCeaser.add(btnCeasar);
		frmCifrado.getContentPane().setLayout(groupLayout);
	}
}
