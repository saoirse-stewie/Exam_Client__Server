use address;

drop table if exists person;

create table person(

  firstname VARCHAR(30)  DEFAULT 'harry',
  lastname VARCHAR(30)   DEFAULT 'sally',
  id int AUTO_INCREMENT ,
  id_NUMBER VARCHAR(30)  DEFAULT '0',
  emailaddress VARCHAR(30)  DEFAULT 'here@gmit.ie',
  phone VARCHAR(30)  DEFAULT '0',
  comment VARCHAR(1000),
   primary key (id));

