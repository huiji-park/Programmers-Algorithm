import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()); //배열 길이
		st = new StringTokenizer(br.readLine());
		final int M = Integer.parseInt(st.nextToken()); //기준 숫자
		int input [] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		//인덱스는 양쪽 끝에 위치
		int index_left = 0;
		int index_right = N - 1;
		int count = 0;
		
		while(index_left < index_right) {
			if(input[index_left] + input[index_right] > M)
				index_right--;
			else if(input[index_left] + input[index_right] < M)
				index_left++;
			else {
				index_right--;
				index_left++;
				count++;
			}
		}
		
		System.out.print(count);
	}

}