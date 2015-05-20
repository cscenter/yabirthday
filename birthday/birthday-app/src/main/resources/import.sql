
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
insert into "account"(id , funds, cash_id, owner_login) values('11', '700',  '42', 'veselov' );
insert into "account"(id , funds, cash_id, owner_login) values('12', '500',  '42', 'telezhnaya' );
insert into "account"(id , funds, cash_id, owner_login) values('13', '4000', '42', 'kulikov' );

insert into "account"(id , funds, cash_id, owner_login) values('14', '1500',  '12', 'telezhnaya' );

---------------- // вместо имени поставить логин
insert into "account_friends"(account_id, friends_login) values( '3',   'romanov');  --- ћиша может дарить —ереге
insert into "account_friends"(account_id, friends_login) values( '3',   'lebedeva');  --- ћиша может дарить  ате
insert into "account_friends"(account_id, friends_login) values( '2',   'romanov');  ---  ат€ может дарить —ереге
insert into "account_friends"(account_id, friends_login) values( '4',   'lebedeva');  ---  ноп может дарить  ате
insert into "account_friends"(account_id, friends_login) values( '5',   'lebedeva');  --- ¬ан€ может дарить  ате
insert into "account_friends"(account_id, friends_login) values( '7',   'kulikova');
insert into "account_friends"(account_id, friends_login) values( '8',   'kulikova');
insert into "account_friends"(account_id, friends_login) values( '9',   'kulikova');
insert into "account_friends"(account_id, friends_login) values( '11',  'kulikova');
insert into "account_friends"(account_id, friends_login) values( '4',   'veselov');
insert into "account_friends"(account_id, friends_login) values( '5',   'veselov');
insert into "account_friends"(account_id, friends_login) values( '6',   'veselov');
insert into "account_friends"(account_id, friends_login) values( '4',   'knop');
insert into "account_friends"(account_id, friends_login) values( '5',   'romanov');  --- ¬ан€ может дарить —ереге
insert into "account_friends"(account_id, friends_login) values( '12',  'chernobay');  --- ќл€ может дарить ёле
insert into "account_friends"(account_id, friends_login) values( '12',  'veselov'); --- ќл€ может дарить ћише (ћиша в обоих кассах)
insert into "account_friends"(account_id, friends_login) values( '12',  'kulikov'); --- ќл€ может дарить —аше
insert into "account_friends"(account_id, friends_login) values( '11',  'kulikov'); --- ћиша может дарить —аше
insert into "account_friends"(account_id, friends_login) values( '9',   'kulikov'); --- јрсен может дарить —аше
insert into "account_friends"(account_id, friends_login) values( '1',   'kulikov'); --- ∆ен€ может дарить —аше
insert into "account_friends"(account_id, friends_login) values( '8',   'kulikov'); --- —ергей может дарить —аше

----------------
insert into "gift_investor"(gift_id, investor_id) values('2', '3'); -- ћиша дарит дисер
insert into "gift_investor"(gift_id, investor_id) values('2', '5'); -- ¬ан€ дарит дисер
insert into "gift_investor"(gift_id, investor_id) values('2', '2'); --  ат€ дарит дисер

insert into "gift_investor"(gift_id, investor_id) values('8', '3'); -- ћиша дарит велик
insert into "gift_investor"(gift_id, investor_id) values('8', '4'); --  ноп дарит велик
insert into "gift_investor"(gift_id, investor_id) values('8', '5'); -- ¬ан€ дарит велик

insert into "gift_investor"(gift_id, investor_id) values('7', '12'); -- ќл€ дарит шампунь

insert into "gift_investor"(gift_id, investor_id) values('1', '12'); -- ќл€ дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1', '11'); -- ћиша дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '9'); -- јрсен дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '1'); -- ∆ен€ дарит книгу
insert into "gift_investor"(gift_id, investor_id) values('1',  '8'); -- —ергей дарит книгу

----------------
insert into "transaction"(id, date, sum, account_id, destination_id) values('1',  '2000-04-12', '-4000', '3',  '2'); -- ћиша скинулс€ на дисер —ереге
insert into "transaction"(id, date, sum, account_id, destination_id) values('2',  '2000-04-13', '-4000', '5',  '2'); -- ¬ан€ скинулс€ на дисер —ереге
insert into "transaction"(id, date, sum, account_id, destination_id) values('3',  '2000-04-15', '-2000', '2',  '2'); --  ат€ скинулась на дисер —ереге

insert into "transaction"(id, date, sum, account_id, destination_id) values('4',  '2000-05-08', '-5000', '3',  '8'); -- ћиша скинулс€ на велик  ате
insert into "transaction"(id, date, sum, account_id, destination_id) values('5',  '2000-05-02', '-5000', '4',  '8'); --  ноп скинулс€ на велик  ате
insert into "transaction"(id, date, sum, account_id, destination_id) values('6',  '2000-05-10', '-5000', '5',  '8'); -- ¬ан€ скинулс€ на велик  ате


insert into "transaction"(id, date, sum, account_id, destination_id) values('7',  '2000-05-28', '-120',  '12', '7'); -- ќл€ скинулась на шампунь ёле

insert into "transaction"(id, date, sum, account_id, destination_id) values('8',  '2000-05-11', '-300',  '8',  '1'); -- —ергей скинулс€ на книгу —аше
insert into "transaction"(id, date, sum, account_id, destination_id) values('9',  '2000-05-14', '-300',  '12', '1'); -- ќл€ скинулась на книгу —аше
insert into "transaction"(id, date, sum, account_id, destination_id) values('10', '2000-05-12', '-300',  '11', '1'); -- ћиша скинулс€ на книгу —аше
insert into "transaction"(id, date, sum, account_id, destination_id) values('11', '2000-05-13', '-300',  '9',  '1'); -- јрсен скинулс€ на книгу —аше
insert into "transaction"(id, date, sum, account_id, destination_id) values('12', '2000-05-14', '-300',  '1',  '1'); -- ∆ен€ скинулась на книгу —аше

insert into "transaction"(id, date, sum, account_id, destination_id) values('13',  '2000-04-20', '920',    '12', NULL); -- ќл€ кинула денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('14',  '2000-04-20', '10000',   '3', NULL); -- ћиша кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('15',  '2000-04-20', '1000',   '11', NULL); -- ћиша кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('16',  '2000-04-20', '10200',   '5', NULL); -- ¬ан€ кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('17',  '2000-04-20', '11900',   '2', NULL); --  ат€ кинула денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('18',  '2000-04-20', '8000',   '10', NULL); --  ат€ кинула денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('19',  '2000-04-20', '5600',    '4', NULL); --  ноп кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('20',  '2000-04-20', '5300',    '8', NULL); -- —ергей кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('21',  '2000-04-20', '800',     '9', NULL); -- јрсен кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('22',  '2000-04-20', '4300',    '1', NULL); -- ∆ен€ кинула денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('23',  '2000-04-20', '2000',    '6', NULL); -- —ерега кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('24',  '2000-04-20', '100',     '7', NULL); -- ёл€ кинула денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('25',  '2000-04-20', '4000',   '13', NULL); -- —аша кинул денег на счет
insert into "transaction"(id, date, sum, account_id, destination_id) values('26',  '2000-04-20', '1500',   '14', NULL); -- ќл€ кинула денег на счет




