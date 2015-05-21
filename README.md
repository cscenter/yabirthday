# yabirthday (прототип)

## Контакты

### Руководители:

* Сергей Киселев: kiselev@gmail.com, https://vk.com/intr13
* Артем Григорьев: ortemij@gmail.com, https://vk.com/ortemij

### Студенты:
* Равиь Галеев: neboskrebb@gmail.com, https://vk.com/dehasi
* Ольга Тележная: olyatelezhnaya@gmail.com, https://vk.com/olyaa
* Максим Кузьмин: maxrider@mail.ru, http://vk.com/id2558840

## Идея проекта

Обеспечить платформу для сбора денег и обсуждения подарков. 

Каждый пользователь имеет список друзей, которым он дарит подарки. Эта связь однонаправленная. У пользователя есть основная касса, из которой берутся деньги ему на подарок. Касс может быть много, и потенциально каждый пользователь имеет множество счетов в каждой кассе (зависит от числа людей, кому он дарит подарки). 

Каждая касса имеет своего владельца, который отвечает за временное хранение денег пользователя на своих счетах. К владельцу кассы приходит пользователь и вносит деньги на свой счет. Далее по мере приобритения подарков, со счетов пользователей списываются деньги, соразмерно общему числу дарителей подарка.

Пользователь видит список своих транзакций, из которых складывается его итоговая сумма на счету (она также видна в верхнем правом углу).

Пользователь имеет возможность добавлять и удалять друзей. Другие люди не будут знать о том, что их добавили или удалили.

## Архитектура

## Технологии

* Java 8
* SQL
* Jetty 9
* JDBC
* JSON
* REST
* HTTP
* Spring Boot, Spring Data
* JPA
* JavaScript, JQuery
* HTML
* CSS

## Soft

* Java 8 u40
* Intellij IDEA 14
* PostgreSQL 9.3
* pgAdmin 1.20
* Apache Maven 3

## Как запустить?

* Установите недостающий soft
* В IntelliJ выберите "Import Maven project"
* В pgAdmin создайте сервер c именем пользователя postgres и паролем password. В этом сервере создайте базу данных с именем birthday. Все данные настройки можно при желании поменять в файле ./birthday/birthday-app/src/main/resources/application.properties
* Наслаждайтесь :)
* Результат виден в браузере по адресу localhost:8080
* Список пользователей можно взять в базе данных в таблице user в столбике login