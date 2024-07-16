CREATE TABLE vehicle_data(
  id bigint NOT NULL auto_increment,
  vehicleType varchar(20) NOT NULL,
  plates varchar(10) NOT NULL,

  primary key(id)
);