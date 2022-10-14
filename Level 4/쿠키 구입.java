/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        for (int i = 0; i < cookie.length - 1; i++) {
            int a = i;
            int b = i+1;
            int sumA = cookie[a];
            int sumB = cookie[b];
            while (a >= 0 && b < cookie.length) {
                try {
                    if (sumA == sumB) {
                        answer = Math.max(answer, sumA);
                        sumA += cookie[--a];
                        sumB += cookie[++b];
                    } else if (sumA < sumB) {
                        sumA += cookie[--a];
                    } else {
                        sumB += cookie[++b];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }
        return answer;
    }
}
