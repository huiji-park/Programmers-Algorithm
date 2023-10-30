import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CardSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); // 카드 묶음의 개수
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            queue.add(Integer.parseInt(br.readLine()));
        int result = 0;
        int num1;
        int num2;
        while(queue.size() > 1) {
            num1 = queue.poll();
            num2 = queue.poll();
            result += num1 + num2;
            queue.add(num1 + num2);
        }
        System.out.println(result);
    }
}