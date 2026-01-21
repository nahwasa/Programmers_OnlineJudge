import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<MineralPile> mineralPiles = new ArrayList<>();
        int pickCnt = picks[0] + picks[1] + picks[2];

        int idx = 0;
        while (idx < minerals.length && mineralPiles.size() < pickCnt) {
            int end = idx + Math.min(5, minerals.length - idx);
            mineralPiles.add(new MineralPile(minerals, idx, end-1));
            idx += end - idx;
        }

        Collections.sort(mineralPiles);

        int answer = 0;
        Iterator<MineralPile> pt = mineralPiles.iterator();
        for (int i = 0; i < 3; i++) {
            while (picks[i]-- > 0 && pt.hasNext()) {
                answer += pt.next().scores[i];
            }
        }

        return answer;
    }
    
    class MineralPile implements Comparable<MineralPile> {
        private final int[][] SCORE_BASE = {{1,1,1}, {5,1,1}, {25,5,1}};

        private int[] pile;
        int[] scores = new int[3];

        public MineralPile(String[] minerals, int startOffset, int endOffset) {
            pile = new int[endOffset - startOffset + 1];
            for (int i = startOffset; i <= endOffset; i++) {
                pile[i - startOffset] = Mineral.from(minerals[i]);
            }

            for (int i = 0; i < 3; i++) {
                scores[i] = calcScore(i);
            }
        }

        private int calcScore(int pick) {
            int sum = 0;
            for (int i = 0; i < pile.length; i++) {
                sum += SCORE_BASE[pick][pile[i]];
            }
            return sum;
        }

        @Override
        public int compareTo(final MineralPile o) {
            return o.scores[2] - this.scores[2];
        }
    }

    public enum Mineral {
        DIAMOND("diamond", 0),
        IRON("iron", 1),
        STONE("stone", 2);

        private final String key;
        private final int value;

        Mineral(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public static int from(String input) {
            for (Mineral m : values()) {
                if (m.key.equals(input)) {
                    return m.value;
                }
            }
            return -1;
        }
    }
}
