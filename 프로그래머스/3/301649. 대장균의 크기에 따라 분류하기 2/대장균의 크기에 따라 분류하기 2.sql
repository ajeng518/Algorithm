-- 코드를 작성해주세요
SELECT A.ID,
        CASE A.LANK
            WHEN 1 THEN 'CRITICAL'
            WHEN 2 THEN 'HIGH'
            WHEN 3 THEN 'MEDIUM'
            WHEN 4 THEN 'LOW'
        END AS COLONY_NAME    
FROM (SELECT ID, 
            NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS LANK
      FROM ECOLI_DATA 
      ) A
ORDER BY ID
;