/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private int n;
    private int[][] arr;

    private void recursion(int num, int cnt) {
        int r = cnt * 2;
        int c = cnt;
        if (r >= n || arr[r][c] != 0) {
            return;
        }
        while (r < n && arr[r][c] == 0) {
            arr[r++][c] = num++;
        }
        r--; c++;

        while (c < n && arr[r][c] == 0) {
            arr[r][c++] = num++;
        }
        c-=2; r--;

        while(arr[r][c] == 0) {
            arr[r--][c--] = num++;
        }

        recursion(num, cnt+1);
    }

    public int[] solution(int n) {
        if (n == 1) {
            int[] answer = new int[1];
            answer[0] = 1;
            return answer;
        }
        this.n = n;
        arr = new int[n][n];
        recursion(1, 0);
        int[] answer = new int[(n*n-n) / 2 + n];
        int ansIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                answer[ansIdx++] = arr[i][j];
            }
        }

        return answer;
    }
}
