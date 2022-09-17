/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int r = board.length;
        int c = board[0].length;
        Stack<Integer>[] stk = new Stack[c ];
        for (int j = 0; j < c; j++) {
            stk[j] = new Stack<>();
        }
        for (int j = 0; j < c; j++) {
            for (int i = r-1; i >= 0; i--) {
                if (board[i][j] == 0) break;
                stk[j].add(board[i][j]);
            }
        }

        Stack<Integer> basket = new Stack<>();
        int cnt = 0;
        for (int cur : moves) {
            if (stk[cur-1].isEmpty()) continue;
            int doll = stk[cur-1].pop();
            if (!basket.isEmpty() && basket.peek() == doll) {
                cnt++;
                basket.pop();
            } else {
                basket.push(doll);
            }
        }
        return cnt*2;
    }
}
