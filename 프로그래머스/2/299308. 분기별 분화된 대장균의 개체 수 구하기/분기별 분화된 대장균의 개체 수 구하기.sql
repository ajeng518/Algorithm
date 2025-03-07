SELECT CONCAT(TRUNCATE(((MONTH(DIFFERENTIATION_DATE)-1) /3) +1, 0),'Q') AS QUARTER,
        COUNT(ID) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY 1
ORDER BY QUARTER
;