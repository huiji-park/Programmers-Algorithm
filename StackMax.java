import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackMax {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = Integer.parseInt(br.readLine()); // 수열 크기
		int num [] = new int[N]; // 수열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>(); //인덱스를 담을 스택
		int result [] = new int[N]; //정답 배열
		
		for(int index = 0; index < N; index++) { //수열의 인덱스 0부터 N-1까지
			while(!stack.isEmpty() && num[index] > num[stack.peek()])
				result[stack.pop()] = num[index];
			stack.push(index);
		}
		while(!stack.isEmpty())
			result[stack.pop()] = -1;
		for(int n : result)
			bw.write(n + " ");
		
		bw.flush();
		bw.close();
	}
}