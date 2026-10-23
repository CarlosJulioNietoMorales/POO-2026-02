package notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Ventana del ejercicio 8.2: solicita cinco notas y muestra promedio,
 * desviacion estandar, mayor y menor.
 * Parte propuesta: alertas cuando el dato no es numerico y cuando falta una nota.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private static final int CANTIDAD_NOTAS = 5;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 5.0;

    private Container contenedor;
    private JLabel[] etiquetasNota;
    private JTextField[] camposNota;
    private JLabel promedio;
    private JLabel desviacion;
    private JLabel mayor;
    private JLabel menor;
    private JButton calcular;
    private JButton limpiar;
    private DecimalFormat formato;

    public VentanaPrincipal() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator(',');
        formato = new DecimalFormat("0.00", simbolos);
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetasNota = new JLabel[CANTIDAD_NOTAS];
        camposNota = new JTextField[CANTIDAD_NOTAS];
        for (int i = 0; i < CANTIDAD_NOTAS; i++) {
            etiquetasNota[i] = new JLabel("Nota " + (i + 1) + ":");
            etiquetasNota[i].setBounds(20, 20 + 30 * i, 70, 25);
            camposNota[i] = new JTextField();
            camposNota[i].setBounds(100, 20 + 30 * i, 150, 25);
            contenedor.add(etiquetasNota[i]);
            contenedor.add(camposNota[i]);
        }

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 180, 110, 28);
        calcular.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(140, 180, 110, 28);
        limpiar.addActionListener(this);
        contenedor.add(calcular);
        contenedor.add(limpiar);

        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 225, 230, 25);
        desviacion = new JLabel("Desviación estándar = ");
        desviacion.setBounds(20, 255, 230, 25);
        mayor = new JLabel("Valor mayor = ");
        mayor.setBounds(20, 285, 230, 25);
        menor = new JLabel("Valor menor = ");
        menor.setBounds(20, 315, 230, 25);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);

        setTitle("Notas");
        setSize(290, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            calcularMetricas();
        } else if (evento.getSource() == limpiar) {
            limpiarVentana();
        }
    }

    private void calcularMetricas() {
        double[] valores = new double[CANTIDAD_NOTAS];
        for (int i = 0; i < CANTIDAD_NOTAS; i++) {
            String texto = camposNota[i].getText().trim();

            // Propuesto 2: las cinco notas son obligatorias
            if (texto.isEmpty()) {
                mostrarAlerta("La nota " + (i + 1) + " no ha sido ingresada.\n"
                        + "Es obligatorio ingresar las cinco notas.", camposNota[i]);
                return;
            }

            // Propuesto 1: solo se aceptan datos numericos (se admite coma o punto decimal)
            double valor;
            try {
                valor = Double.parseDouble(texto.replace(',', '.'));
            } catch (NumberFormatException ex) {
                mostrarAlerta("La nota " + (i + 1) + " no es numérica: \"" + texto + "\".\n"
                        + "Ingrese un número, por ejemplo 3.5", camposNota[i]);
                return;
            }

            // Validacion adicional: las notas estan entre 0 y 5 (tambien descarta NaN)
            if (!(valor >= NOTA_MINIMA && valor <= NOTA_MAXIMA)) {
                mostrarAlerta("La nota " + (i + 1) + " debe estar entre "
                        + NOTA_MINIMA + " y " + NOTA_MAXIMA + ".", camposNota[i]);
                return;
            }
            valores[i] = valor;
        }

        Notas notas = new Notas(valores);
        promedio.setText("Promedio = " + formato.format(notas.calcularPromedio()));
        desviacion.setText("Desviación estándar = " + formato.format(notas.calcularDesviacion()));
        mayor.setText("Valor mayor = " + formato.format(notas.calcularMayor()));
        menor.setText("Valor menor = " + formato.format(notas.calcularMenor()));
    }

    private void limpiarVentana() {
        for (JTextField campo : camposNota) {
            campo.setText("");
        }
        promedio.setText("Promedio = ");
        desviacion.setText("Desviación estándar = ");
        mayor.setText("Valor mayor = ");
        menor.setText("Valor menor = ");
        camposNota[0].requestFocus();
    }

    private void mostrarAlerta(String mensaje, JTextField campo) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
        campo.selectAll();
    }
}
