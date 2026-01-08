package ejercicio2;
import java.util.*;

public class E2_NotasHorrible{
	static int fff(double[][] A, int n, int m, int op) { // función
		double s = 0;
		double mm = 999;
		double xx = -1; // variables
		if (A == null)
			return -9; // error
		if (n <= 0 || m <= 0)
			return -8;
		if (op == 2) { // imprimir
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(A[i][j] + " ");
				}
				System.out.println();
			}
			return 0;
		}
		if (op == 3) { // media alumno
			for (int i = 0; i < n; i++) {
				s = 0;
				for (int j = 0; j < m; j++) {
					s = s + A[i][j];
				}
				System.out.println("A" + i + "=" + (s / m));
			}
			return 1;
		}
		if (op == 4) { // media modulo
			for (int j = 0; j < m; j++) {
				s = 0;
				for (int i = 0; i < n; i++) {
					s = s + A[i][j];
				}
				System.out.println("M" + j + "=" + (s / n));
			}
			return 2;
		}
		if (op == 5) { // minmax
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (A[i][j] < mm)
						mm = A[i][j];
					if (A[i][j] > xx)
						xx = A[i][j];
				}
			}
			System.out.println("min=" + mm + " max=" + xx);
			return 3;
		}
		return -1; // si no se sabe
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int op = 0;
		int n = 0;
		int m = 0;
		double[][] t = null;
		int c = 0; // c indica si hay datos o no
		String basura = ""; // variable por si acaso
		double tmp = 0; // variable
		System.out.println("Gestor de notas v0.0.0.1"); // mensaje

		while (op != 6) {
			System.out.println("1cargar 2ver 3mAl 4mMo 5minmax 6salir");
			op = s.nextInt();

			if (op == 1) {
				System.out.println("n?");
				n = s.nextInt();
				System.out.println("m?");
				m = s.nextInt();
				t = new double[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						System.out.println("nota i j");
						tmp = s.nextDouble();
						if (tmp < 0)
							tmp = 0;
						if (tmp > 10)
							tmp = 10;
						t[i][j] = tmp;
					}
				}
				c = 1;
			} else {
				if (op == 2 || op == 3 || op == 4 || op == 5) {
					if (c == 0) {
						System.out.println("no datos");
					} else {
						int r = fff(t, n, m, op); // llama a la funcion
						if (r < 0) {
							System.out.println("error " + r);
						} // códigos de retorno
					}
				} else {
					if (op != 6)
						System.out.println("??"); // caso raro
				}
			}
		}
	}
}
