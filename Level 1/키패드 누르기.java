import java.util.Arrays;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private static final int IDX_OF_CHAR_STAR   = 10;
    private static final int IDX_OF_CHAR_SHARP  = 11;
    private static final char CHAR_LEFT_HAND    = 'L';
    private static final char CHAR_RIGHT_HAND   = 'R';

    private int[][] getBaseDistArr() {
        final int[][] pannel = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {IDX_OF_CHAR_STAR,0,IDX_OF_CHAR_SHARP},
        };
        int[][] dist = new int[12][12];
        for (int[] row : dist) Arrays.fill(row, 100);

        // find adjacent numpad
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (((dr^dc)&1) == 0) continue;
                        int nr = i+dr;
                        int nc = j+dc;
                        if (nr < 0 || nr >= 4 || nc < 0 || nc >= 3) continue;
                        dist[pannel[i][j]][pannel[nr][nc]] = 1;
                    }
                }
            }
        }

        // find all distance
        for (int k = 0; k <= 11; k++) {
            for (int i = 0; i <= 11; i++) {
                for (int j = 0; j <= 11; j++) {
                    if (i == j) dist[i][j] = 0;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        return dist;
    }

    private String solve(int[] numbers, boolean isLeftHandUser, int[][] dist) {
        StringBuilder res = new StringBuilder();
        int[] cur = new int[2];  //0; current position of left hand, 1; current position of right hand
        cur[0] = IDX_OF_CHAR_STAR;
        cur[1] = IDX_OF_CHAR_SHARP;

        for (int next : numbers) {
            boolean isLeft = false;
            switch (next) {
                case 1 : case 4 : case 7 :
                    isLeft = true;
                    break;
                case 3 : case 6 : case 9 :
                    isLeft = false;
                    break;
                default :
                    int[] tmp = {dist[cur[0]][next], dist[cur[1]][next]};
                    if (tmp[0] < tmp[1])  isLeft = true;
                    else if (tmp[0] > tmp[1])   isLeft = false;
                    else isLeft = isLeftHandUser;
                    break;
            }

            if (isLeft) {
                cur[0] = next;
                res.append(CHAR_LEFT_HAND);
            } else {
                cur[1] = next;
                res.append(CHAR_RIGHT_HAND);
            }
        }

        return res.toString();
    }

    public String solution(int[] numbers, String hand) {
        int[][] dist = getBaseDistArr();
        return solve(numbers, hand.equals("right")?false:true, dist);
    }
}
