import java.util.*;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h,m,b;
		h=sc.nextInt();
		m=sc.nextInt();
		b=sc.nextInt();		//공백
		
		h += b/60;
		m += b%60;
		
		if(m > 59) {
			h = h + 1;
			m = m -60;
		}
		if(h > 23) {
			h = h- 24;
		}
		System.out.println(h + " " + m);
	}
}
		
		