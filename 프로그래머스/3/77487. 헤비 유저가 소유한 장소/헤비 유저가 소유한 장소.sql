SELECT ID,
        NAME,
        HOST_ID
FROM PLACES
WHERE HOST_ID IN (
            SELECT HOST_ID
            FROM PLACES
            GROUP BY HOST_ID
            HAVING COUNT(HOST_ID)>1
            )
ORDER BY 1
;


# SELECT  A.ID,
#         A.NAME,
#         A.HOST_ID
# FROM PLACES A JOIN (SELECT * 
#                     FROM PLACES B
#                     GROUP BY B.HOST_ID
#                     HAVING COUNT(B.HOST_ID) > 1
#                     ) C
#     ON A.HOST_ID = C.HOST_ID
# ORDER BY A.ID
# ;