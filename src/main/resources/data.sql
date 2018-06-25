DROP TABLE IF EXISTS contract;
DROP TABLE IF EXISTS application;

CREATE TABLE contract(
   id    bigint PRIMARY KEY NOT NULL
);

CREATE TABLE application(
   id bigint PRIMARY KEY       NOT NULL,
   dt_created     timestamp without time zone,
   product_name     varchar(100),
   contract_id    bigint NOT NULL,
   FOREIGN KEY (contract_id) REFERENCES contract (id)
);

INSERT INTO contract(id)
VALUES (1), (2);

INSERT INTO application(id,dt_created,product_name,contract_id)
VALUES
 (1,'2019-10-11 00:00:00','Заявка 1',1),
 (2,'2019-10-12 00:00:00','Заявка 2',1),
 (3,'2019-10-20 00:00:00','Заявка 3',1), -- latest one for 1 contract
 (4,'2019-10-14 00:00:00','Заявка 4',1),
 (5,'2019-10-15 00:00:00','Заявка 5',2),
 (6,'2019-10-16 00:00:00','Заявка 6',2),
 (7,'2019-10-17 00:00:00','Заявка 7',2),
 (8,'2019-10-25 00:00:00','Заявка 8',2);