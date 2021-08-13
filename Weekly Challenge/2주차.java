/**
 * - 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.Arrays;

class Solution {
    private char getGrade(double num) {
        if (num >= 90)  return 'A';
        if (num >= 80)  return 'B';
        if (num >= 70)  return 'C';
        if (num >= 50)  return 'D';
        return 'F';
    }

    public String solution(int[][] scores) {
        int n = scores.length;
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < n; c++) {
            int[] tmp = new int[n];
            double sum = 0;
            for (int r = 0; r < n; r++) {
                sum += scores[r][c];
                tmp[r] = scores[r][c];
            }
            Arrays.sort(tmp);
            int self = scores[c][c];
            int div = n;
            if (tmp[0]==self && tmp[0]!=tmp[1] || tmp[n-1]==self && tmp[n-1]!=tmp[n-2]) {
                div--;
                sum -= self;
            }
            sb.append(getGrade(sum / div));
        }
        return sb.toString();
    }
}
