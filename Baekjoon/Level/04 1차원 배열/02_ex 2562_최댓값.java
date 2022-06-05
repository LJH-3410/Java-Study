import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		int count = 0;
		int max = 0;
		int index = 0;

		for (int value : arr) {
			count++;

			if (value > max) {
				max = value;
				index = count;
			}
		}
		System.out.print(max + "\n" + index);

	}
}