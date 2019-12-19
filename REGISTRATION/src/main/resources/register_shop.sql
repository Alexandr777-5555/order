DROP TABLE IF EXISTS reg_shop;
DROP TABLE IF EXISTS Address;

CREATE TABLE reg_shop(

 shop_id SERIAL ,
 shop_name varchar (100)  not null ,
 shop_date_create date not null ,
 shop_inn integer not null ,
 PRIMARY KEY (shop_id)

)




CREATE TABLE  Address(

 address_id SERIAL ,
 shop_id integer not null ,
 address_street varchar (100)  not null ,
 address_number varchar (5)  not null ,
 PRIMARY KEY (address_id),
 FOREIGN KEY (shop_id) REFERENCES reg_shop(shop_id) ON DELETE RESTRICT



)

