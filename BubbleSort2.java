import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BubbleSort2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = Integer.parseInt(br.readLine()); // 데이터 개수
		mData[] data = new mData[N];
		for(int i = 0; i < N; i++) 
			data[i] = new mData(i, Integer.parseInt(br.readLine()));
		Arrays.sort(data);
		int max = -1;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, data[i].index - i);
		}
		bw.write(String.valueOf(max + 1));
		bw.flush();
		bw.close();
	}
}

class mData implements Comparable<mData>{
	int index;
	int value;
	
	public mData(int index, int value) {
		super();
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(mData o) {
		if(this.value > o.value)
			return 1;
		else if(this.value < o.value)
			return -1;
		return 0;
	}
	
}