import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSelectionSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()); //숫자 개수
		final int K = Integer.parseInt(st.nextToken()); //K번째 수
		st = new StringTokenizer(br.readLine());
		int input [] = new int[N]; //입력받은 배열
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		quickSort(input, 0, N - 1, K - 1);
		System.out.print(input[K - 1]);
	}

	static void quickSort(int[] nums, int start, int end, int k) {
		if(start < end) {
			int pivot = getPivot(nums, start, end);
			if(pivot == k)
				return;
			else if(pivot > k)
				quickSort(nums, start, pivot - 1, k);
			else
				quickSort(nums, pivot + 1, end, k);
		}
	}

	static int getPivot(int[] nums, int start, int end) {
		if(start + 1 == end) {
			if(nums[start] > nums[end])
				swap(nums, start, end);
			return end;
		}
		int middle = (end + start) / 2;
		
		swap(nums, start, middle);
		
		int pivot = nums[start];
		int i = start + 1;
		int j = end;
		while(i <= j) {
			while(nums[j] > pivot && j > 0) 
				j--;
			while(nums[i] < pivot && i < nums.length - 1) 
				i++;
			if(i <= j) {
				swap(nums, i++, j--);
			}
		}
		nums[start] = nums[j];
		nums[j] = pivot;
		return j;
	}

	static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
}