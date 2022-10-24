create table BOOKS(
    id bigserial,
    book varchar(8000),
    primary key (id)
);

create table AUTHORS(
    id bigserial,
    author varchar(255),
    primary key (id)
);

create table GENRES(
    id bigserial,
    genre varchar(255),
    primary key (id)
);


create table book_author(
    book_id bigint references BOOKS(id) on delete cascade,
    author_id bigint references AUTHORS(id),
    primary key (book_id, author_id)
);

create table book_genre(
    book_id bigint references BOOKS(id) on delete cascade,
    genre_id bigint references GENRES(id),
    primary key (book_id, genre_id)
);