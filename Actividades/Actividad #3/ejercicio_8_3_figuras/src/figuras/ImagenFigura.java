package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/** Panel que dibuja la imagen de cada figura con Java2D (parte propuesta: imagen por figura). */
public class ImagenFigura extends JPanel {

    private static final Color BORDE = new Color(30, 90, 160);
    private static final Color CLARO = new Color(210, 232, 247);
    private static final Color MEDIO = new Color(150, 195, 230);
    private static final Color OSCURO = new Color(100, 160, 210);

    private final String tipo;

    public ImagenFigura(String tipo) {
        this.tipo = tipo;
        setPreferredSize(new Dimension(120, 120));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2f));
        switch (tipo) {
            case "Cilindro": dibujarCilindro(g2); break;
            case "Esfera": dibujarEsfera(g2); break;
            case "Pirámide": dibujarPiramide(g2); break;
            case "Cubo": dibujarCaja(g2, 20, 40, 60, 60, 20); break;
            case "Prisma": dibujarCaja(g2, 10, 55, 75, 40, 20); break;
            default: break;
        }
        g2.dispose();
    }

    private void dibujarCilindro(Graphics2D g2) {
        g2.setColor(MEDIO);
        g2.fillRect(30, 30, 60, 60);
        g2.fillOval(30, 80, 60, 20);
        g2.setColor(BORDE);
        g2.drawArc(30, 80, 60, 20, 180, 180);
        g2.drawLine(30, 30, 30, 90);
        g2.drawLine(90, 30, 90, 90);
        g2.setColor(CLARO);
        g2.fillOval(30, 20, 60, 20);
        g2.setColor(BORDE);
        g2.drawOval(30, 20, 60, 20);
    }

    private void dibujarEsfera(Graphics2D g2) {
        g2.setPaint(new java.awt.RadialGradientPaint(50, 45, 55,
                new float[] {0f, 1f}, new Color[] {CLARO, OSCURO}));
        g2.fillOval(20, 20, 80, 80);
        g2.setColor(BORDE);
        g2.drawOval(20, 20, 80, 80);
        g2.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[] {4f, 4f}, 0f));
        g2.drawArc(20, 50, 80, 20, 0, 180);
        g2.setStroke(new BasicStroke(2f));
        g2.drawArc(20, 50, 80, 20, 180, 180);
    }

    private void dibujarPiramide(Graphics2D g2) {
        Polygon izquierda = new Polygon(new int[] {58, 18, 65}, new int[] {15, 85, 102}, 3);
        Polygon derecha = new Polygon(new int[] {58, 65, 103}, new int[] {15, 102, 80}, 3);
        g2.setColor(CLARO);
        g2.fillPolygon(izquierda);
        g2.setColor(OSCURO);
        g2.fillPolygon(derecha);
        g2.setColor(BORDE);
        g2.drawPolygon(izquierda);
        g2.drawPolygon(derecha);
        g2.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[] {4f, 4f}, 0f));
        g2.drawLine(58, 15, 55, 66);
        g2.drawLine(55, 66, 18, 85);
        g2.drawLine(55, 66, 103, 80);
    }

    /** Dibuja un paralelepipedo: cara frontal (x, y, ancho, alto) y profundidad d. */
    private void dibujarCaja(Graphics2D g2, int x, int y, int w, int h, int d) {
        Polygon frente = new Polygon(new int[] {x, x + w, x + w, x}, new int[] {y, y, y + h, y + h}, 4);
        Polygon arriba = new Polygon(new int[] {x, x + w, x + w + d, x + d},
                new int[] {y, y, y - d, y - d}, 4);
        Polygon lado = new Polygon(new int[] {x + w, x + w + d, x + w + d, x + w},
                new int[] {y, y - d, y + h - d, y + h}, 4);
        g2.setColor(MEDIO);
        g2.fillPolygon(frente);
        g2.setColor(CLARO);
        g2.fillPolygon(arriba);
        g2.setColor(OSCURO);
        g2.fillPolygon(lado);
        g2.setColor(BORDE);
        g2.drawPolygon(frente);
        g2.drawPolygon(arriba);
        g2.drawPolygon(lado);
    }
}
