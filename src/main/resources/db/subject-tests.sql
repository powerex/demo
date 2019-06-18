create table tests(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
user_id INTEGER NOT NULL,
subject_id INTEGER NOT NULL,
student_id INTEGER NOT NULL,
mark INTEGER NOT NULL,
FOREIGN KEY (user_id) references users(id),
FOREIGN KEY (subject_id) references subjects(id),
FOREIGN KEY (student_id) references students(id)
)