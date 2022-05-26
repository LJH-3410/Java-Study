import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		if(N%1000==0) {
			double result1 = (N- N * 0.22);
			double result2 = N * 0.8 + (N*0.2) - ((N*0.2) * 0.22);
			System.out.println((int) result1);
			System.out.println((int) result2);
		}
	}
}