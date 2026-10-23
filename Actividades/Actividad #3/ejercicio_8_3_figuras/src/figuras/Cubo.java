package figuras;

/** Figura nueva (parte propuesta). */
public class Cubo extends FiguraGeometrica {

    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularVolumen() {
        double v = Math.pow(lado, 3);
        setVolumen(v);
        return v;
    }

    @Override
    public double calcularSuperficie() {
        double s = 6 * lado * lado;
        setSuperficie(s);
        return s;
    }
}
