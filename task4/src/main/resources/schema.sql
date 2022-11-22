create table BOOKS(
    id bigint NOT NULL AUTO_INCREMENT ,
    book varchar(8000),
    primary key (id)
);

create table AUTHORS(
    id bigint  NOT NULL AUTO_INCREMENT,
    author varchar(255),
    primary key (id)
);
create table COMMENTS(
    id bigint  NOT NULL AUTO_INCREMENT,
    comment varchar(255),
    book_id bigint references BOOKS(id) on delete cascade,
    primary key(id)
);

create table GENRES(
    id bigint NOT NULL AUTO_INCREMENT ,
    genre varchar(255),
    primary key (id)
);


create table book_author(
    book_id bigint  references BOOKS(id) on update cascade,
    author_id bigint  references AUTHORS(id),
    primary key (book_id, author_id)
);

create table book_genre(
    book_id bigint  references BOOKS(id) on update cascade,
    genre_id bigint references GENRES(id),
    primary key (book_id, genre_id)
);