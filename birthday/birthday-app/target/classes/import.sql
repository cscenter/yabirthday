

----------------
insert into "group"(id, name) values('1', 'students');
insert into "group"(id, name) values('2', 'curators');
insert into "group"(id, name) values('3', 'teachers');

----------------
insert into "cash"(id) values('42');
insert into "cash"(id) values('12');


--insert into "user"(login, birthday) values('user', '2000-01-01');
--Yulya Chernobay 13 Jan 1993
insert into "user"(login, birthday, cash_id, group_id) values('chernobay',   '1993-01-13', '12', '1');
--Olya Telezhnaya November 18, 1993
insert into "user"(login, birthday, cash_id, group_id) values('telezhnaya',  '1993-11-18', '12', '1');
-- Sergey Romanov March 18 1989
insert into "user"(login, birthday, cash_id, group_id) values('romanov',     '1989-03-18', '12', '1');
--Sergey Kopeliovich February 22, 1989
insert into "user"(login, birthday, cash_id, group_id) values('kopeliovich', '1989-02-22', '12', '3');
--Anya Atamanova  June 14 1993
insert into "user"(login, birthday, cash_id, group_id) values('atamanova',   '1993-06-15', '12', '1');
--Arsen Khazhoyan August 3, 1995
insert into "user"(login, birthday, cash_id, group_id) values('khazhoyan',   '1995-08-03', '12', '1');
--Alexander Yanenko October 16, 1995
insert into "user"(login, birthday, cash_id, group_id) values('yanenko',     '1995-10-16', '12', '1');
-- Misha Veselov November 26, 1984
insert into "user"(login, birthday, cash_id, group_id) values('veselov',     '1984-10-26', '12', '1');
-- Vanya Igorevich Afonichkin April 12, 1995
insert into "user"(login, birthday, cash_id, group_id) values('afonichkin',  '1995-04-12', '42', '1');
--Zhenya Kulikova July 14 1993
insert into "user"(login, birthday, cash_id, group_id) values('kulikova',    '1993-07-14', '42', '2');
-- Artyom Grigoryev April 16, 1991
insert into "user"(login, birthday, cash_id, group_id) values('grigoryev',   '1991-04-16', '42', '3');
-- Katya Lebedeva July 30, 1992
insert into "user"(login, birthday, cash_id, group_id) values('lebedeva',    '1992-07-30', '42', '2');
--Alexander Knop
insert into "user"(login, birthday, cash_id, group_id) values('knop',        '1991-02-02', '42', '3');
-- Alexander Smal April 20, 1985
insert into "user"(login, birthday, cash_id, group_id) values('smal',        '1985-04-20', '42', '3');
-- Sasha Kulikov
insert into "user"(login, birthday, cash_id, group_id) values('kulikov',     '1985-02-02', '42', '3');
-- Sergey Kiselev July 9, 1983
insert into "user"(login, birthday, cash_id, group_id) values('kiselev',     '1983-07-09', '42', '3');


----------------
update "cash" set owner_login='kulikov' where id = '42'
update "cash" set owner_login='smal' where id = '12'


----------------
insert into "gift"(id , name, owned, price, owner_login) values('1', 'book',          'true',  '1500',   'kulikov' );
insert into "gift"(id , name, owned, price, owner_login) values('2', 'diser',         'false', '10000',  'romanov' );
insert into "gift"(id , name, owned, price, owner_login) values('3', 'minions',       'false', '00' ,    'kopeliovich' );
insert into "gift"(id , name, owned, price, owner_login) values('4', 'good_students', 'false', '100500', 'kiselev' );
insert into "gift"(id , name, owned, price, owner_login) values('5', 'macbook',       'true',  '150000', 'khazhoyan' );
insert into "gift"(id , name, owned, price, owner_login) values('6', 'phone',         'false', '600',    'telezhnaya' );
insert into "gift"(id , name, owned, price, owner_login) values('7', 'shower',        'false', '20000',  'chernobay' );
insert into "gift"(id , name, owned, price, owner_login) values('8', 'bicycle',       'false', '15000',  'lebedeva' );


----------------
insert into "account"(id , funds, cash_id, owner_login) values('1', '4000', '42' ,'kulikova' );
insert into "account"(id , funds, cash_id, owner_login) values('2', '9900', '12' ,'lebedeva' );
insert into "account"(id , funds, cash_id, owner_login) values('3', '1000', '12' ,'veselov' );
insert into "account"(id , funds, cash_id, owner_login) values('4', '600', '12' ,'knop' );
insert into "account"(id , funds, cash_id, owner_login) values('5', '1200', '12' ,'afonichkin' );
insert into "account"(id , funds, cash_id, owner_login) values('6', '2000', '12' ,'romanov' );
insert into "account"(id , funds, cash_id, owner_login) values('7', '100', '42' ,'chernobay' );
insert into "account"(id , funds, cash_id, owner_login) values('8', '5000', '42' ,'kiselev' );
insert into "account"(id , funds, cash_id, owner_login) values('9', '500', '42' ,'khazhoyan' );
insert into "account"(id , funds, cash_id, owner_login) values('10', '8000', '42' ,'lebedeva' );
insert into "account"(id , funds, cash_id, owner_login) values('11', '1000', '42' ,'veselov' );

----------------
insert into "gift_investor"(gift_id, account_id) values('2', '1');

----------------
insert into "transaction"(id, date, sum, account_id, destination_id) values('1', '1995-04-12', '200', '1', '1');
insert into "transaction"(id, date, sum, account_id, destination_id) values('2', '2000-04-12', '600', '2', '1');


----------------
insert into "account_receiver"(source_id, destination_id) values( '1' , '2');
insert into "account_receiver"(source_id, destination_id) values( '2' , '1');

