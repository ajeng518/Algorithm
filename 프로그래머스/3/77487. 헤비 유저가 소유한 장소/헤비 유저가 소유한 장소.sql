SELECT  A.ID,
        A.NAME,
        A.HOST_ID
FROM PLACES A JOIN (SELECT * 
                    FROM PLACES B
                    GROUP BY B.HOST_ID
                    HAVING COUNT(B.HOST_ID) > 1
                    ) C
    ON A.HOST_ID = C.HOST_ID
ORDER BY A.ID
;