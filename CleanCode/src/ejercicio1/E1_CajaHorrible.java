package ejercicio1;

import java.util.*;

public class E1_CajaHorrible {
	public static void main(String[] a) {
		try (Scanner sc = new Scanner(System.in)) {
			int numProduct = 0; //Variable indice del nume total de productos
			double totalSumProduct = 0; //Variable suma total de productos
			int[] stock = null; //Stock de cada producto 
			String[] nombreProduct = null;
			double[] precioProduct = null;
			int[] unidadesProduct = null; // variables importantes
			double IVA = 0.21;
			double D = 0.1;
			double DS = 0.05; // esto es el IVA y los descuentos
			System.out.println("hola esto es una caja registradora super guay"); // mensaje muy importante
			stock = new int[200]; // stock global
			
			//Todos los productos stock 10 
			for (int i = 0; i < stock.length; i++) {
				stock[i] = 10;
			} 
			
			//while para rellenar datos productos
			String siONo = "S";
			while (siONo.equals("S") || siONo.equals("s")) {
				System.out.println("n prod?");
				numProduct = sc.nextInt();
				sc.nextLine();
				nombreProduct = new String[numProduct];
				precioProduct = new double[numProduct];
				unidadesProduct = new int[numProduct];
				int i = 0;
				while (i < numProduct) {
					System.out.println("nom?");
					nombreProduct[i] = sc.nextLine();
					System.out.println("p?");
					precioProduct[i] = sc.nextDouble();
					System.out.println("u?");
					unidadesProduct[i] = sc.nextInt();
					sc.nextLine();

					if (precioProduct[i] < 0)
						precioProduct[i] = -precioProduct[i]; // arregla negativo
					if (unidadesProduct[i] == 0)
						unidadesProduct[i] = 1; // si 0 pues 1
					if (unidadesProduct[i] < 0)
						unidadesProduct[i] = unidadesProduct[i] * -1;
					totalSumProduct = totalSumProduct + (precioProduct[i] * unidadesProduct[i]); // total parcial
					int idx = (nombreProduct[i].length() * 17 + i * 3) % 200; // indice de stock
					stock[idx] = stock[idx] - unidadesProduct[i]; // actualiza stock
					if (stock[idx] < 0)
						System.out.println("stock negativo pero da igual"); // aviso
					i++;
				}

				System.out.println("SOCIO?? (1/0)");
				int SO = sc.nextInt();
				sc.nextLine();

				double d1 = 0;
				if (totalSumProduct > 100)
					d1 = totalSumProduct * D;
				else
					d1 = 0; // descuento si supera 100
				double x = totalSumProduct - d1;
				double d2 = 0;
				if (SO == 1)
					d2 = x * DS; // descuento socio
				double bi = x - d2;
				double iva = bi * IVA;
				double tt = bi + iva;

				// imprimir ticket
				System.out.println("===========TICKET===========");
				for (int j = 0; j < numProduct; j++) {
					System.out.println("LIN " + j + " -> " + nombreProduct[j] + " " + unidadesProduct[j] + " " + precioProduct[j] + " " + (unidadesProduct[j] * precioProduct[j])); // imprime
																															// linea
				}
				System.out.println("SUB=" + totalSumProduct);
				System.out.println("D1=" + d1);
				System.out.println("D2=" + d2);
				System.out.println("BI=" + bi);
				System.out.println("IV=" + iva);
				System.out.println("TT=" + tt);
				System.out.println("============================");

				System.out.println("otra? S/N");
				siONo = sc.nextLine();
				if (siONo.equals("N") || siONo.equals("n")) {
					System.out.println("adios");
				}
				totalSumProduct = 0; // resetea total
			}
		}
	}
}
