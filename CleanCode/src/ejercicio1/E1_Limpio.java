package ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class E1_Limpio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int numProduct; //Número 
		int stock[] = new int[200]; //total de productos 
		final double IVA = 0.21; //IVA total
		final double DESCUENTO1 = 0.01; //Descuento 1
		final double DESCUENTO_SOCIO = 0.05; // Descuento socio
		final int STOCK =200; //Número de productos en stock
		boolean siONo = true; //Seguir comprando
		
		// mensaje muy importante
		System.out.println("hola esto es una caja registradora super guay"); 
		
		
		
		
		
		
		
		sc.close();
	}
	
	private static int[] inicializarStock(int STOCK) {
		Random rand = new Random();
        int[] stock = new int[STOCK];
        for (int i = 0; i < stock.length; i++) {
            stock[i] = rand.nextInt(1,101);
        }
        return stock;
    }
	
	private static int[] cadenaBlanco(int siONo) {
		try 
	}

}
