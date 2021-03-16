import com.auth0.jwt.interfaces.Claim;
import com.lds.springcloud.UserManagerService;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.lds.springcloud.util.JWTUtil;

import java.util.Map;

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

        User user1 = new User(null, "testuser", "123456", "admin");
        int result = 0;

//        result = userService.deleteUser("user1");
//        assertTrue(result > 0);
//        result = 0;


        result = userService.create(user1);
        assertTrue(result > 0);
    }

    @Test
    public void testJWTUtil() {
        try {
            String token = JWTUtil.createToken("12345", "admin", "admin");
            System.out.println("token=" + token);
            //Thread.sleep(5000);
//            Map<String, Claim> map = JWTUtil.verifyToken(token);
            Map<String, Claim> map = JWTUtil.parseToken(token);
            //遍历
            System.out.println(map.toString());
            for (Map.Entry<String, Claim> entry : map.entrySet()) {
                if (entry.getValue().asString() != null) {
                    System.out.println(entry.getKey() + "===" + entry.getValue().asString());
                } else {
                    System.out.println(entry.getKey() + "===" + entry.getValue().asDate());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUser() {
//        List<User> users = userService.queryAllUser();

//        List<User> users = userService.queryUserByQuery(1, 2, "tea");
        User user = new User();
        user.setRole("test1");
        user.setUserId(11);
        Integer res = userService.editUser(user);
        System.out.println(res);

    }
}
