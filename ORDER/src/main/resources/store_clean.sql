delete from product;
delete from orderproduct;

drop table product;
drop table orderproduct;
drop table shop;
drop table assortment;



CREATE table assortment
(
    namepr varchar(100),
    unic   int not null,
    PRiMARY KEY (unic)
);



CREATE table shop
(
    name_shop varchar(100),
    id_shop   int not null,
    PRiMARY KEY (id_shop)

);


CREATE table product
(
    product_num SERIAL,
    order_id    int,
    product_count int,
    id_product  int not null
);

CREATE table orderproduct
(
    id_order      SERIAL,
    order_shop    int,
    order_date    date      not null,
    order_time    timestamp not null,
    order_status  int,
    FOREIGN KEY (order_shop) REFERENCES shop (id_shop) ON DELETE RESTRICT,
    PRiMARY KEY (id_order)
);

INSERT INTO shop (id_shop, name_shop)
VALUES (1, 'магнит'),
       (2, 'ашан'),
       (3, 'мария ра'),
       (4, 'пяторочка'),
       (5, 'питер'),
       (6, 'у дома'),
       (7, 'заправка');