CREATE TABLE account(
    id bigint NOT NULL auto_increment,
    mail varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    role varchar(20) NOT NULL,

    name varchar(50) NOT NULL,
    maternal_sur_Name varchar(50) NOT NULL,
    paternal_sur_name varchar(50) NOT NULL,
    address varchar(75) NOT NULL,
    phone_number varchar(10) NOT NULL,
    birthday date NOT NULL,

    primary key(id)


);
