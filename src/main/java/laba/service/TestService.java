package laba.service;

import laba.dao.hibernate.*;
import laba.data.Test;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TestService {
    private final TestDAO dao;
    private final UserDAO userDAO;
    private final StudentDAO studentDAO;
    private final SubjectDAO subjectDAO;

    public TestService(TestDAO dao, UserDAO userDAO, StudentDAO studentDAO, SubjectDAO subjectDAO) {
        this.dao = dao;
        this.userDAO = userDAO;
        this.studentDAO = studentDAO;
        this.subjectDAO = subjectDAO;
    }

    public void createTest(Long userId, Long studentId, Long subjectId, Long mark) {

        validateInputs(userId, studentId, subjectId);
        Test test = new Test();
        test.setMark(mark);
        test.setUserId(userId);
        test.setStudentId(studentId);
        test.setSubjectId(subjectId);
        dao.save(test);
    }

    public List<Test> findAll() {
        return dao.findAll();
    }

    private void validateInputs(Long userId, Long studentId, Long subjectId) throws IllegalArgumentException {
        if (!userDAO.findById(userId).isPresent()) {
            throw new IllegalArgumentException("Cann't find user with such id");
        } else if (!studentDAO.findById(studentId).isPresent()) {
            throw new IllegalArgumentException("Cann't find student with such id");
        } else if (!subjectDAO.findById(subjectId).isPresent()) {
            throw new IllegalArgumentException("Cann't find subject with such id");
        }
    }
}
