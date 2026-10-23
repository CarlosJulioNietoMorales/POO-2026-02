package figuras;

/** Clase base de todas las figuras: guarda volumen y superficie calculados. */
public abstract class FiguraGeometrica {

    private double volumen;
    private double superficie;

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getVolumen() {
        return volumen;
    }

    public double getSuperficie() {
        return superficie;
    }

    public abstract double calcularVolumen();

    public abstract double calcularSuperficie();
}
