-- 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
SELECT
    A.ANIMAL_ID
    ,A.NAME
FROM ANIMAL_INS A
INNER JOIN ANIMAL_OUTS B
    ON A.ANIMAL_ID = B.ANIMAL_ID AND A.DATETIME > B.DATETIME
ORDER BY A.DATETIME ASC;
