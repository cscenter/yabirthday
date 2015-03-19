# yabirthday

## Контакты

* Сергей Киселев: kiselev@gmail.com, https://vk.com/intr13

Общий чат по проекту: ???

## Идея

Обеспечить платформу для сбора денег и обсуждения подарков. 

Каждый пользователь имеет список пользователей, которым он дарит подарки. Эта связь однонаправленная. У пользователя системы есть основная касса из которой беруться деньги ему на подарок. Касс может быть много, и потенциально каждый пользователь имеет множество счетов в каждой кассе (зависит от числа людей, кому он дарит подарки). 

Каждая касса имеет своего владельца, который отвечает за временное хранение денег пользователя на своих счетах. К владельцу кассы приходит пользователь и вносит деньги на свой счет. Далее по мере приобритения подарков, со счетов пользователей списываются деньги, соразмерно общему числу дарителей подарка.

В случае отрицательного баланса на счету пользователя, ему приходят уведомления по email/sms об его задолженности. Раз в неделю/месяц всем пользователям приходит уведомления о грядущих днях рождениях, чтобы они могли стать дарителями подарков будуших именниников. За неделю дня рождения всем даритеялм подарка отправляется письмо с вишлистом одариваемого. 

## Архитектура

## Технологии

* Java 8
* SQL
* Jetty 9
* JDBC
* JSON
* REST
* NGINX
* HTTP
* Spring Boot, Spring IoC, Spring Data
* JavaScript, AngularJS
* HTML
* CSS, LESS

## Soft

* Java 8 u40
* Intellij IDEA 14
* PostgreSQL 9.3
* pgAdmin 1.20
* Apache Maven 3

## План

* Проработка идеи
  * Обсуждение иди и предпосылок
  * Внутреннее согласование идеи и проработка прототипов экранных форм
  * Обсуждение идеи с внешними людьми
  * Закрепление идеи и проработка деталей
* Изучение технологий
  * Установка базового софта
  * Чтение статей про технологии (по каждому ключевому слову из технологий надо найти и прочитать статью, желательно чтобы каждый прочитал разное)
  * Обсуждение технологий 
  * Создание тестового проекта на базе: postgresql (1 таблица users: login, bithday), jetty (чтение данных из БД через JDBC драйвер и формирование протейшего html с результатами).
  * Обсуждение тестового проекта.
  * Доработки тестового проекта: создание/удаление записей, поиск записей по всем полям, сохранение связей между пользователями.
  * Обсуждение и проба ревью.
* Проработка архитектуры
 * Общий взгляд на архитектуру
 * ...
* Работа над основной частью проекта
 * Создание сервисов для эмуляции внешних систем
 * Разработка системы хранения данных
 * Обеспечение репликации данных
 * Обеспечение автоматического переключения мастера
 * Разработка объектной модели
 * Создание объектов для работы с БД
 * Создание сервисов с логикой
 * Тестирование сервисов с логикой
 * Разработка UI на базе компонентов
 * Обеспечение Continus Integration
 * Сборка и конфигурирование проектов
 * Конфигурирование балансировщика нагрузки
 * Настройка автоматического деплоя

## Информация

* https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
* https://spring.io/guides/gs/spring-boot/
* https://jdbc.postgresql.org/documentation/80/connect.html
* http://maven.apache.org/guides/getting-started/
* http://search.maven.org/
* http://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol
* http://en.wikipedia.org/wiki/Representational_state_transfer
* http://code.tutsplus.com/tutorials/a-beginners-guide-to-http-and-rest--net-16340
* http://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/
* http://en.wikipedia.org/wiki/Java_servlet
* http://pdf.coreservlets.com/Servlet-Basics.pdf
* http://www.w3.org/MarkUp/Guide/
* http://www.html-5-tutorial.com/start-html5-tutorial.htm (слева меню по тегам)