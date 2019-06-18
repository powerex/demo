create table student_test
(
	id INTEGER auto_increment,
	student_id INTEGER not null,
	test_id INTEGER not null,
	primary key (id),
	foreign key (student_id) references students (id),
	foreign key (test_id) references tests (id)
);

