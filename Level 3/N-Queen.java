/**
 * - 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private int n;
    private int answer;
    private int[] v;    // put queen on v[row] column

    private void bt(int row) {
        boolean[] chk = new boolean[n]; // false:can put queen, true:can't
        for (int i = 0; i < row; i++) {
            int bf = v[i];
            chk[bf] = true; // column chk
            int gap = row - i;  // gap of row
            if (bf+gap < n)     chk[bf+gap] = true; // major diagonal chk
            if (bf-gap >= 0)    chk[bf-gap] = true; // minor diagonal chk
        }

        for (int i = 0; i < n; i++) {
            if (chk[i]) // can't put
                continue;
            if (row == n-1) {
                answer++;
                continue;
            }
            v[row] = i; // put queen on i column
            bt(row+1);  // next tracking
        }
    }

    public int solution(int n) {
        this.n = n;
        v = new int[n];
        bt(0);
        return answer;
    }
}
