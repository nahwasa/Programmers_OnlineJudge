-- 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
SELECT
    A.CART_ID
FROM CART_PRODUCTS A
INNER JOIN CART_PRODUCTS B ON A.CART_ID = B.CART_ID AND B.NAME = 'Milk'
WHERE A.NAME = 'Yogurt'
ORDER BY CART_ID ASC
;
