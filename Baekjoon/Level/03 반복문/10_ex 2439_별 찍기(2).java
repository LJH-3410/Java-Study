import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N ;
        N = scan.nextInt();
        int cnt=0;
		for(int i = 0; i < N; i++) {
			for( int j = 0 ; j < N ; j++ ) {
				if(j>=N-1-cnt) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
			cnt++;
		}
		scan.close();
	}
}