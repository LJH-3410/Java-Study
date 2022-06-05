import java.util.*;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b,c;							//주사위의 눈
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();		
	
		if(a==b && b==c) {
			System.out.println(10000+(a*1000));
		}
		else if (a==b || a==c || b==c) {
			if(a==b || a==c) {
				System.out.println(1000+(a*100));
			}
			else { //b==c
				System.out.println(1000+(b*100));
			}
		}
		else {
			int max=0;						//최댓값
			if(max<a) max=a;
			if(max<b) max=b;
			if(max<c) max=c;
			System.out.println(max*100);
		}
	
	}
}