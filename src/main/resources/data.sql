

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
insert into job_position(id, title, salary, created_at)
values ("d47c55a2-619a-11ed-b70a-3c970ecfa524", "chef", 5000000, now());

insert into job_position(id, title, salary, created_at)
values ("d48f0d4e-619a-11ed-b70a-3c970ecfa524", "waitress", 3500000, now());

insert into job_position(id, title, salary, created_at)
values ("d4993065-619a-11ed-b70a-3c970ecfa524", "cashier", 4000000, now());

insert into job_position(id, title, salary, created_at)
values ("d4a1af2c-619a-11ed-b70a-3c970ecfa524", "manager", 7000000, now());

insert into job_position(id, title, salary, created_at)
values ("d4af23dd-619a-11ed-b70a-3c970ecfa524", "janitor", 3000000, now());

insert into job_position(id, title, salary, created_at)
values ("d4af37dt-619a-11ed-b70a-3c970ecfa524", "dishwasher", 2500000, now());

insert into job_position(id, title, salary, created_at)
values ("d4af14fu-619a-11ed-b70a-3c970ecfa524", "barista", 4500000, now());

