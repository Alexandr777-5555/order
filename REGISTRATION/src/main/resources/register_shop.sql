DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS reg_certificate;
DROP TABLE IF EXISTS reg_shop;


CREATE TABLE reg_shop(

 shop_id SERIAL ,
 uid smallint not null ,
 shop_name varchar (100)  not null ,
 shop_date_create date not null ,
 shop_inn integer not null ,
 PRIMARY KEY (shop_id)

);





CREATE TABLE  Address(
 address_id SERIAL ,
 shop_id integer not null ,
 address_street varchar (100)  not null ,
 address_number varchar (5)  not null ,
 PRIMARY KEY (address_id),
 FOREIGN KEY (shop_id) REFERENCES reg_shop(shop_id) ON DELETE RESTRICT

);



CREATE TABLE reg_certificate(

certificate_id SERIAL ,
number varchar (100)  not null ,
reg_date  date not null ,
shop_id integer not null ,
active boolean DEFAULT false ,
PRIMARY KEY (certificate_id),
FOREIGN KEY (shop_id) REFERENCES reg_shop(shop_id) ON DELETE RESTRICT
);

INSERT INTO reg_shop (uid, shop_name, shop_date_create, shop_inn)  values
(1, 'Подкова', '1988-07-26' , 22260458),
(2, 'Магнит', '2000-08-21' , 22260459);



INSERT INTO Address(shop_id, address_street, address_number) VALUES

(2 , 'Малахова' , 99);



