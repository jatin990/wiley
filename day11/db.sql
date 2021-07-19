create database wiley;
create table project(id bigint primary key, name varchar(255), budget int(20));
create table users (id bigint primary key,name varchar(255),email varchar(255),project_id bigint, foreign key(project_id) references project(id) );
select * from users;
select * from project;

insert into project values(1,"att",1000);
insert into project values(2,"linkedin",2000);
insert into project values(3,"att",1000);
insert into project values(4,"att",1000);

insert into users values(1,"user1","u@1",1);
insert into users values(2,"user2","u@2",1);
insert into users values(3,"user3","u@3",2);
insert into users values(4,"user4","u@4",4);

select  users.name, users.email,project.budget, project_id, project.name from project,users where project.id=users.project_id group by project.name;

