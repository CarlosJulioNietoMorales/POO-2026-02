package notas;

/**
 * Clase de dominio: guarda las notas de un estudiante y calcula
 * las metricas pedidas (promedio, desviacion estandar, mayor y menor).
 */
public class Notas {

    private double[] listaNotas;

    public Notas(double[] listaNotas) {
        if (listaNotas == null || listaNotas.length == 0) {
            throw new IllegalArgumentException("Debe existir al menos una nota");
        }
        this.listaNotas = listaNotas.clone();
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : listaNotas) {
            suma += nota;
        }
        return suma / listaNotas.length;
    }

    /** Desviacion estandar poblacional: raiz de la media de los cuadrados de las diferencias. */
    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;
        for (double nota : listaNotas) {
            suma += Math.pow(nota - promedio, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }
        return mayor;
    }

    public double calcularMenor() {
        double menor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        return menor;
    }
}
