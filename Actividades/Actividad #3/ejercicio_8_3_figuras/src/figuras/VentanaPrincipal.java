package figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/** Ventana principal: un boton por figura que abre su ventana de calculo. */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JButton cilindro;
    private JButton esfera;
    private JButton piramide;
    private JButton cubo;
    private JButton prisma;
    private VentanaCilindro ventanaCilindro;
    private VentanaEsfera ventanaEsfera;
    private VentanaPiramide ventanaPiramide;
    private VentanaCubo ventanaCubo;
    private VentanaPrisma ventanaPrisma;

    public VentanaPrincipal() {
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = crearBoton("Cilindro", 15);
        esfera = crearBoton("Esfera", 125);
        piramide = crearBoton("Pirámide", 235);
        cubo = crearBoton("Cubo", 345);
        prisma = crearBoton("Prisma", 455);

        ventanaCilindro = new VentanaCilindro();
        ventanaEsfera = new VentanaEsfera();
        ventanaPiramide = new VentanaPiramide();
        ventanaCubo = new VentanaCubo();
        ventanaPrisma = new VentanaPrisma();

        setTitle("Figuras");
        setSize(585, 120);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JButton crearBoton(String texto, int x) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, 25, 105, 28);
        boton.addActionListener(this);
        contenedor.add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Object origen = evento.getSource();
        if (origen == cilindro) {
            abrir(ventanaCilindro);
        } else if (origen == esfera) {
            abrir(ventanaEsfera);
        } else if (origen == piramide) {
            abrir(ventanaPiramide);
        } else if (origen == cubo) {
            abrir(ventanaCubo);
        } else if (origen == prisma) {
            abrir(ventanaPrisma);
        }
    }

    private void abrir(JFrame ventana) {
        ventana.setVisible(true);
        ventana.toFront();
    }
}
