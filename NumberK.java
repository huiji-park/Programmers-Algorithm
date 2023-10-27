import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); // 배열의 크기
        final int k = Integer.parseInt(br.readLine()); // k번째 수 찾기
        int startIndex = 1;
        int endIndex = k;
        int midIndex;
        int sum;
        int result = 0;
        while(startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            sum = 0;
            for(int i = 0; i < N; i++) {
                sum += Math.min(midIndex / (i + 1), N);
            }
            if(sum < k)
                startIndex = midIndex + 1;
            else {
                endIndex = midIndex - 1;
                result = midIndex;
            }
        }
        System.out.println(result);
    }
}