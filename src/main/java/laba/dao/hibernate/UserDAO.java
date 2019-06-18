package laba.dao.hibernate;

        import laba.data.User;
        import org.hibernate.IdentifierLoadAccess;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import javax.persistence.TypedQuery;
        import java.util.List;
        import java.util.Optional;


@Service
public class UserDAO {


    private SessionFactory factory;

    @Autowired
    public UserDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void save(User user) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(user);
    }

    public Optional<User> findById(Long aLong) {
        IdentifierLoadAccess<User> userIdentifierLoadAccess = factory.getCurrentSession().byId(User.class);
        return Optional.ofNullable(userIdentifierLoadAccess.load(aLong));
    }

    public List<User> findAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = factory.openSession().createQuery("from main.java.laba.data.User");
        return query.getResultList();
    }

    public Optional<User> findByName(String name) {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = factory.getCurrentSession().createQuery("from main.java.laba.data.User where user_name = :name");
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst();

    }


}