package application;

import java.util.Locale;
import java.util.Scanner;



public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Número de linhas: ");
		int n = sc.nextInt();		
		System.out.println("Número de colunas: ");
		int m = sc.nextInt();	
		
		System.out.println();
		int[][] vect = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Valores da linha "+ i +":");
			for (int j = 0; j < m; j++) {
				
				vect[i][j] = sc.nextInt();
				
			}
		}
		
		System.out.println("Qual número você quer os dados?");
		int x = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vect[i][j] == x) {
					
					System.out.println("Position "+ i +","+ j +":");
					
					getPosition(vect, i, j);
					
				}
			}
		}
		
		
		

		sc.close();
	}
	
	
	public static void getPosition(int[][] vect, int line, int column) {
		
		Integer up = null;
		Integer down = null;
		Integer left = null;
		Integer right = null;
		
		if ((line-1) >= 0) {
			up = vect[(line-1)][column];
		}
		if ((line+1) < vect.length) {
			down = vect[(line+1)][column];
		}
		if ((column-1) >= 0) {
			left = vect[line][(column-1)];
		}
		if ((column+1) < vect[line].length) {
			right = vect[line][(column+1)];
		}
		
		
		
		if (up != null) {
			System.out.println("Up: "+ up);
		}
		if (down != null) {
			System.out.println("Down: "+ down);
		}
		if (left != null) {
			System.out.println("Left: "+ left);
		}
		if (right != null) {
			System.out.println("Right: "+ right);
		}
		
	}

}
