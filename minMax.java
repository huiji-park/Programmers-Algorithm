import java.lang.Math;

class Solution {
    public int solution(int[][] sizes) {
        int lengthMax = 0;
        int heightMax = 0;
        for(int[] size : sizes) {
            lengthMax = Math.max(lengthMax, Math.max(size[0], size[1]));
            heightMax = Math.max(heightMax, Math.min(size[0], size[1]));
        }
        return lengthMax * heightMax ;
    }
}