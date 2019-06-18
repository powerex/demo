package laba.dao.hibernate;

import laba.data.Group;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class GroupDAO {
    private SessionFactory factory;

    @Autowired
    public GroupDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void save(Group group) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(group);
    }

    public Optional<Group> findById(Long aLong) {
        IdentifierLoadAccess<Group> groupIdentifierLoadAccess = factory.getCurrentSession().byId(Group.class);
        return Optional.ofNullable(groupIdentifierLoadAccess.load(aLong));
    }

    public List<Group> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Group> query = factory.getCurrentSession().createQuery("from main.java.laba.data.Group");
        return query.getResultList();
    }

}
