import laba.dao.hibernate.GroupDAO;
import laba.dao.hibernate.StudentDAO;
import laba.service.StudentService;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StudentServiceTest {
    private StudentDAO dao = mock(StudentDAO.class);
    private GroupDAO groupDAO = mock(GroupDAO.class);
    private StudentService service = new StudentService(dao, groupDAO);

    @Test
    public void groupCanBeSaved() {
        service.createStudent("TestDAO", 1L);
        verify(dao).save(any());
    }
}