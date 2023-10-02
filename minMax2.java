class Solution {
    public String solution(String s) {
        String answer = "";
        String[] input = s.split(" ");
        int[] nums = new int[input.length];
        for(int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(input[i]);
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        answer = min + " " + max;
        return answer;
    }
}