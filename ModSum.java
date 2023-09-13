import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModSum {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 final int N = Integer.parseInt(st.nextToken());//배열의 길이
		 final int M = Integer.parseInt(st.nextToken());//나눠야 하는 값
		 int[] input = new int[N + 1];//배열
		 int[] mod = new int[M];//나머지 개수 배열
		 long result = 0;//return할 결과값_long으로 선언해야 한다
		 
		 for(int i = 0; i < M; i++) {//mod배열을 0으로 초기화
			 mod[i] = 0;
		 }
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i = 1; i <= N; i++) {
			 input[i] = input[i - 1] + Integer.parseInt(st.nextToken());
			 input[i] %= M;
			 mod[input[i]]++;
		 }
		 
		 //값이 0일 때
		 result += mod[0];
		 //같은 값을 두 번 뽑는 경우의 수
		 for(int i = 0; i < M; i++)
			 if(mod[i] > 1)
				 result += (long)mod[i] * (mod[i] - 1) / 2; 
		 
		 System.out.print(result);
	}

}