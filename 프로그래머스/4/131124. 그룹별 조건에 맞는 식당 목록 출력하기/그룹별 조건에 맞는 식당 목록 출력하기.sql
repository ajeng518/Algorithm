SELECT P.MEMBER_NAME,
        R.REVIEW_TEXT,
        DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R JOIN MEMBER_PROFILE P
    ON R.MEMBER_ID = P.MEMBER_ID
WHERE R.MEMBER_ID IN (SELECT RR.MEMBER_ID
                      FROM REST_REVIEW RR
                      GROUP BY RR.MEMBER_ID
                      HAVING COUNT(*) = (SELECT MAX(TT.REVIEW_COUNT)
                                                    FROM (SELECT COUNT(RE.MEMBER_ID) AS REVIEW_COUNT
                                                          FROM REST_REVIEW RE
                                                          GROUP BY RE.MEMBER_ID) AS TT
                                                   )
                        )
ORDER BY 3 ASC, 2 ASC

# -- 코드를 입력하세요
# SELECT MP.MEMBER_NAME,
#         RR.REVIEW_TEXT,
#         DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
# FROM REST_REVIEW RR 
#     JOIN MEMBER_PROFILE MP 
#     ON RR.MEMBER_ID = MP.MEMBER_ID
# WHERE RR.MEMBER_ID 
#     IN (SELECT MEMBER_ID
#         FROM REST_REVIEW
#        GROUP BY MEMBER_ID
#        HAVING COUNT(*) = (SELECT MAX(REVIEW_COUNT)
#                           FROM (SELECT COUNT(MEMBER_ID) AS REVIEW_COUNT
#                                 FROM REST_REVIEW
#                                 GROUP BY MEMBER_ID
#                           )AS COUNT_TABLE
#                         )
#       )
# ORDER BY 3 ASC, 2 ASC