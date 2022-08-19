import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    int r, c;
    ArrayDeque<Integer> col1, col2;
    LinkedList<ArrayDeque<Integer>> rows;

    private void init(int[][] rc) {
        r = rc.length;
        c = rc[0].length;

        col1 = new ArrayDeque<>();
        col2 = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            col1.add(rc[i][0]);
            col2.add(rc[i][c-1]);
        }

        rows = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < c-1; j++) {
                tmp.add(rc[i][j]);
            }
            rows.add(tmp);
        }
    }

    private int[][] getAnswer() {
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            ans[i][0] = col1.pollFirst();
            ans[i][c-1] = col2.pollFirst();
        }
        int i = 0;
        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < c-1; j++) {
                ans[i][j] = row.pollFirst();
            }
            i++;
        }
        return ans;
    }

    private void rotate() {
        if (c == 2) {
            col2.addFirst(col1.pollFirst());
            col1.addLast(col2.pollLast());
            return;
        }
        rows.peekFirst().addFirst(col1.pollFirst());
        col2.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(col2.pollLast());
        col1.addLast(rows.peekLast().pollFirst());
    }

    private void shiftRow() {
        rows.addFirst(rows.pollLast());
        col1.addFirst(col1.pollLast());
        col2.addFirst(col2.pollLast());
    }

    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);
        for (String op : operations) {
            switch (op.charAt(0)) {
                case 'R' : rotate();    break;
                case 'S' : shiftRow();  break;
            }
        }
        return getAnswer();
    }
}
