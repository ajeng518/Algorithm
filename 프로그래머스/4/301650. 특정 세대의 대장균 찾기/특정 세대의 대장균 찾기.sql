-- 코드를 작성해주세요
SELECT A.ID
FROM (SELECT ID,
            PARENT_ID
        FROM ECOLI_DATA ) AS A
     JOIN (SELECT ID,
                    PARENT_ID
             FROM ECOLI_DATA ) AS B
     ON A.PARENT_ID=B.ID
     JOIN (SELECT ID,
                    PARENT_ID
             FROM ECOLI_DATA ) AS D
     ON B.PARENT_ID=D.ID
 WHERE D.PARENT_ID IS NULL
ORDER BY 1
;