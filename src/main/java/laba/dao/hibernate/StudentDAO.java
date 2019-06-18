package laba.dao.hibernate;

import laba.data.Student;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Service
public class StudentDAO {

    private SessionFactory factory;

    @Autowired
    public StudentDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void save(Student student) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(student);
    }

    public Optional<Student> findById(Long aLong) {
        IdentifierLoadAccess<Student> studentIdentifierLoadAccess = factory.getCurrentSession().byId(Student.class);
        return Optional.ofNullable(studentIdentifierLoadAccess.load(aLong));
    }

    public List<Student> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Student> query = factory.getCurrentSession().createQuery("from main.java.laba.data.Student");
        return query.getResultList();
    }
}