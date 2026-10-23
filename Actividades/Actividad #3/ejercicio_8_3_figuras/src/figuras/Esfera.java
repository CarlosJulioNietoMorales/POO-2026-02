package figuras;

public class Esfera extends FiguraGeometrica {

    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {
        double v = 4.0 / 3.0 * Math.PI * Math.pow(radio, 3);
        setVolumen(v);
        return v;
    }

    @Override
    public double calcularSuperficie() {
        double s = 4 * Math.PI * radio * radio;
        setSuperficie(s);
        return s;
    }
}
