import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bindingNums {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); // 수열의 크기
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int input;
        for(int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            if(input > 0)
                positive.add(input);
            else
                negative.add(input);
        }
        int sum = 0;
        int num1;
        int num2;
        while(positive.size() > 1) {
            num1 = positive.poll();
            num2 = positive.poll();
            sum += Math.max(num1 + num2, num1 * num2);
        }
        while(!positive.isEmpty())
            sum += positive.poll();
        while(negative.size() > 1) {
            num1 = negative.poll();
            num2 = negative.poll();
            sum += Math.max(num1 + num2, num1 * num2);
        }
        while(!negative.isEmpty())
            sum += negative.poll();
        System.out.println(sum);
    }
}