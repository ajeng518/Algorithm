SELECT CATEGORY,
    SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK B JOIN BOOK_SALES BS
    ON B.BOOK_ID = BS.BOOK_ID
WHERE BS.SALES_DATE LIKE '2022-01-%'
GROUP BY B.CATEGORY
ORDER BY 1
;












# -- 코드를 입력하세요
# SELECT b.CATEGORY, SUM(bs.SALES) AS TOTAL_SALES
# FROM BOOK  b
#     JOIN BOOK_SALES bs
#     ON b.BOOK_ID = bs.BOOK_ID
# WHERE bs.SALES_DATE LIKE '2022-01%'
# GROUP BY b.CATEGORY
# ORDER BY b.CATEGORY
# ;