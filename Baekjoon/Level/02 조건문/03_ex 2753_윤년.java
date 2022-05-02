import java.util.*;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year; 
		year=sc.nextInt();
		if(year%4==0 && year%100!=0 || year%400==0) {	//윤년 조건
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
}