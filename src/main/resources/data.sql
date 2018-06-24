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
);

INSERT INTO contract(id)
VALUES (1), (2);

INSERT INTO application(id,dt_created,product_name,contract_id)
VALUES
 (1,now(),'Заявка 1',1),
 (2,now(),'Заявка 2',1),
 (3,now(),'Заявка 3',1),
 (4,now(),'Заявка 4',1),
 (5,now(),'Заявка 5',2),
 (6,now(),'Заявка 6',2),
 (7,now(),'Заявка 7',2),
 (8,now(),'Заявка 8',2);