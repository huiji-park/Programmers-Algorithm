import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortInside {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine(); //정렬할 수
		int[] words = new int[input.length()];
		for(int i = 0; i < input.length(); i++)
			words[i] = Integer.parseInt(input.substring(i, i + 1));
		for(int i = 0; i < input.length(); i++) {
			int max = -1;
			int index = -1;
			for(int j = i + 1; j < input.length(); j++)
				if(words[j] > max) {
					max = words[j];
					index = j;
				}
			if(words[i] < max) {
				words[index] = words[i];
				words[i] = max;
			}
		}
		for(int i : words)
			bw.write(i + "");
		bw.flush();
		bw.close();
	}

	
}