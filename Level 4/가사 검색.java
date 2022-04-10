/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Node {
    int cnt;
    Node[] child;
    public Node() {
        child = new Node['z'-'a'+1];
        cnt = 0;
    }
    public Node makeAndReturnChild(char c) {
        cnt++;
        if (child[c-'a'] == null) {
            child[c-'a'] = new Node();
        }
        return child[c-'a'];
    }
    public Node getChild(char c) {
        return child[c-'a'];
    }
}

class StringChecker {
    Node strChk;
    Node reverseStrChk;
    public StringChecker() {
        strChk = new Node();
        reverseStrChk = new Node();
    }

}

class Solution {
    private static final int MAX_WORDS_LENGTH = 10000;
    private StringChecker[] checkers = new StringChecker[10001];

    private void init() {
        checkers = new StringChecker[MAX_WORDS_LENGTH+1];
        for (int i = 1; i <= MAX_WORDS_LENGTH; i++) {
            checkers[i] = new StringChecker();
        }
    }

    private void insert(String s) {
        Node pt = checkers[s.length()].strChk;
        Node reversePt = checkers[s.length()].reverseStrChk;
        for (int i = 0; i < s.length(); i++) {
            pt = pt.makeAndReturnChild(s.charAt(i));
            reversePt = reversePt.makeAndReturnChild(s.charAt(s.length()-1-i));
        }
    }

    private int getCnt(String s) {
        Node pt = checkers[s.length()].strChk;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?')
                return pt.cnt;
            Node tmp = pt.getChild(c);
            if (tmp == null)
                break;
            pt = tmp;
        }
        return 0;
    }

    private int getCntFromReverse(String s) {
        Node reversePt = checkers[s.length()].reverseStrChk;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length()-1-i);
            if (c == '?')
                return reversePt.cnt;
            Node tmp = reversePt.getChild(c);
            if (tmp == null)
                break;
            reversePt = tmp;
        }
        return 0;
    }

    public int[] solution(String[] words, String[] queries) {
        init();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = queries[i].charAt(0)=='?' ? getCntFromReverse(queries[i]) : getCnt(queries[i]);
        }
        return answer;
    }
}
