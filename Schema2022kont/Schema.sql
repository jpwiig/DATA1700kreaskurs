create table lager (
  LID integer auto_increment not null primary key,
  NAVN varchar(350) not null,
  adrese varchar(350) not null,
);
create table pakke(
    pid integer auto_increment not null primary key,
    lid integer,
    eier varchar(350),
    vekt decimal(8,2),
    volum decimal(8,2),
    foreign key (lid) references lager(LID)
);
create table bruker(
    bid integer auto_increment primary key ,
    navn varchar(350),
    passord varchar(350)
)