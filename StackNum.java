import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int  N = Integer.parseInt(br.readLine()); // 수열 개수
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder(); //메모리 초과 보완
		int num = 1;
		
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine()); //현재 수열
			if(now >= num) {
				while(now >= num) {
					stack.push(num++);
					result.append("+\n");
				}
				stack.pop();
				result.append("-\n");
			}
			else {
				if(stack.pop() > now) {
					result = new StringBuilder("NO");
					break;
				}
				else
					result.append("-\n");
			}
		}
		br.close();
		bw.write(result.toString());
		bw.flush();
		bw.close();
	}
}