import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t ;
        t = scan.nextInt();
		for(int i = 0; i < t; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println("Case #" + (i+1) +": "+ a +" + "+ b  +" = "+(a + b));
		}
        scan.close();
	}
}