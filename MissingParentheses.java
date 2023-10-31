import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MissingParentheses {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder sb = new StringBuilder();
        String word;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < input.length(); i++) {
            word = input.substring(i, i+1);
            if(word.equals("+") || word.equals("-")) {
                queue.add(String.valueOf(sb));
                sb.setLength(0);
                queue.add(word);
            }
            else
                sb.append(word);
        }
        queue.add(String.valueOf(sb));

        int sum = 0;
        boolean minus = false;
        while(!queue.isEmpty()) {
            if(minus)
                sum -= Integer.parseInt(queue.poll());
            else
                sum += Integer.parseInt(queue.poll());
            if(!queue.isEmpty() && queue.poll().equals("-")) {
                minus = true;
            }
        }
        System.out.println(sum);
    }
}
