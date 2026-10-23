package figuras;

/** Piramide de base cuadrada: base = lado de la base, apotema = altura de una cara lateral. */
public class Piramide extends FiguraGeometrica {

    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    @Override
    public double calcularVolumen() {
        double v = base * base * altura / 3.0;
        setVolumen(v);
        return v;
    }

    @Override
    public double calcularSuperficie() {
        double s = base * base + 2 * base * apotema;
        setSuperficie(s);
        return s;
    }
}
