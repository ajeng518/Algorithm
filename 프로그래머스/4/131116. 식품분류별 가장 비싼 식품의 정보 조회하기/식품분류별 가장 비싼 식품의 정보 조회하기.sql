SELECT A.CATEGORY,
        A.PRICE AS MAX_PRICE,
        A.PRODUCT_NAME
FROM FOOD_PRODUCT A
WHERE (A.CATEGORY, A.PRICE) IN (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
                                FROM FOOD_PRODUCT
                                WHERE CATEGORY LIKE '과자' 
                                        OR CATEGORY LIKE '국' 
                                        OR CATEGORY LIKE '식용유' 
                                        OR CATEGORY LIKE '김치'
                                GROUP BY CATEGORY ) 
ORDER BY 2 DESC
;