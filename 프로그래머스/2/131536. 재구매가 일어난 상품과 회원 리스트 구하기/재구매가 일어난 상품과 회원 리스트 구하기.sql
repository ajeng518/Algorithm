SELECT USER_ID,
        PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(PRODUCT_ID)>1
ORDER BY 1, 2 DESC
;










# SELECT A.USER_ID,
#         A. PRODUCT_ID
# FROM ONLINE_SALE A
# GROUP BY USER_ID, PRODUCT_ID
#     HAVING COUNT(*)>1
# ORDER BY 1 , 2 DESC
# ;