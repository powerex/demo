create table subjects
(
	id INTEGER auto_increment,
	subject_group INTEGER not null,
	subject_name VARCHAR(255) null,
	subject_description VARCHAR(255) null,
	primary key (id),
	foreign key (subject_group) references groups (id)
);

