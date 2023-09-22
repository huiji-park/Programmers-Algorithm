import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCard {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = Integer.parseInt(br.readLine()); // 카드의 개수
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++)
			queue.add(i + 1);
		
		while(queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		bw.write(String.valueOf(queue.poll()));
		bw.flush();
		bw.close();
	}
}