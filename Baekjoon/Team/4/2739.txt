import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int N;
		for (N=1; N<=9; N++) {
			System.out.println(num +" * "+ N +" = "+num*N);
		}
	}
}
