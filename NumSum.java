import java.util.Scanner;

public class NumSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();
		int start_index = 1;
		int end_index = 1;
		int sum = 1; //현재 시작 인덱스부터 종료인덱스까지의 합
		int count = 1; //N일때를 이미 카운트했다고 생각.
		
		while(end_index < N) {
			if(sum < N)
				sum += ++end_index;
			else if(sum == N) {
				sum += ++end_index;
				count++;
			}
			else
				sum -= start_index++;
		}
		
		System.out.print(count);
		scanner.close();
	}

}