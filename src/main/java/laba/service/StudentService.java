package laba.service;

import laba.dao.hibernate.GroupDAO;
import laba.dao.hibernate.StudentDAO;
import laba.data.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentDAO studentDAO;
    private final GroupDAO groupDAO;

    public StudentService(StudentDAO studentDAO, GroupDAO groupDAO) {
        this.studentDAO = studentDAO;
        this.groupDAO = groupDAO;
    }

    public Student createStudent(String name, Long groupId) throws IllegalArgumentException {
        validateInputs(groupId);
        Student student = new Student();
        student.setGroupId(groupId);
        student.setStudentName(name);
        studentDAO.save(student);
        return student;
    }

    public List<Student> findAllStudents() {
        return studentDAO.findAll();
    }

    private void validateInputs(Long groupId) throws IllegalArgumentException {
        if (!groupDAO.findById(groupId).isPresent()) {
            throw new IllegalArgumentException("Cann't find group with such id");
        }
    }
}
