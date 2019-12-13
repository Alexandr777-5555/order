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



INSERT INTO assortment (namepr, unic)
VALUES ('moloko', 1),
       ('мороженное', 2),
       ('кефир', 3),
       ('печенье', 4),
       ('хлеб', 5),
       ('сушки', 6),
       ('лимонад', 7);



INSERT INTO shop (id_shop, name_shop)
VALUES (1, 'магнит'),
       (2, 'ашан'),
       (3, 'мария ра'),
       (4, 'пяторочка'),
       (5, 'питер'),
       (6, 'у дома'),
       (7, 'заправка');


INSERT INTO product(order_id, id_product , product_count)
VALUES (1, 1 , 18),
       (1, 2 , 18),
       (1, 3 , 18);

INSERT INTO orderproduct(id_order, order_shop, order_date, order_time, order_status)
VALUES (1, 1, '2019-11-02', '2019-11-26 15:20:09.651', 0);


