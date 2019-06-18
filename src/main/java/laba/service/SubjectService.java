package laba.service;

import laba.dao.hibernate.GroupDAO;
import laba.data.Subject;
import laba.dao.hibernate.SubjectDAO;

        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;
@Service
@Transactional
public class SubjectService {
    private SubjectDAO dao;
    private GroupDAO groupDAO;

    public SubjectService(SubjectDAO dao, GroupDAO groupDAO) {
        this.dao = dao;
        this.groupDAO = groupDAO;
    }

    public void createSubject(String description, String name, Long groupId) throws IllegalArgumentException {

        validateInputs(groupId);
        Subject subject = new Subject();
        subject.setDescription(description);
        subject.setGroup(groupId);
        subject.setName(name);
        dao.save(subject);
    }

    public List<Subject> findAll() {
        return dao.findAll();
    }

    private void validateInputs(Long groupId) throws IllegalArgumentException {
        if (!groupDAO.findById(groupId).isPresent()) {
            throw new IllegalArgumentException("Cann't find group with such id");
        }
    }
}
