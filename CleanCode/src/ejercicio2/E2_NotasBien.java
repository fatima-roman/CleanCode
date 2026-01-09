package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E2_NotasBien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int opcion; 
		int numAlum; 
		int numModulos;
		double notaLeida; 
		double[][] tablaNotas = null;
		Boolean salir = true;

		while(salir) {
			mostrarMenu();
			
			opcion = leerEntero(sc, 1, 6);
			
			switch (opcion) {
			case 1: {
				System.out.print("Número de alumnos:");
				numAlum =sc.nextInt();
				System.out.print("\nNúmero de módulos:");
				numModulos = sc.nextInt();
				
				tablaNotas = introducirNotas(sc, numAlum, numModulos);
				
				break;
			}
			case 2:{
				if (tablaNotas == null){
					System.out.println("No hay valores para mostrar.");
				}else {
					mostrarDatos(tablaNotas);
				}
				
				break;
			}
			case 3:{
				if (tablaNotas == null){
					System.out.println("No hay valores para mostrar.");
				}else {
					System.out.println("Media por alumno:");
					mediaAlum(tablaNotas);
				}
				
				break;
				
			}
			case 4:{
				if (tablaNotas == null){
					System.out.println("No hay valores para mostrar.");
				}else {
					System.out.println("Media por modulo:");
					mediaModulo(tablaNotas);
				}
				
				break;
			}
			case 5:{
				if (tablaNotas == null){
					System.out.println("No hay valores para mostrar.");
				}else {
					System.out.println("Nota minima y nota maxima:");
					notaMinMax(tablaNotas);
				}
				
				break;
				
			}}
			
			if(opcion == 6) {
				System.out.println("Saliendo.......");
				salir = false;
			}
		}
		
		sc.close();
	}
	
	public static void mostrarMenu() {
		System.out.println("====== Introduce una opción ======"
				+ "\n 1. Cargar notas"
				+ "\n 2. Ver datos"
				+ "\n 3. Media por alumno"
				+ "\n 4. Media por modulo"
				+ "\n 5. Nota mínima y nota máxima"
				+ "\n 6. Salir "
				+ "\n =================================");
	}
	
	
	//Comprobar si el númeor introducido es correcto 
	private static int leerEntero(Scanner scanner, int min, int max) {
        int opcion;

        try {
            opcion = scanner.nextInt();
            if (opcion < min || opcion > max) {
                System.out.println("Error: la opción debe estar entre " + min + " y " + max +"\n\n");
                opcion = -1;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: debes introducir un número entero.\n\n");
            scanner.nextLine(); //Limpiar scanner sin esto seria un bucle 
            opcion = -1;
        }

        return opcion;
    }
	
	
	//Leer notas y corregir valor de estas 
	private static double[][] introducirNotas(Scanner scanner, int numAlum, int numMod) {
		double[][] notas = new double[numAlum][numMod];
		double notaLeida;
		
		for (int i = 0; i<numAlum; i++) {
			for (int j =0; j<numMod; j++) {
				do {
					System.out.print("Introduce la nota del alumno " + (i+1) + " en el módulo " + (j+1)+ ":");
					notaLeida = scanner.nextDouble();
					System.out.println();
					
					if (notaLeida < 0 || notaLeida> 10) {
		                System.out.println("Error: la opción debe estar entre " + 0 + " y " + 10 +"\n\n");
		                notaLeida = -1;
		            }
				}while(notaLeida == -1);
				
				notas[i][j] = notaLeida; 
			}
		}
		System.out.println("\n\n");
		return notas;
	}
	
	private static void mostrarDatos(double[][] notas) {
		int j=0;
		for (int i = 0; i<notas.length; i++) {
			System.out.println("Alumno " + (i+1)+": "+ notas[i][j]);
			j++;
		}
	
	}
	
	
	private static void mediaAlum(double[][] notas) {
		double total =0 ; 
		try {
			for (int i = 0; i<notas.length;i++) {
				for (int j= 0; j<notas.length;j++) {
					total += notas[i][j];
				}
			System.out.println("Alumno " + (i+1) + ": " + (total/notas[i].length));
			}
			
		} catch (Exception e) {
			System.out.println("Total las notas 0 o error en los datos");
		}
		
	}
	
	private static void mediaModulo(double[][] notas) {
        int modulos = notas[0].length;

        for (int j = 0; j < modulos; j++) {
            double suma = 0;
            for (int i = 0; i < notas.length; i++) {
                suma += notas[i][j];
            }

            // División con dectectar error
            try {
                double media = suma / notas.length;
                System.out.println("Módulo "+(j+1)+": "+  media+ "\n\n");
            } catch (ArithmeticException e) {
                System.out.println("Todo en 0 o error calculando media del módulo " + (j + 1) );
            }
        }
	}
	
	private static void notaMinMax(double[][] notas) {
		double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double[] fila : notas) {
            for (double nota : fila) {
                if (nota < min) min = nota;
                if (nota > max) max = nota;
            }
        }

        System.out.printf("Nota mínima:"+ min + "\nNota máxima"+ max+"\n\n");
	}

}
