SELECT B.WRITER_ID AS USER_ID,
        U.NICKNAME,
        SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD B LEFT JOIN USED_GOODS_USER U
    ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS LIKE'DONE'
GROUP BY B.WRITER_ID
HAVING SUM(B.PRICE) >=700000
ORDER BY 3
;











# -- 코드를 입력하세요
# SELECT B.USER_ID,
#         B.NICKNAME,
#         SUM(A.PRICE) AS TOTAL_SALES
# FROM USED_GOODS_BOARD A
#         LEFT JOIN USED_GOODS_USER B
#         ON A.WRITER_ID=B.USER_ID
# WHERE A.STATUS='DONE'
# GROUP BY A.WRITER_ID
# HAVING TOTAL_SALES >=700000
# ORDER BY TOTAL_SALES
# ;