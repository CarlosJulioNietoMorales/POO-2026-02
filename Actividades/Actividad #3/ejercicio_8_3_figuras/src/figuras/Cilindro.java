package figuras;

public class Cilindro extends FiguraGeometrica {

    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        double v = Math.PI * radio * radio * altura;
        setVolumen(v);
        return v;
    }

    @Override
    public double calcularSuperficie() {
        double s = 2 * Math.PI * radio * (radio + altura);
        setSuperficie(s);
        return s;
    }
}
