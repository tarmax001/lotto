DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS bids;
DROP TABLE IF EXISTS keno;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 10000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL,
    enabled    BOOL                DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE bids
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    play_date TIMESTAMP                         NOT NULL,
    bid_date  TIMESTAMP           DEFAULT now() NOT NULL,
    amount    DOUBLE PRECISION                  NOT NULL,
    balls     INTEGER[]                         NOT NULL
);
CREATE TABLE keno
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    play_number INTEGER   NOT NULL,
    play_date   TIMESTAMP NOT NULL,
    balls       INTEGER[] NOT NULL
);