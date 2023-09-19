import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DNAPassword {
	static int nowArr [] = new int[4];
	static Map<String, Integer> dna = new HashMap<>() {{
			put("A", 0);
			put("C", 1);
			put("G", 2);
			put("T", 3);
	}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int S = Integer.parseInt(st.nextToken()); //문자열 크기
		final int P = Integer.parseInt(st.nextToken()); //부분문자열 크기
		String input [] = new String[S];
		st = new StringTokenizer(br.readLine());
		input =  String.valueOf(st.nextToken()).split("");
	
		int checkArr [] = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) { //checkArr 초기화
			checkArr[i] = Integer.parseInt(st.nextToken());
			nowArr[i] = 0;
		}
		for(int i = 0; i < P - 1; i++) //nowArr 초기화
			add(input[i]);
		
		int cnt = 0;
		int same = 0;
		for(int i = P - 1; i < S; i++) { //i는 우측 인덱스  
			int j = i - P; //j는 좌측 인덱스
			
			add(input[i]);
			if(j > -1)
				sub(input[j]);
			
			same = 0;
			for(int k = 0; k < 4; k++)
				if(nowArr[k] >= checkArr[k])
					same++;
			if(same == 4)
				cnt++;
		}
		
		System.out.print(cnt);
	}
	
	static void add(String s) {
		nowArr[dna.get(s)]++;
	}
	static void sub(String s) {
		nowArr[dna.get(s)]--;
	}
	static void printNow() {
		for(int i : nowArr)
			System.out.print(i);
	}
}