

CREATE TABLE if not exists `last_education` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
--mengisi data table last education
delete from last_education;
insert into last_education(id, name, created_at)
values ("b94b5c2a-6186-11ed-b70a-3c970ecfa524", "SD", now());

insert into last_education(id, name, created_at)
values ("b95b3a73-6186-11ed-b70a-3c970ecfa524", "SMP", now());

insert into last_education(id, name, created_at)
values ("b9822d19-6186-11ed-b70a-3c970ecfa524", "SMA/SMK", now());

insert into last_education(id, name, created_at)
values ("b9d1d0c2-6186-11ed-b70a-3c970ecfa524", "D3", now());

insert into last_education(id, name, created_at)
values ("b9f3a92f-6186-11ed-b70a-3c970ecfa524", "S1/D4", now());

insert into last_education(id, name, created_at)
values ("b9ff585d-6186-11ed-b70a-3c970ecfa524", "S2", now());

insert into last_education(id, name, created_at)
values ("ba1588aa-6186-11ed-b70a-3c970ecfa524", "S3", now());

--mengisi data table job position
CREATE TABLE if not exists`job_position` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
delete from job_position;
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167c435b-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 5000000.0, 'chef');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167c7e06-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 3500000.0, 'waitress');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167cb84a-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 4000000.0, 'cashier');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167cefd6-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 7000000.0, 'manager');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167d27f3-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 3000000.0, 'janitor');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167d67ce-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 2500000.0, 'dishwasher');
INSERT INTO greencafe.job_position
(id, created_at, salary, title)
VALUES('167da4ce-64b0-11ed-96cc-28e347cda29a', '2022-11-15 13:38:17', 4500000.0, 'barista');
