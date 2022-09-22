/*
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */

function solution(n, words) {
    let answer = [0,0];
    let last = words[0][words[0].length-1];
    let hs = new Set();
    hs.add(words[0]);
    for (let i = 1; i < words.length; i++) {
        if (words[i][0] != last || hs.has(words[i])) {
            answer[0] = i%n+1;
            answer[1] = parseInt(i/n)+1;
            break;
        }
        last = words[i][words[i].length-1];
        hs.add(words[i]);
    }
    return answer;
}
