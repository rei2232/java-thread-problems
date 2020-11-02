import java.util.Scanner;
class Mult extends Thread {
	private int[][] A;
	private int[][] B;
	private int[][] C;
	private int r,c;
	private int dm;
	
	public Mult(int[][] A, int[][] B, int[][] C, int r, int c, int dm) {
		
		this.A = A;
		this.B = B;
		this.C = C;
		this.r = r;
		this.c = c;
		this.dm = dm;
	}
	
	public void run() {
		for(int i=0;i<dm;i++) {
			C[r][c] += A[r][i] * B[i][c];
		}
		System.out.println("Thread "+r+" , "+c+" created.");
		
	}
}
public class Main2 {
	
	public static void main(String[] args) {
		Scanner In = new Scanner(System.in);
		System.out.println("Matrix hemjees: ");
		int n = In.nextInt();
		if(n==0) {
			System.out.println("Hemjees 0  baij bolohgui. ");
			System.exit(-1);
		}
		
		// init
		int[][] A = new int[n][n];
		int[][] B = new int[n][n];
		int[][] C = new int[n][n];
		Mult[][] tmp = new Mult[n][n];
		
		// Insert A matrix
		System.out.println("A matrix oruulah:");
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println("["+i+"],["+j+"] =");
				A[i][j] = In.nextInt();
			}
		}
		System.out.println();
		// Insert B matrix
		System.out.println("B matrix oruulah:");
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println("["+i+"],["+j+"] =");
				B[i][j] = In.nextInt();
			}
		}
		System.out.println();
		// Nud burt thread uusgen
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				tmp[i][j] = new Mult(A,B,C,i,j,n);
				tmp[i][j].start();
			}
		}
		// join
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				try {
					tmp[i][j].join();
				} catch(InterruptedException e) {
					System.out.println("Error");
				}
			}
		}
		
		// printing result
		System.out.println("Hariu: ");
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.println("["+i+"]["+j+"] = "+C[i][j] + "");
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
}