-- 코드를 작성해주세요
SELECT 
    EMP.EMP_NO,
    EMP.EMP_NAME,
    GRADE.SCORE AS GRADE,
    CASE 
        WHEN GRADE.SCORE ='S' THEN EMP.SAL*0.2
        WHEN GRADE.SCORE ='A' THEN EMP.SAL*0.15
        WHEN GRADE.SCORE ='B' THEN EMP.SAL*0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES EMP 
        JOIN (SELECT EMP_NO,
                    CASE 
                        WHEN AVG(SCORE) >=96 THEN 'S'
                        WHEN AVG(SCORE) >=90 THEN 'A'
                        WHEN AVG(SCORE) >=80 THEN 'B'
                        ELSE 'C'
                    END AS SCORE
               FROM HR_GRADE
               GROUP BY EMP_NO
               ) AS GRADE
       ON EMP.EMP_NO = GRADE.EMP_NO
ORDER BY 1
;