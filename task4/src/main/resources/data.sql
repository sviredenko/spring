insert into AUTHORS ( id, author) values (1, 'Selenger');
insert into GENRES (id, genre) values (1, 'comedy');
insert into BOOKS ( id, book) values (1, 'The Catcher in the Rye');
insert into BOOK_AUTHOR(book_Id, author_Id ) values(1,1);
insert into BOOK_GENRE(book_Id, genre_Id ) values(1,1);
insert into COMMENTS(id, comment, book_Id) values(1,'nice',1);
