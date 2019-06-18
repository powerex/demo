import laba.dao.hibernate.GroupDAO;
import laba.service.GroupService;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GroupServiceTest {
    private GroupDAO dao = mock(GroupDAO.class);
    private GroupService service = new GroupService(dao);


    @Test
    public void groupCanBeSaved() {
        service.createGroup("TestDAO");
        verify(dao).save(any());
    }
}
