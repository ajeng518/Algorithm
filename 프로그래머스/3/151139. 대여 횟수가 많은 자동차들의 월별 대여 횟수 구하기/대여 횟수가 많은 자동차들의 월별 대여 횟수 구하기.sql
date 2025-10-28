# -- 코드를 입력하세요
SELECT MONTH(A.START_DATE) AS MONTH,
        A.CAR_ID,
        COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
WHERE A.CAR_ID IN (SELECT B.CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B
                    WHERE B.START_DATE >= '2022-08-01' AND B.START_DATE < '2022-11-01'
                    GROUP BY B.CAR_ID
                    HAVING COUNT(*) > 4     
                )
    AND (A.START_DATE >= '2022-08-01' AND A.START_DATE < '2022-11-01')
GROUP BY MONTH(A.START_DATE), A.CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH ASC, A.CAR_ID DESC                                  
;

                
    