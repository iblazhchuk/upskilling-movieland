# create schema
CREATE DATABASE IF NOT EXISTS db_movieland;

# create table movies
CREATE TABLE IF NOT EXISTS db_movieland.movies
(
    id           bigint auto_increment primary key,
    name_russian varchar(255),
    name_native  varchar(255),
    year         year,
    description  varchar(1024),
    rating       decimal(10, 2),
    price        decimal(10, 2),
    picture_path varchar(255)
);

# create table genres
CREATE TABLE IF NOT EXISTS db_movieland.genres
(
    id         bigint primary key auto_increment,
    genre_name varchar(100)
);

# create table countries
CREATE TABLE IF NOT EXISTS db_movieland.countries
(
    id           bigint primary key auto_increment,
    country_name varchar(100)
);

# create table users
CREATE TABLE IF NOT EXISTS db_movieland.users
(
    id            bigint primary key auto_increment,
    first_name    varchar(255),
    last_name     varchar(255),
    email         varchar(255),
    role          varchar(255) default 'user',
    hash_password varchar(255),
    salt          varchar(255)
);

# create table reviews
CREATE TABLE IF NOT EXISTS db_movieland.reviews
(
    id          bigint primary key auto_increment,
    movie_id    bigint,
    user_id     bigint,
    description varchar(1024),
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES db_movieland.users (id),
    CONSTRAINT fk_review_movie_id
        FOREIGN KEY (movie_id)
            REFERENCES db_movieland.movies (id)
);

# create table movie's genres
CREATE TABLE IF NOT EXISTS db_movieland.movies_genres
(
    movie_id bigint,
    genre_id bigint,
    CONSTRAINT fk_movies_genres_movie_id
        FOREIGN KEY (movie_id)
            REFERENCES db_movieland.movies (id),
    CONSTRAINT fk_genre_id
        FOREIGN KEY (genre_id)
            REFERENCES db_movieland.genres (id)
);

# create table movie`s countries
CREATE TABLE IF NOT EXISTS db_movieland.movies_countries
(
    movie_id bigint,
    country_id bigint,
    CONSTRAINT fk_movies_countries_movie_id
        FOREIGN KEY (movie_id)
            REFERENCES db_movieland.movies (id),
    CONSTRAINT fk_country_id
        FOREIGN KEY (country_id)
            REFERENCES db_movieland.countries (id)
);
