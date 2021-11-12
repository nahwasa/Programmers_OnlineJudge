import java.util.Arrays;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n+1][n+1];
        for (int[] row : arr)
            Arrays.fill(row, 101);
        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 101 || arr[j][i] != 101)
                    cnt++;
            }
            if (cnt == n-1) answer++;
        }
        return answer;
    }
}
