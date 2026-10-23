package figuras;

/** Prisma rectangular (figura nueva, parte propuesta). */
public class Prisma extends FiguraGeometrica {

    private double largo;
    private double ancho;
    private double alto;

    public Prisma(double largo, double ancho, double alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularVolumen() {
        double v = largo * ancho * alto;
        setVolumen(v);
        return v;
    }

    @Override
    public double calcularSuperficie() {
        double s = 2 * (largo * ancho + largo * alto + ancho * alto);
        setSuperficie(s);
        return s;
    }
}
