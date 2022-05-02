import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int max=0;
		int min=0;
        		int N = scan.nextInt();
		int[] arr = new int[N];
       		 int i;
		for (i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
       		scan.close();
        		Arrays.sort(arr);		//작은수부터 큰수 배열
		System.out.print(arr[0] + " " + arr[N - 1]);
	}
}