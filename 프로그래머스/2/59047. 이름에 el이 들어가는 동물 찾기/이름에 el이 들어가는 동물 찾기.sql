SELECT ANIMAL_ID,
        NAME
FROM ANIMAL_INS
WHERE NAME LIKE "%EL%"
        AND ANIMAL_TYPE = 'Dog'
ORDER BY 2
;












# SELECT ANIMAL_ID, NAME
# FROM ANIMAL_INS
# WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE '%EL%'
# ORDER BY NAME ASC
# ;