CREATE TABLE deliveryman(
    id bigint NOT NULL auto_increment,
    account_id bigint NOT NULL,
    vehicle_data_id bigint NOT NULL,

    primary key(id),
    foreign key(account_id) REFERENCES account(id),
    foreign key(vehicle_data_id) REFERENCES vehicle_data(id)
);
