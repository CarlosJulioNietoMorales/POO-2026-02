package figuras;

public class VentanaCilindro extends VentanaFigura {

    public VentanaCilindro() {
        super("Cilindro", new String[] {"Radio (cms):", "Altura (cms):"}, "Cilindro");
    }

    @Override
    protected FiguraGeometrica crearFigura(double[] valores) {
        return new Cilindro(valores[0], valores[1]);
    }
}
