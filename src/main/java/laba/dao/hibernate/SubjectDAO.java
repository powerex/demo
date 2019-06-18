package laba.dao.hibernate;

import laba.data.Subject;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectDAO {
    private SessionFactory factory;

    @Autowired
    public SubjectDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void save(Subject subject) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(subject);
    }

    public Optional<Subject> findById(Long aLong) {
        IdentifierLoadAccess<Subject> subjectIdentifierLoadAccess = factory.getCurrentSession().byId(Subject.class);
        return Optional.ofNullable(subjectIdentifierLoadAccess.load(aLong));
    }

    public List<Subject> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Subject> query = factory.getCurrentSession().createQuery("from main.java.laba.data.Subject");
        return query.getResultList();
    }
}