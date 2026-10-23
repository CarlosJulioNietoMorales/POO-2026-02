package figuras;

import java.awt.Container;
import java.awt.Dimension;
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
 * Ventana generica de una figura: pide las dimensiones, valida los datos y muestra
 * volumen y superficie. Cada figura solo define sus etiquetas y como crear el objeto.
 */
public abstract class VentanaFigura extends JFrame implements ActionListener {

    private final String[] etiquetas;
    private final JTextField[] campos;
    private final JButton calcular;
    private final JLabel volumen;
    private final JLabel superficie;
    private final DecimalFormat formato;

    protected VentanaFigura(String titulo, String[] etiquetas, String tipoImagen) {
        super(titulo);
        this.etiquetas = etiquetas;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator(',');
        formato = new DecimalFormat("0.00", simbolos);

        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        campos = new JTextField[etiquetas.length];
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel etiqueta = new JLabel(etiquetas[i]);
            etiqueta.setBounds(20, 20 + 30 * i, 110, 25);
            campos[i] = new JTextField();
            campos[i].setBounds(135, 20 + 30 * i, 100, 25);
            contenedor.add(etiqueta);
            contenedor.add(campos[i]);
        }

        int y = 20 + 30 * etiquetas.length;
        calcular = new JButton("Calcular");
        calcular.setBounds(135, y, 100, 28);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        volumen = new JLabel("Volumen (cm3): ");
        volumen.setBounds(20, y + 40, 225, 25);
        superficie = new JLabel("Superficie (cm2): ");
        superficie.setBounds(20, y + 70, 225, 25);
        contenedor.add(volumen);
        contenedor.add(superficie);

        ImagenFigura imagen = new ImagenFigura(tipoImagen);
        imagen.setBounds(255, 20, 120, 120);
        contenedor.add(imagen);

        contenedor.setPreferredSize(new Dimension(395, Math.max(155, y + 105)));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /** Cada figura concreta crea su objeto con los valores ingresados (en orden). */
    protected abstract FiguraGeometrica crearFigura(double[] valores);

    @Override
    public void actionPerformed(ActionEvent evento) {
        double[] valores = new double[campos.length];
        for (int i = 0; i < campos.length; i++) {
            String nombre = etiquetas[i].replace(":", "");
            String texto = campos[i].getText().trim();
            if (texto.isEmpty()) {
                mostrarError("Falta ingresar: " + nombre, campos[i]);
                return;
            }
            double valor;
            try {
                valor = Double.parseDouble(texto.replace(',', '.'));
            } catch (NumberFormatException ex) {
                mostrarError(nombre + " no es un número válido: \"" + texto + "\"", campos[i]);
                return;
            }
            if (!(valor > 0) || Double.isInfinite(valor)) {
                mostrarError(nombre + " debe ser un número mayor que cero", campos[i]);
                return;
            }
            valores[i] = valor;
        }
        FiguraGeometrica figura = crearFigura(valores);
        volumen.setText("Volumen (cm3): " + formato.format(figura.calcularVolumen()));
        superficie.setText("Superficie (cm2): " + formato.format(figura.calcularSuperficie()));
    }

    private void mostrarError(String mensaje, JTextField campo) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
        campo.selectAll();
    }
}
