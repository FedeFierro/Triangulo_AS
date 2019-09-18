package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Panel extends JPanel {

    private final JLabel lblLadoA;
    private final JLabel lblLadoB;
    private final JLabel lblLadoC;
    private final JTextField txtLadoA;
    private final JTextField txtLadoB;
    private final JTextField txtLadoC;
    private final JButton btnCalcular;
    private final int COL_LABEL = 10;
    private final int WIDTH_LABEL = 90;
    private final int HEIGHT_LABEL = 14;
    private final int HEIGHT_DATA = 20;
    private final int WIDTH_DATA = 100;
    private final int COL_DATA = 110;
    private final String NO_TRIANGULO = "No se puede formar un triangulo con los valores especificados.";
    private final String NUMERICO_POSITIVO = "Los Valores de los lados deben ser númericos y positivos.";
    private final String ISOSCELES = "Trianulo Isoseles.";
    private final String EQUILATERO = "Trianulo Equilatero.";
    private final String ESCALENO = "Trianulo Escaleno.";

    public Panel() {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        lblLadoA = new JLabel("LADO A:");
        lblLadoA.setBounds(COL_LABEL, 42, WIDTH_LABEL, HEIGHT_LABEL);
        add(lblLadoA);

        txtLadoA = new JTextField();
        txtLadoA.setBounds(COL_DATA, 39, WIDTH_DATA, HEIGHT_DATA);
        txtLadoA.setColumns(10);
        add(txtLadoA);

        lblLadoB = new JLabel("LADO B:");
        lblLadoB.setBounds(COL_LABEL, 73, WIDTH_LABEL, HEIGHT_LABEL);
        add(lblLadoB);

        txtLadoB = new JTextField();
        txtLadoB.setBounds(COL_DATA, 70, WIDTH_DATA, HEIGHT_DATA);
        txtLadoB.setColumns(10);
        add(txtLadoB);

        lblLadoC = new JLabel("LADO C:");
        lblLadoC.setBounds(COL_LABEL, 104, WIDTH_LABEL, HEIGHT_LABEL);
        add(lblLadoC);

        txtLadoC = new JTextField();
        txtLadoC.setBounds(COL_DATA, 101, WIDTH_DATA, HEIGHT_DATA);
        txtLadoC.setColumns(10);
        add(txtLadoC);

        btnCalcular = new JButton();
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        add(btnCalcular);
        btnCalcular.setText("Calcular");
        btnCalcular.setBounds(50, 150, 300, 20);
    }

    public void calcular() {

        Double a;
        Double b;
        Double c;
        try {
            a = Double.parseDouble(txtLadoA.getText()); 
            b = Double.parseDouble(txtLadoB.getText());
            c = Double.parseDouble(txtLadoC.getText());
        } catch (NumberFormatException ex) {
            setMensaje(NUMERICO_POSITIVO);
            return;
        }
        if (!sonPositivos(a, b, c)) { 
            setMensaje(NUMERICO_POSITIVO); 
            return;
        }

        if (!hayTriangulo(a, b, c)) {
            setMensaje(NO_TRIANGULO);
            return;
        }
        setMensaje(tipoTriangulo(a, b, c));

    }

    public void setMensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public Boolean sonPositivos(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0;

    }

    public Boolean hayTriangulo(double a, double b, double c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    public String tipoTriangulo(double a, double b, double c) {
        String resultado = null;
        if (a == b && b == c) {
            resultado = EQUILATERO;
        }else if ((a == b && b != c) || (a == c && b != c) || (b == c && a != c)) {
            resultado = ISOSCELES;
        }else{
        resultado = ESCALENO;
        }
        return resultado;
    }

}
