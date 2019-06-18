package laba.service;

        import laba.dao.hibernate.GroupDAO;
        import laba.data.Group;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;

@Service
@Transactional
public class GroupService {
    private GroupDAO dao;

    public GroupService(GroupDAO dao) {
        this.dao = dao;
    }

    public Group createGroup(String name) {
        Group group = new Group();
        group.setGroupName(name);
        dao.save(group);
        return group;
    }

    public List<Group> findAllGroups() {
        return dao.findAll();
    }
}
