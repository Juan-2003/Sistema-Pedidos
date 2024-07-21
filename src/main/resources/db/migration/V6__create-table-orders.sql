CREATE TABLE orders(
   id bigint NOT NULL auto_increment,
   order_number varchar(20) NOT NULL,
   total_price DECIMAL(10,2) NOT NULL,
   order_status TINYINT NOT NULL,
   client_id bigint NOT NULL,
   deliveryman_id bigint NOT NULL,

   primary key(id),
   foreign key(client_id) REFERENCES client(id),
   foreign key(deliveryman_id) REFERENCES deliveryman(id)
);
