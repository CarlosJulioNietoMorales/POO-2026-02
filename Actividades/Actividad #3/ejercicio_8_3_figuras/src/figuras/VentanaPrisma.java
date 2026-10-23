package figuras;

public class VentanaPrisma extends VentanaFigura {

    public VentanaPrisma() {
        super("Prisma", new String[] {"Largo (cms):", "Ancho (cms):", "Alto (cms):"}, "Prisma");
    }

    @Override
    protected FiguraGeometrica crearFigura(double[] valores) {
        return new Prisma(valores[0], valores[1], valores[2]);
    }
}
