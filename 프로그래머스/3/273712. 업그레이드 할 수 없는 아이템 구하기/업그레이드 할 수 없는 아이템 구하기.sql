-- 코드를 작성해주세요
SELECT INFO.ITEM_ID,
        INFO.ITEM_NAME,
        INFO.RARITY
FROM ITEM_INFO INFO
WHERE INFO.ITEM_ID NOT IN (SELECT A.ITEM_ID
                           FROM ITEM_TREE A JOIN ITEM_TREE B
                                ON A.ITEM_ID = B.PARENT_ITEM_ID
                        )
ORDER BY 1 DESC
;