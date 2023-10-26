import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SearchNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정렬할 수 개수
        int[] input = new int[N]; // 정수 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int M = Integer.parseInt(br.readLine()); // 탐색할 숫자의 개수
        int target;
        int startIndex;
        int endIndex;
        int midIndex;
        boolean exist;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            target = Integer.parseInt(st.nextToken()); // 탐색할 숫자
            startIndex = 0;
            endIndex = N - 1;
            midIndex = N / 2;
            exist = false;
            while(startIndex <= endIndex) {
                if(input[midIndex] > target)
                    endIndex = midIndex - 1;
                else if(input[midIndex] < target)
                    startIndex = midIndex + 1;
                else {
                    exist = true;
                    break;
                }
                midIndex = (startIndex + endIndex) / 2;
            }
            if(exist)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

}