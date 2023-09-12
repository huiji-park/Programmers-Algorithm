import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FirstApp {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	final int SIZE = Integer.parseInt(st.nextToken());
    	final int COUNT = Integer.parseInt(st.nextToken());
    	
    	int[][] origin = new int[SIZE + 1][SIZE + 1];//입력되는 배열
    	int[][] sum = new int[SIZE + 1][SIZE + 1];//합배열
    	
    	for(int i = 1; i <= SIZE; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= SIZE; j++) {
    			origin[i][j] = Integer.parseInt(st.nextToken());
    			sum[i][j] = sum[i][j-1] + sum[i - 1][j] - sum[i - 1][j - 1] + origin[i][j];
    		}
    	}
    	
    	int x1;
    	int y1;
    	int x2;
    	int y2;
    	for(int i = 0; i < COUNT; i++) {
    		st = new StringTokenizer(br.readLine());
    		x1 = Integer.parseInt(st.nextToken());
    		y1 = Integer.parseInt(st.nextToken());
    		x2 = Integer.parseInt(st.nextToken());
    		y2 = Integer.parseInt(st.nextToken());
    		System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
    	}
    }
}
