package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam15352 {
	public static void main(String[] args) {
		BufferedReader br;
		int count = 0;
		String[] str = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			count = Integer.parseInt(br.readLine());
			str = new String[count];

			for (int i = 0; i < count; i++) {
				str[i] = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < count; i++) {
			int sum = 0;
			for (int j = 0; j < str[i].length(); j++) {
				if (str[i].charAt(j) != ' ')
					sum += (int) str[i].charAt(j) - 64;
			}
			if (sum == 100)
				System.out.println("PERFECT LIFE");
			else
				System.out.println(sum);
		}

	}
}
