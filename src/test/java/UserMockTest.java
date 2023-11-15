import com.example.pattern.DataManager.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

class UserMockTest {
    @Mock
    UserMock userMock;
    @Autowired
    UserService userService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userMock.createMockUser(0);
        userMock.mock();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void doNothing(){
        assertTrue("true", true);
    }

    @Test
    public void findUserById_Ok(){
        assertEquals(userMock.mock().get(0),userService.getUserDtoById(1L));
    }
}