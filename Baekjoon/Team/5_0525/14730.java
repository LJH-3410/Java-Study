import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for(int i=0;i<num;i++)
		{
			int n = sc.nextInt();
			int x = sc.nextInt();
			sum += n*x;
		}
        sc.close();
		System.out.println(sum);
	}
}