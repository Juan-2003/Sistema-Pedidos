CREATE TABLE product_order(
  id bigint NOT NULL auto_increment,
  product_id bigint NOT NULL,
  order_id bigint NOT NULL,

  primary key(id),
  foreign key(product_id) REFERENCES product(id),
  foreign key(order_id) REFERENCES orders(id)
);
