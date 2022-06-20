# ShortUrlService2
Java Service by Spring Boot - give you short url by original url from body in http request, redirect...made by Spring Boot.

You need SQL DataBase (my is Postgres). (no Redis, no Collections). Table creates by SpringBoot names url_info, like Model-class (id int, hash varchar, originalUrl varchar, createdAt timestamp)

1. Service takes original url from from body in http POST-request Service parse original-url to hash-url, create new row in SQL DB and give to Client short url.

2. Service takes short (hash) url from http GET-request. Service make query to SQL about original url (hash) and redirect Client original url. If short-url isn`t in SQL data base service do nothing.
