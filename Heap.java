import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Heap {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = Integer.parseInt(br.readLine()); // 연산의 개수
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			int x = Integer.parseInt(o1.toString());
			int y = Integer.parseInt(o2.toString());
			
			if(Math.abs(x) == Math.abs(y))
				return x - y;
			else
				return Math.abs(x) - Math.abs(y);
		});
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(priorityQueue.size() == 0)
					bw.write(0 + "\n");
				else
					bw.write(priorityQueue.poll() + "\n");
			}
			else
				priorityQueue.add(input);
		}
		bw.flush();
		bw.close();
	}
}