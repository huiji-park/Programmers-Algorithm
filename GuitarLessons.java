import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GuitarLessons {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이의 수
        st = new StringTokenizer(br.readLine());
        int[] input = new int[N]; // 강의 길이 배열
        int max = 0; // 길이 최대값
        int total = 0; // 길이 합
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            max = Math.max(input[i], max);
            total += input[i];
        }
        int startIndex = max;
        int endIndex = total;
        int midIndex;
        int count;
        int sum;
        while(startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            count = 1;
            sum = 0;
            for(int i : input) {
                sum += i;
                if(sum > midIndex) {
                    count++;
                    sum = i;
                }
            }
            if(count <= M)
                endIndex = midIndex - 1;
            else
                startIndex = midIndex + 1;
        }
        System.out.println(startIndex);
    }

}