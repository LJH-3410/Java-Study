import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(true){
			
			int A=scan.nextInt();
			int B=scan.nextInt();
		
			if(A==0 && B==0){
				scan.close();
				break;
			}
			System.out.println(A+B);
		}
	}
}