drop table if exists cat;
drop table if exists cart;

create table cat(
    id int identity ,
    name varchar (20),
    gender varchar (20),
    longHaired number (1),
    roundFace number (1),
    lively number (1),
    picPath varchar (40),
    thPicPath varchar (40));

create table cart(
    catId int
);

insert into cat (id, name, gender, longHaired, roundFace, lively, picPath, thPicPath
) values (1, 'Lucy', 'female', 1, 0, 0, '../static/images/cat1.jpeg', 'images/cat1.jpeg');

insert into cat (id, name, gender, longHaired, roundFace, lively, picPath, thPicPath
) values (2, 'Amy', 'female', 1, 1, 1, '../static/images/cat2.jpeg', 'images/cat2.jpeg');

insert into cat (id, name, gender, longHaired, roundFace, lively, picPath, thPicPath
) values (3, 'Zoey', 'male', 1, 1, 1, '../static/images/cat3.jpeg', 'images/cat3.jpeg');

insert into cat (id, name, gender, longHaired, roundFace, lively, picPath, thPicPath
) values (4, 'Locus', 'male', 1, 1, 0, '../static/images/cat4.jpeg', 'images/cat4.jpeg');

