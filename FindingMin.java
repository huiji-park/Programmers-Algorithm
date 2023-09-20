import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
	int index;
	int value;
	
	Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

public class FindingMin {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()); // 데이터 개수
		final int L = Integer.parseInt(st.nextToken()); // 최솟값 구하는 범위
		Deque<Node> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken()); //데이터 하나 읽어오기

			while(!deque.isEmpty() && (deque.getLast()).value > value)
				deque.removeLast();
			deque.addLast(new Node(i, value));
			
			while((deque.getFirst()).index <= i - L)
				deque.removeFirst();
			bw.write((deque.getFirst()).value + " ");
		}
		bw.flush();
		bw.close();
	}
}