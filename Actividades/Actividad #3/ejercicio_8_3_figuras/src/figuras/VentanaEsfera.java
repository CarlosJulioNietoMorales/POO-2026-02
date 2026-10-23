package figuras;

public class VentanaEsfera extends VentanaFigura {

    public VentanaEsfera() {
        super("Esfera", new String[] {"Radio (cms):"}, "Esfera");
    }

    @Override
    protected FiguraGeometrica crearFigura(double[] valores) {
        return new Esfera(valores[0]);
    }
}
