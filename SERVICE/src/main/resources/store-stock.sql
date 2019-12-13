

delete from stock;
delete from price_and_title_product;

drop table if exists  stock;
drop table if exists price_and_title_product;




CREATE TABLE price_and_title_product(

 id_price_product SERIAL,
 price money not null ,
 product_id int not null ,
 start_date date not null ,
 PRiMARY KEY (id_price_product)
);


CREATE TABLE stock(

 num_id SERIAL,
 product_id int not null,
 title varchar(100) not null,
 product_count int not null,
 price money not null ,
 PRiMARY KEY (product_id),
 FOREIGN KEY (product_id) REFERENCES  price_and_title_product(id_price_product) ON DELETE RESTRICT
) ;

INSERT  INTO price_and_title_product (id_price_product, price, product_id, start_date) VALUES
(1, 25.08 , 1 , '2019-11-02' ),
(2, 35.03 , 2 , '2019-11-02' );




INSERT INTO stock (num_id, product_id, title, product_count, price) VALUES
(1 , 1, 'молоко' , 77 , 25.08),
(2 , 2, 'ряженка' , 55 , 35.03);












