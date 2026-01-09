package ejercicio1;

import java.util.Scanner;

public class E1_Limpio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Constantes
        final int STOCK_TOTAL = 200;
        final int STOCKXPRODUCT=10; //Por si se desea inicializar stock con otro número 
        final double IVA = 0.21;
        final double DESCUENTO1 = 0.10;
        final double DESCUENTO_SOCIO = 0.05;

        // Variables
        boolean seguir = true;
        
        //Stock de 10 sobre 200 productos 
        int[] stock = inicializarStock(STOCK_TOTAL, STOCKXPRODUCT);
        int numProduct;

        System.out.println("Hola, esto es una caja registradora super guay");

        while (seguir) {

            System.out.print("Número de productos: ");
            numProduct = sc.nextInt();
            sc.nextLine();

            String[] nombres = new String[numProduct];
            double[] precios = new double[numProduct];
            int[] unidades = new int[numProduct];

            double subtotal = 0;

            for (int i = 0; i < numProduct; i++) {

                System.out.print("Nombre: ");
                nombres[i] = sc.nextLine();

                System.out.print("Precio: ");
                precios[i] = sc.nextDouble();

                System.out.print("Unidades: ");
                unidades[i] = sc.nextInt();

                //Total productos sin IVA
                subtotal += precios[i] * unidades[i];

                //restar las unidades al número en stock 
                int idYStock = calcularIndiceStock(nombres[i], i, STOCK_TOTAL);
                stock[idYStock] -= unidades[i];

                //si unidades >10 
                if (stock[idYStock] < 0) {
                    System.out.println("Stock negativo, no queda en stock");
                }
            }

            System.out.print("¿Es socio? (1 = sí / 0 = no): ");
            boolean socio = sc.nextInt() == 1;
            sc.nextLine();

            double descuentoCompra = subtotal > 100 ? subtotal * DESCUENTO1 : 0;
            double descuentoBase = subtotal - descuentoCompra;
            
            double descuentoSocio = socio ? descuentoBase * DESCUENTO_SOCIO : 0;
            double descuentoTotal = descuentoBase - descuentoSocio;
            
            double iva = descuentoTotal * IVA;
            double total = descuentoTotal + iva;

            imprimirTicket(
                    nombres, precios, unidades,
                    subtotal, descuentoCompra, descuentoSocio,
                    descuentoTotal, iva, total
            );

            System.out.print("¿Otra compra? (S/N): ");
            seguir = sc.nextLine().equalsIgnoreCase("S"); 
            /*
             * Seguir es boolean con equalsIgnoreCase si es s o S 
             * Es = a True, si es otro es = a False 
             */
        }

        sc.close();
    }

    private static int[] inicializarStock(int STOCK, int stockTotal) {
        int[] stock = new int[STOCK];
        for (int i = 0; i < stock.length; i++) {
            stock[i] = stockTotal;
        }
        return stock;
    }

    //posición en un srock según la longitud del nombre del articulo 
    // si art1 = p y art2 = o se restará sobre distinto stock gracias a i 
    private static int calcularIndiceStock(String nombre, int i, int STOCK) {
        return (nombre.length() * 17 + i * 3) % STOCK;
    }

    private static void imprimirTicket(String[] nombres,double[] precios,int[] unidades,double subtotal,double d1,double d2,double base,double iva,double total) {

        System.out.println("\n=========== TICKET ===========");

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i+" -> "+nombres[i]+" | "+unidades[i]+" x "+precios[i]+" = " + unidades[i] * precios[i]);
        }

        System.out.print("SUBTOTAL:"+ subtotal);
        System.out.print("\nDESCUENTO 1:"+ d1);
        System.out.print("\nDESCUENTO SOCIO:"+ d2);
        System.out.print("\nBASE IMPONIBLE: "+ base);
        System.out.print("\nIVA: "+ iva);
        System.out.print("\nTOTAL:"+ total);

        System.out.println("\n\n==============================\n");
    }
}

