CREATE TABLE product(
    id bigint NOT NULL auto_increment,
    name varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    price DECIMAL(10,2),
    available TINYINT,

    primary key(id)
);