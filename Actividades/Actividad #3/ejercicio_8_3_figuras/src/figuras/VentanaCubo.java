package figuras;

public class VentanaCubo extends VentanaFigura {

    public VentanaCubo() {
        super("Cubo", new String[] {"Lado (cms):"}, "Cubo");
    }

    @Override
    protected FiguraGeometrica crearFigura(double[] valores) {
        return new Cubo(valores[0]);
    }
}
