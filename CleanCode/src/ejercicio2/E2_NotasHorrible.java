package ejercicio2;
import java.util.*;

public class E2_NotasHorrible {

    static int gestionarNotas(double[][] notas, int numAlumnos, int numModulos, int opcion) {
        double suma = 0;
        double notaMinima = 999;
        double notaMaxima = -1;

        if (notas == null)
            return -9;
        if (numAlumnos <= 0 || numModulos <= 0)
            return -8;

        if (opcion == 2) { // imprimir
            for (int i = 0; i < numAlumnos; i++) {
                for (int j = 0; j < numModulos; j++) {
                    System.out.print(notas[i][j] + " ");
                }
                System.out.println();
            }
            return 0;
        }

        if (opcion == 3) { // media alumno
            for (int i = 0; i < numAlumnos; i++) {
                suma = 0;
                for (int j = 0; j < numModulos; j++) {
                    suma = suma + notas[i][j];
                }
                System.out.println("A" + i + "=" + (suma / numModulos));
            }
            return 1;
        }

        if (opcion == 4) { // media modulo
            for (int j = 0; j < numModulos; j++) {
                suma = 0;
                for (int i = 0; i < numAlumnos; i++) {
                    suma = suma + notas[i][j];
                }
                System.out.println("M" + j + "=" + (suma / numAlumnos));
            }
            return 2;
        }

        if (opcion == 5) { // min y max
            for (int i = 0; i < numAlumnos; i++) {
                for (int j = 0; j < numModulos; j++) {
                    if (notas[i][j] < notaMinima)
                        notaMinima = notas[i][j];
                    if (notas[i][j] > notaMaxima)
                        notaMaxima = notas[i][j];
                }
            }
            System.out.println("min=" + notaMinima + " max=" + notaMaxima);
            return 3;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        int numAlumnos = 0;
        int numModulos = 0;
        double[][] tablaNotas = null;
        int hayDatos = 0;
        double notaLeida = 0;

        System.out.println("Gestor de notas v0.0.0.1");

        while (opcion != 6) {

            System.out.println("1cargar 2ver 3mAl 4mMo 5minmax 6salir");
            opcion = scanner.nextInt();

            if (opcion == 1) {

                System.out.println("n?");
                numAlumnos = scanner.nextInt();

                System.out.println("m?");
                numModulos = scanner.nextInt();

                tablaNotas = new double[numAlumnos][numModulos];

                for (int i = 0; i < numAlumnos; i++) {
                    for (int j = 0; j < numModulos; j++) {

                        System.out.println("nota i j");
                        notaLeida = scanner.nextDouble();

                        if (notaLeida < 0)
                            notaLeida = 0;
                        if (notaLeida > 10)
                            notaLeida = 10;

                        tablaNotas[i][j] = notaLeida;
                    }
                }
                hayDatos = 1;

            } else {

                if (opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {

                    if (hayDatos == 0) {
                        System.out.println("no datos");
                    } else {
                        int resultado = gestionarNotas(tablaNotas, numAlumnos, numModulos, opcion);
                        if (resultado < 0) {
                            System.out.println("error " + resultado);
                        }
                    }

                } else {
                    if (opcion != 6)
                        System.out.println("??");
                }
            }
        }
    }
}
