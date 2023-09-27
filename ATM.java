import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ATM {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int people = Integer.parseInt(br.readLine()); //사람 수
		int cost [] = new int[people]; //인출 소요 시간
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < people; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		int sum [] = new int[people]; //각 사람별 소요시간 합
		
		int insertPoint;
		int now;
		for(int i = 1; i < people; i++) { //사람 수 - 1만큼 반복
			now = cost[i];
			insertPoint = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(cost[j] < now) {
					insertPoint = j + 1;
					break;
				}
			}
			for(int j = i; j > insertPoint; j--) {
				cost[j] = cost[j - 1];
			}
			cost[insertPoint] = now;
		}
		
		sum[0] = cost[0];
		for(int i = 1; i < people; i++)
			sum[i] = sum[i - 1] + cost[i];
		
		int result = 0;
		for(int i : sum)
			result += i;
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
}