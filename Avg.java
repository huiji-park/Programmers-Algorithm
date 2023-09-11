import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int[] score = new int[num];
		
		int max = 0;
		for(int i = 0; i < num; i++) {
			int input = scanner.nextInt();
			score[i] = input;
			
			if(input > max)
				max = input;
		}
		
		float[] newScore = new float[num];
		float sum = 0;
		for(int i = 0; i < num; i++) {
			newScore[i] = (float)score[i] / max * 100;
			sum += newScore[i];
		}
		
		float avg = sum / num;
		System.out.print(avg);
	}

}