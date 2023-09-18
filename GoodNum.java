import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()); //배열 길이
		int input [] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			//인덱스는 양쪽 끝에 위치
			int index_left = 0;
			int index_right = N - 1;
			
			while(index_left < index_right) {
				if(input[index_left] + input[index_right] == input[i])
					if(i == index_left) { //같은 수 확인
						index_left++;
					}
					else if(i == index_right) { //같은 수 확인
						 index_right--;
					}
					else {
						count++;
						break;
					}
				else if(input[index_left] + input[index_right] > input[i])
					index_right--;
				else
					index_left++;
			}
		}
		
		System.out.print(count);
	}

}