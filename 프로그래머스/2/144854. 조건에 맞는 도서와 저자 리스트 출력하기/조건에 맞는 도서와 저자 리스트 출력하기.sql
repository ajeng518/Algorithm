-- 코드를 입력하세요
SELECT A.BOOK_ID,
        B.AUTHOR_NAME,
        DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK A
    LEFT JOIN AUTHOR B
        ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE A.CATEGORY LIKE '경제'
ORDER BY 3
;