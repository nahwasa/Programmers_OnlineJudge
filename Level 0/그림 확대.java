/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    String[] answer;

    public String[] solution(String[] picture, int k) {
        answer = new String[picture.length*k];
        enlarge(picture, k, 0);
        return answer;
    }

    private void enlarge(final String[] picture, final int k, final int cur) {
        if (cur == picture.length) return;
        String enlargedPicture = horizontalEnlargePicture(picture[cur], k);
        insertAnswer(enlargedPicture, (cur+1)*k-1, cur*k);
        enlarge(picture, k, cur+1);
    }

    private void insertAnswer(final String enlargedPicture, final int limit, final int cur) {
        if (cur > limit) return;
        answer[cur] = enlargedPicture;
        insertAnswer(enlargedPicture, limit, cur+1);
    }

    private String horizontalEnlargePicture(final String s, final int k) {
        StringBuilder sb = new StringBuilder();
        repeatStr(sb, s, k, 0);
        return sb.toString();
    }
    
    private void repeatStr(final StringBuilder sb, final String s, final int k, final int idx) {
        if (idx == s.length()) return;
        appendRepeat(sb, s.charAt(idx), k, 0);
        repeatStr(sb, s, k, idx+1);
    }

    private void appendRepeat(final StringBuilder sb, final char c, final int k, final int ith) {
        if (ith == k) return;
        sb.append(c);
        appendRepeat(sb, c, k, ith+1);
    }
}
