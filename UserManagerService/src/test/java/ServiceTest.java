import com.lds.springcloud.UserManagerService;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = UserManagerService.class)
@RunWith(SpringRunner.class)
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {

        User user = userService.queryById(1);
        assertTrue(user != null);

        User user1 = new User(null,"testuser","123456","admin");
        int result = 0;

        result = userService.deleteUser(user1);
        assertTrue(result > 0);
        result = 0;


        result = userService.create(user1);
        assertTrue(result > 0);
    }
}
