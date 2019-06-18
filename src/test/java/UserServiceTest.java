import laba.dao.hibernate.UserDAO;
import laba.service.UserService;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    private UserDAO dao = mock(UserDAO.class);
    private UserService service = new UserService(dao);

    @Test
    public void userCanBeSaved() {
        service.createUser("TestDAO", "PAssw");
        verify(dao).save(any());
    }
}
