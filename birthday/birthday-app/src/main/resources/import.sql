
----------------

insert into "group"(id, name) values('1', 'students');
insert into "group"(id, name) values('2', 'curators');
insert into "group"(id, name) values('3', 'teachers');

----------------
insert into "cash"(id) values('42');
insert into "cash"(id) values('12');


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
insert into "gift"(id , name, owned, price, owner_login) values('7', 'shower',        'false', '120',    'chernobay' );
insert into "gift"(id , name, owned, price, owner_login) values('8', 'bicycle',       'false', '15000',  'lebedeva' );



----------------
insert into "account"(id , funds, cash_id, owner_login) values('1',  '4000', '42', 'kulikova' );

insert into "account"(id , funds, cash_id, owner_login) values('2',  '9900', '12', 'lebedeva' );
insert into "account"(id , funds, cash_id, owner_login) values('3',  '1000', '12', 'veselov' );
insert into "account"(id , funds, cash_id, owner_login) values('4',  '600',  '12', 'knop' );
insert into "account"(id , funds, cash_id, owner_login) values('5',  '1200', '12', 'afonichkin' );
insert into "account"(id , funds, cash_id, owner_login) values('6',  '2000', '12', 'romanov' );

insert into "account"(id , funds, cash_id, owner_login) values('7',  '100',  '42', 'chernobay' );
insert into "account"(id , funds, cash_id, owner_login) values('8',  '5000', '42', 'kiselev' );
insert into "account"(id , funds, cash_id, owner_login) values('9',  '500',  '42', 'khazhoyan' );
insert into "account"(id , funds, cash_id, owner_login) values('10', '8000', '42', 'lebedeva' );
insert into "account"(id , funds, cash_id, owner_login) values('11', '1000', '42', 'veselov' );
insert into "account"(id , funds, cash_id, owner_login) values('12', '500',  '42', 'telezhnaya' );
insert into "account"(id , funds, cash_id, owner_login) values('13', '4000', '42', 'kulikov' );

insert into "account"(id , funds, cash_id, owner_login) values('14', '1500',  '12', 'telezhnaya' );

----------------
insert into "account_receiver"(account_id, receiver_id) values( '3',   '6');  --- Миша может дарить Сереге
insert into "account_receiver"(account_id, receiver_id) values( '3',   '2');  --- Миша может дарить Кате
insert into "account_receiver"(account_id, receiver_id) values( '2',   '6');  --- Катя может дарить Сереге
insert into "account_receiver"(account_id, receiver_id) values( '4',   '2');  --- Кноп может дарить Кате
insert into "account_receiver"(account_id, receiver_id) values( '5',   '2');  --- Ваня может дарить Кате
insert into "account_receiver"(account_id, receiver_id) values( '7',   '1');
insert into "account_receiver"(account_id, receiver_id) values( '8',   '1');
insert into "account_receiver"(account_id, receiver_id) values( '9',   '1');
insert into "account_receiver"(account_id, receiver_id) values( '11',  '1');
insert into "account_receiver"(account_id, receiver_id) values( '4',   '3');
insert into "account_receiver"(account_id, receiver_id) values( '5',   '3');
insert into "account_receiver"(account_id, receiver_id) values( '6',   '3');
insert into "account_receiver"(account_id, receiver_id) values( '4',   '4');
insert into "account_receiver"(account_id, receiver_id) values( '5',   '6');  --- Ваня может дарить Сереге
insert into "account_receiver"(account_id, receiver_id) values( '12',  '7');  --- Оля может дарить Юле
insert into "account_receiver"(account_id, receiver_id) values( '12',  '11'); --- Оля может дарить Мише (Миша в обоих кассах)
insert into "account_receiver"(account_id, receiver_id) values( '12',  '13'); --- Оля может дарить Саше
insert into "account_receiver"(account_id, receiver_id) values( '11',  '13'); --- Миша может дарить Саше
insert into "account_receiver"(account_id, receiver_id) values( '9',   '13'); --- Арсен может дарить Саше
insert into "account_receiver"(account_id, receiver_id) values( '1',   '13'); --- Женя может дарить Саше
insert into "account_receiver"(account_id, receiver_id) values( '8',   '13'); --- Сергей может дарить Саше

----------------
insert into "gift_investor"(gift_id, investor_id) values('2', '3'); -- Миша дарит дисер
insert into "gift_investor"(gift_id, investor_id) values('2', '5'); -- Ваня дарит дисер
insert into "gift_investor"(gift_id, investor_id) values('2', '2'); -- Катя дарит дисер

insert into "gift_investor"(gift_id, investor_id) values('8', '3'); -- Миша дарит велик
insert into "gift_investor"(gift_id, investor_id) values('8', '4'); -- Кноп дарит велик
insert into "gift_investor"(gift_id, investor_id) values('8', '5'); -- Ваня дарит велик

insert into "gift_investor"(gift_id, investor_id) values('7', '12'); -- Оля дарит шампунь

insert into "gift_investor"(gift_id, investor_id) values('1', '12'); -- Оля дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1', '11'); -- Миша дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '9'); -- Арсен дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '1'); -- Женя дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '8'); -- Сергей дарит книгу

----------------
insert into "transaction"(id, date, sum, account_id, destination_id) values('1',  '2000-04-12', '4000', '3',  '2'); -- Миша скинулся на дисер Сереге
insert into "transaction"(id, date, sum, account_id, destination_id) values('2',  '2000-04-13', '4000', '5',  '2'); -- Ваня скинулся на дисер Сереге
insert into "transaction"(id, date, sum, account_id, destination_id) values('3',  '2000-04-15', '2000', '2',  '2'); -- Катя скинулась на дисер Сереге

insert into "transaction"(id, date, sum, account_id, destination_id) values('4',  '2000-05-08', '5000', '3',  '8'); -- Миша скинулся на велик Кате
insert into "transaction"(id, date, sum, account_id, destination_id) values('5',  '2000-05-02', '5000', '4',  '8'); -- Кноп скинулся на велик Кате
insert into "transaction"(id, date, sum, account_id, destination_id) values('6',  '2000-05-10', '5000', '5',  '8'); -- Ваня скинулся на велик Кате

insert into "transaction"(id, date, sum, account_id, destination_id) values('7',  '2000-05-28', '120',  '12', '7'); -- Оля скинулась на шампунь Юле

insert into "transaction"(id, date, sum, account_id, destination_id) values('8',  '2000-05-11', '300',  '8',  '1'); -- Сергей скинулся на книгу Саше
insert into "transaction"(id, date, sum, account_id, destination_id) values('9',  '2000-05-14', '300',  '12', '1'); -- Оля скинулась на книгу Саше
insert into "transaction"(id, date, sum, account_id, destination_id) values('10', '2000-05-12', '300',  '11', '1'); -- Миша скинулся на книгу Саше
insert into "transaction"(id, date, sum, account_id, destination_id) values('11', '2000-05-13', '300',  '9',  '1'); -- Арсен скинулся на книгу Саше
insert into "transaction"(id, date, sum, account_id, destination_id) values('12', '2000-05-14', '300',  '1',  '1'); -- Женя скинулась на книгу Саше
