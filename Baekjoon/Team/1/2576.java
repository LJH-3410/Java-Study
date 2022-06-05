import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int min=100;
		int num;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<7; i++) {
			num = scan.nextInt();
			if(num%2!=0) {
				sum += num;
				if(num<min) {
			        min=num;
				}
			}
		}
		if(sum==0) {
			System.out.println("-1");
		}
		else {
			System.out.println(sum+ "\n" + min);
		}
	}
}