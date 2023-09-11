import java.util.*;
public class Main { 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String input = scanner.next();
        char nums [] = input.toCharArray();
        int result = 0;
        for(char c : nums)
        	result += c - '0';
        System.out.print(result);
    }
}