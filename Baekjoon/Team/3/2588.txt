import java.util.*;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A,B,C;
		int a,b,c,d;
		A=sc.nextInt();
		B=sc.nextInt();
		a=B%1000/100;		//백의자리
		b=B%100/10;			//십의자리
		c=B%10/1;			//일의자리
		System.out.println(A*c);
		System.out.println(A*b);
		System.out.println(A*a);
		System.out.println(A*B);
	}
}