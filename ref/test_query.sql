-- 공통 쿼리 가져오는 쿼리 문
SELECT * FROM
  (select @rownum:=@rownum+1 as rowNum ,t.*
     from (SELECT *
              FROM sangsang.SS_MUSEUM
              WHERE 1=1
                AND (CONTACT LIKE '032%' AND HOMEPAGE LIKE 'http%')
           ) t,
       (SELECT @rownum:=0) TMP) t