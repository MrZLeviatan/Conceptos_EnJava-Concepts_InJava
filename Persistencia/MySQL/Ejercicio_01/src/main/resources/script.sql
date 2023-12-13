use bdEjercicio_01;

create table users(
  id int auto_increment primary key,
  FirstName varchar(20) not null,
  LastName varchar(20) not null,
  Phone varchar(20) not null,
  Gender varchar(20) not null,

);

insert into users(FIRSTNAME, LASTNAME, PHONE, GENDER) values ("Nicolas","CAbrera","3054819209","Male")