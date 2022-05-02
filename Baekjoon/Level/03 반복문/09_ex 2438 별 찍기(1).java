import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N ;
        N = scan.nextInt();
		for(int i = 1; i <= N; i++) {
			for( int j = 1 ; j <= i ; j++ ) {
			System.out.print("*");
			}
			System.out.println("");
		}
		scan.close();
	}
}