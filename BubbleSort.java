import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BubbleSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = Integer.parseInt(br.readLine()); // 수의 개수
		int nums [] = new int[N];
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		
		int tmp;
		for(int i = 0; i < N - 1; i++)
			for(int j = 0; j < N - 1 - i; j++)
				if(nums[j] > nums[j + 1]) {
					tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
		for(int n : nums)
			bw.write(n + "\n");
		bw.flush();
		bw.close();
	}
}