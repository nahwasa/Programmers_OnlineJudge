import java.util.*;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1)   return triangle[0][0];

        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {

                int bigger = 0;
                for (int k = -1; k <= 0; k++) {
                    if (j+k < 0 || j+k > i-1) continue;
                    bigger = Math.max(bigger, triangle[i-1][j+k]);
                }
                triangle[i][j] += bigger;

            }
        }
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
