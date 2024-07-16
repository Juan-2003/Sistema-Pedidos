CREATE TABLE deliveryman(
    id bigint NOT NULL auto_increment,
    name varchar(50) NOT NULL,
    maternalSurName varchar(50) NOT NULL,
    paternalSurName varchar(50) NOT NULL,
    address varchar(150) NOT NULL,
    phoneNumber varchar(10) NOT NULL,
    birthday DATE NOT NULL,
    account_id bigint NOT NULL,
    vehicle_data_id bigint NOT NULL,

    primary key(id),
    foreign key(account_id) REFERENCES account(id),
    foreign key(vehicle_data_id) REFERENCES vehicle_data(id)

);
