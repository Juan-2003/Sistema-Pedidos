CREATE TABLE client(
  id bigint NOT NULL auto_increment,
  account_id bigint NOT NULL,

  primary key(id),
  foreign key(account_id) REFERENCES account(id)

);