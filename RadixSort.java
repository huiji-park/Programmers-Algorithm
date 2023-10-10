import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RadixSort {
    static int N;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        N = Integer.parseInt(br.readLine()); //숫자 개수(문제 제시된 값)
        input = new int[N]; //입력받은 배열
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        radixSort(input);
        for(int i : input)
            result.append(i).append('\n');
        System.out.print(result);
    }

    static void radixSort(int[] input) {
        int[] bucket = new int[10]; //n자릿수가 몇 개 있는지 알려주는 합 배열
        int[] output = new int[N]; //임시 정렬 배열
        int now = 1; //현재 자릿수
        int cnt;
        while(now < 100000) {
            Arrays.fill(bucket, 0);
            Arrays.fill(output, 0); //0으로 초기화

            for (int i = 0; i < N; i++) {
                int num = input[i] % (now * 10) / now;
                bucket[num] += 1;
            }
            for (int num = 1; num < 10; num++) { //1부터 9까지
                bucket[num] += bucket[num - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int num = input[i] % (now * 10) / now;
                int index = bucket[num] - 1;
                output[index] = input[i];
                bucket[num]--;
            }
            for(int i = 0; i < N; i++)
                input[i] = output[i];
            now *= 10;
        }
    }

}