package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	private JPanel contentPane;
	private JLabel lblLadoA;
	private JLabel lblLadoB;
	private JLabel lblLadoC;
	private JTextField txtLadoA;
	private JTextField txtLadoB;
	private JTextField txtLadoC;
	private JLabel lblResultado;
	private final int COL_LABEL = 10;
	private final int WIDTH_LABEL= 90;
	private final int HEIGHT_LABEL= 14;
	private final int HEIGHT_DATA= 20;
	private final int WIDTH_DATA = 100;
	private final int COL_DATA=110;
	private JButton btnCalcular;
	private final String NO_TRIANGULO = "No se puede formar un triangulo con los valores especificados.";
	private final String NUMERICO_POSITIVO = "Los Valores de los lados deben ser númericos y positivos.";
	private final String ISOCELES = "Trianulo Isoseles.";
	private final String EQUILATERO = "Trianulo Equilatero.";
	private final String ESCALENO = "Trianulo Escaleno.";
	
			
	
	public Frame() {
		setTitle("Triangulo.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 400, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		lblLadoA = new JLabel("LADO A:");
		lblLadoA.setBounds(COL_LABEL, 42, WIDTH_LABEL, HEIGHT_LABEL);
		contentPane.add(lblLadoA);
		
		txtLadoA = new JTextField();
		txtLadoA.setBounds(COL_DATA, 39, WIDTH_DATA, HEIGHT_DATA);
		txtLadoA.setColumns(10);
		contentPane.add(txtLadoA);
		
		lblLadoB = new JLabel("LADO B:");
		lblLadoB.setBounds(COL_LABEL, 73, WIDTH_LABEL, HEIGHT_LABEL);
		contentPane.add(lblLadoB);
		
		txtLadoB = new JTextField();
		txtLadoB.setBounds(COL_DATA, 70, WIDTH_DATA, HEIGHT_DATA);
		txtLadoB.setColumns(10);
		contentPane.add(txtLadoB);
		
		lblLadoC = new JLabel("LADO C:");
		lblLadoC.setBounds(COL_LABEL, 104, WIDTH_LABEL, HEIGHT_LABEL);
		contentPane.add(lblLadoC);
		
		txtLadoC = new JTextField();
		txtLadoC.setBounds(COL_DATA, 101, WIDTH_DATA, HEIGHT_DATA);
		txtLadoC.setColumns(10);
		contentPane.add(txtLadoC);
		
		lblResultado = new JLabel();
		lblResultado.setBounds(COL_LABEL, 132, 320, HEIGHT_LABEL);
		contentPane.add(lblResultado);
		
		btnCalcular = new JButton();
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(50,260,300,20);
		contentPane.add(btnCalcular);
		
		setContentPane(contentPane);

	}
	
	private void calcular() {
		lblResultado.setText("");
		Double a = new Double(0) ;
		Double b = new Double(0); 
		Double c = new Double(0);
		if(!(esNUmericoPositivo(txtLadoA.getText()) && 
				esNUmericoPositivo(txtLadoB.getText())&&
				esNUmericoPositivo(txtLadoC.getText()))) {
			return;
		}
		a = Double.parseDouble(txtLadoA.getText());
		b = Double.parseDouble(txtLadoB.getText());
		c = Double.parseDouble(txtLadoC.getText());
		if(!(a+b > c && a+c > b && b+c>a )) {
			setMensaje(NO_TRIANGULO);
			return;
		}
		if(a.equals(b) && b.equals(c) ) {
			setMensaje(ISOCELES);
			return;
		}
		if((a.equals(b) && ! b.equals(c)) || (a.equals(c) && !b.equals(c)) ) {
			setMensaje(EQUILATERO);
			return;
		}
		setMensaje(ESCALENO);
		return;
	}
	
	private void setMensaje(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private Boolean esNUmericoPositivo(String valor) {
		try {
			Double lado= new Double(0);
			lado = Double.parseDouble(valor);
			if(lado > 0){
				return true;
			}
			setMensaje(NUMERICO_POSITIVO);
			return false;
			
		}catch(Exception e) {
			setMensaje(NUMERICO_POSITIVO);
			return false;
		}
		
	}
}
	
