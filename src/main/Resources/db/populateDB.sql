DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM bids;
ALTER SEQUENCE global_seq RESTART WITH 10000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.com', '123456'),
       ('Admin', 'admin@gmail.com', 'nimda');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 10000),
       ('ADMIN', 10001);

-- public static List<Bid> bids = List.of(
--             new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 2.0, 30, 1),
--             new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 1.0, 1, 58),
--             new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 2.0, 1, 58),
--             new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 1.0, 47, 13),
--             new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 2.0, 30, 58, 55),
--             new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 1.0, 30, 58)
--     );

INSERT INTO bids (id, play_date, bid_date, amount, balls)
VALUES (10002, '2020-11-23', '2020-11-22', 2.2, '{30, 1}');