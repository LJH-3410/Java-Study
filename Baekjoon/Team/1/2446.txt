import java.util.Scanner;
public class Main {					

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("높이를 입력하세요 : ");
		int N = scan.nextInt();				
		int cnt1=0;
		int cnt2=0;
		int h= 2*N-1;							
		int k= h/2;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < h; j++) {
				if( j >= 0+cnt1 && j < h-cnt1)
					System.out.print("*");
				else 
	            	System.out.print(" ");
				}
			System.out.println();
			cnt1++;
		}
		for(int i =k ; i < h; i++) {
			for(int j = 0; j < h; j++) {
				if( j >= k-cnt2 && j < k+1+cnt2)
					System.out.print("*");
				else 
	            	System.out.print(" ");
				}
			System.out.println();
			cnt2++;
		}
	}
}