package figuras;

import javax.swing.SwingUtilities;

/** Punto de entrada del ejercicio 8.3. */
public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
            miVentanaPrincipal.setVisible(true);
        });
    }
}
