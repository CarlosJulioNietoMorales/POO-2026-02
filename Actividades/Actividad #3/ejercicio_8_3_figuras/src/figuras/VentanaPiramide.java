package figuras;

public class VentanaPiramide extends VentanaFigura {

    public VentanaPiramide() {
        super("Pirámide", new String[] {"Base (cms):", "Altura (cms):", "Apotema (cms):"}, "Pirámide");
    }

    @Override
    protected FiguraGeometrica crearFigura(double[] valores) {
        return new Piramide(valores[0], valores[1], valores[2]);
    }
}
