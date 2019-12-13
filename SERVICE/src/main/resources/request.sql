SELECT * FROM  stock st
                   INNER JOIN price_and_title_product patp on patp.product_id=st.product_id
WHERE
        st.product_id='1' and st.product_count>'76' and UPPER (st.title) = UPPER ('молоко')




SELECT * FROM  stock st
                   INNER JOIN price_and_title_product patp on patp.product_id=st.product_id
WHERE
    st.product_id=? and st.product_count>=? and UPPER (st.title) = UPPER (?)




// ЗАПРОС

SELECT * FROM  stock st
                   INNER JOIN price_and_title_product patp on patp.product_id=st.product_id
WHERE
    st.product_id=? and st.product_count>=? 