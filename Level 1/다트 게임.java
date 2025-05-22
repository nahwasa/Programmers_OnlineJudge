/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {
    class Dart {
        int score;
        int bonus;
        int option;

        public Dart(int score, int bonus, int option) {
            this.score = score;
            this.bonus = bonus;
            this.option = option;
        }
    }

    private static boolean isNumber(char cur) {
        return cur >= '0' && cur <= '9';
    }

    private static boolean isWord(char cur) {
        return cur >= 'A' && cur <= 'Z';
    }

    private static int charToInt(char c) {
        return c - '0';
    }

    public int solution(String dartResult) {
        char[] chars = new char[dartResult.length()+1];
        for (int i = 0; i < dartResult.length(); i++) {
            chars[i] = dartResult.charAt(i);
        }

        List<Dart> darts = new ArrayList<>();
        darts.add(new Dart(0, 1, 1));

        // parsing
        Dart bf = darts.get(0);
        Dart temp = null;

        for (int i = 0; i < chars.length-1; i++) {
            char cur = chars[i];

            if (temp == null)
                temp = new Dart(0, 0, 1);

            if (isNumber(cur)) {
                temp.score *= 10;
                temp.score += charToInt(cur);
                continue;
            }

            if (isWord(cur)) {
                temp.bonus = cur == 'S' ? 1 : (cur == 'D' ? 2 : 3);
                if (isNumber(chars[i+1])) {
                    bf = temp;
                    darts.add(temp);
                    temp = null;
                }
                continue;
            }

            if (cur == '*') {
                temp.option *= 2;
                bf.option *= 2;
            } else {
                temp.option *= -1;
            }

            bf = temp;
            darts.add(temp);
            temp = null;
        }
        if (temp != null)
            darts.add(temp);

        // calc
        int answer = 0;
        for (Dart dart : darts) {
            int cur = 1;
            for (int i = 0; i < dart.bonus; i++) {
                cur *= dart.score;
            }
            cur *= dart.option;

            answer += cur;
        }

        return answer;
    }
}
