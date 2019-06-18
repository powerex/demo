package laba.dao.hibernate;

import laba.data.Test;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class TestDAO {
    private SessionFactory factory;

    @Autowired
    public TestDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void save(Test test) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(test);
    }

    public Optional<Test> findById(Long aLong) {
        IdentifierLoadAccess<Test> testIdentifierLoadAccess = factory.getCurrentSession().byId(Test.class);
        return Optional.ofNullable(testIdentifierLoadAccess.load(aLong));
    }

    public List<Test> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Test> query = factory.getCurrentSession().createQuery("from main.java.laba.data.Test");
        return query.getResultList();
    }
}
