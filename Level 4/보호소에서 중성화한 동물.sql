-- 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
SELECT
    A.ANIMAL_ID
    ,A.ANIMAL_TYPE
    ,A.NAME
FROM ANIMAL_INS A
INNER JOIN ANIMAL_OUTS B
    ON A.ANIMAL_ID = B.ANIMAL_ID 
    AND B.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
WHERE A.SEX_UPON_INTAKE LIKE 'Intact%'
ORDER BY A.ANIMAL_ID ASC;
