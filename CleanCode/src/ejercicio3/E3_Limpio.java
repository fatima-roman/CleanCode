package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E3_Limpio {
	// Constantes las declaro aqui para que todas las funciones tengan acceso
	//Asi me ahorro pasarle los datos cada vez
	public static final int PIN_CORRECTO = 1234;
	public static final int MAX_INTENTOS = 3;
	public static final int TAM_HISTORIAL = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double saldo = 500;
		String[] historial = new String[TAM_HISTORIAL];
		int indiceHistorial = 0;
		
		int resultadoPin = validarPin(sc);

		if (resultadoPin == -1) {
			System.out.println("TARJETA BLOQUEADA");
			return;}

		ejecutarMenu(sc, historial, saldo, indiceHistorial);

		sc.close();
		}


	public static int validarPin(Scanner sc) {
		for (int intentos = 0; intentos < MAX_INTENTOS; intentos++) {
			System.out.print("Introduce el PIN: ");
			int pin = leerEntero(sc);
			if (pin == PIN_CORRECTO) {
				return 1;
				} else {
					System.out.println("PIN incorrecto");
					}
			}
		return -1;
		}


	public static void ejecutarMenu(Scanner sc, String[] historial, double saldo, int indice) {
		int opcion;

		do {
			mostrarMenu();
			opcion = leerEntero(sc);
			switch (opcion) {
			case 1:
				saldo = ingresar(sc, historial, saldo, indice++);
				break;

			case 2:
				saldo = retirar(sc, historial, saldo, indice++);
				break;

			case 3:
				System.out.println("Saldo actual: " + saldo);
				break;

			case 4:
				mostrarHistorial(historial);
				break;
				
			case 5:
				System.out.println("Fin de la sesión. Saldo final: " + saldo);
				break;
				
			default:
				System.out.println("Opción no válida");
				}
			
		} while (opcion != 5);
		}

	public static void mostrarMenu() {
		System.out.println("""
				===== CAJERO =====
				1. Ingresar
				2. Retirar
				3. Consultar saldo
				4. Ver historial
				5. Salir
				==================
				""");
		}

	public static double ingresar(Scanner sc, String[] historial, double saldo, int indice) {
		System.out.print("Cantidad a ingresar: ");

		double cantidad = leerDouble(sc);

		if (cantidad <= 0) {
			System.out.println("Cantidad no válida");
			return saldo;
			}

		saldo += cantidad;
		guardarMovimiento(historial, indice, "INGRESO", cantidad, saldo);
		return saldo;
		}

	
	public static double retirar(Scanner sc, String[] historial, double saldo, int indice) {
		System.out.print("Cantidad a retirar: ");
		double cantidad = leerDouble(sc);

		if (cantidad <= 0) {
			System.out.println("Cantidad no válida");
			} else if (cantidad > saldo) {
				System.out.println("Saldo insuficiente");
				} else {
					saldo -= cantidad;
					guardarMovimiento(historial, indice, "RETIRADA", cantidad, saldo);
					}

		return saldo;
	    }

	public static void mostrarHistorial(String[] historial) {
		System.out.println("=== HISTORIAL ===");
		for (String mov : historial) {
			System.out.println(mov != null ? mov : "-");}
			}

	public static void guardarMovimiento(String[] historial, int indice,String tipo, double cantidad, double saldo) {
		historial[indice % TAM_HISTORIAL] =tipo + " " + cantidad + " | Saldo: " + saldo;
		}

	public static int leerEntero(Scanner sc) {
		try {
			return sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
				return -1;
				}
		}

	public static double leerDouble(Scanner sc) {
		try {
			return sc.nextDouble();
			} catch (InputMismatchException e) {
				sc.nextLine();
				return -1;
				}
	}}


