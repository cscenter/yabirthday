--insert into "user"(login, birthday) values('user', '2000-01-01');
--Yulya Chernobay 13 Jan 1993
insert into "user"(login, birthday) values('chernobay', '1993-01-13');
--Olya Telezhnaya November 18, 1993
insert into "user"(login, birthday) values('telezhnaya', '1993-11-18');
-- Sergey Romanov March 18 1989
insert into "user"(login, birthday) values('romanov', '1989-03-18');
--Sergey Kopeliovich February 22, 1989
insert into "user"(login, birthday) values('kopeliovich', '1989-02-22');
--Anya Atamanova  June 14 1993
insert into "user"(login, birthday) values('atamanova', '1993-06-15');
--Arsen Khazhoyan August 3, 1995
insert into "user"(login, birthday) values('khazhoyan', '1995-08-03');
--Alexander Yanenko October 16, 1995
insert into "user"(login, birthday) values('yanenko', '1995-10-16');
-- Misha Veselov November 26, 1984
insert into "user"(login, birthday) values('veselov', '1984-10-26');
-- Vanya Igorevich Afonichkin April 12, 1995
insert into "user"(login, birthday) values('afonichkin', '1995-04-12');
--Zhenya Kulikova July 14 1993
insert into "user"(login, birthday) values('kulikova', '1993-07-14');
-- Artyom Grigoryev April 16, 1991
insert into "user"(login, birthday) values('grigoryev', '1991-04-16');
-- Katya Lebedeva July 30, 1992
insert into "user"(login, birthday) values('lebedeva', '1992-07-30');
--Alexander Knop
insert into "user"(login, birthday) values('knop', '1991-02-02');
-- Alexander Smal April 20, 1985
insert into "user"(login, birthday) values('smal', '1985-04-20');
-- Sasha Kulikov
insert into "user"(login, birthday) values('kulikov', '1985-02-02');
-- Sergey Kiselev July 9, 1983
insert into "user"(login, birthday) values('kiselev', '1983-07-09');


insert into "group"(name) values('students');
insert into "group_users"(group_name ,  users_login) values('students', 'chernobay' );
insert into "group_users"(group_name ,  users_login) values('students', 'telezhnaya' );
insert into "group_users"(group_name ,  users_login) values('students', 'romanov' );
insert into "group_users"(group_name ,  users_login) values('students', 'atamanova' );
insert into "group_users"(group_name ,  users_login) values('students', 'yanenko' );
insert into "group_users"(group_name ,  users_login) values('students', 'afonichkin' );
insert into "group_users"(group_name ,  users_login) values('students', 'khazhoyan' );

----------------
insert into "group"(name) values('curators');
insert into "group_users"(group_name ,  users_login) values('curators', 'kulikova' );
insert into "group_users"(group_name ,  users_login) values('curators', 'lebedeva' );

----------------
insert into "group"(name) values('teachers');
insert into "group_users"(group_name ,  users_login) values('teachers', 'kopeliovich' );
insert into "group_users"(group_name ,  users_login) values('teachers', 'grigoryev' );;
insert into "group_users"(group_name ,  users_login) values('teachers', 'knop' );;
insert into "group_users"(group_name ,  users_login) values('teachers', 'kiselev' );;
insert into "group_users"(group_name ,  users_login) values('teachers', 'smal' );
insert into "group_users"(group_name ,  users_login) values('teachers', 'kulikov' );

----------------
insert into "cash"(id ,  owner_login) values('42', 'kulikov' );
insert into "cash"(id ,  owner_login) values('12', 'smal' );

----------------
insert into "gift"(id , name, owned, price, owner_login) values('1', 'book',     'true',  '1500',  'kulikov' );
insert into "gift"(id , name, owned, price, owner_login) values('2', 'diser',    'false', '10000', 'romanov' );
insert into "gift"(id , name, owned, price, owner_login) values('3', 'minions',  'false', '00' ,   'kopeliovich' );
insert into "gift"(id , name, owned, price, owner_login) values('4', 'water',    'false', '35',    'kiselev' );
insert into "gift"(id , name, owned, price, owner_login) values('5', 'macbook',  'true',  '150000','khazhoyan' );
insert into "gift"(id , name, owned, price, owner_login) values('6', 'phone',    'false', '600',   'telezhnaya' );
insert into "gift"(id , name, owned, price, owner_login) values('7', 'iphone',   'false', '20000', 'chernobay' );
insert into "gift"(id , name, owned, price, owner_login) values('8', 'bicycle',  'false', '15000', 'lebedeva' );
--insert into "gift"(id , name, owned, price, owner_login) values('1', 'book', 'FALSE', '1500' ,'kulikov' );
--insert into "gift"(id , name, owned, price, owner_login) values('1', 'book', 'FALSE', '1500' ,'kulikov' );

----------------
insert into "account"(id , funds, cash_id, owner_login) values('1', '4000', '42' ,'kulikova' );
insert into "account"(id , funds, cash_id, owner_login) values('2', '9900', '12' ,'lebedeva' );

----------------
-- insert into "gift"(id , name, owned, price, owner_login) values('1', 'book', 'FALSE', '1500' ,'kulikov' );

