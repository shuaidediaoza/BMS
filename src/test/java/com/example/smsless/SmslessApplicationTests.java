package com.example.smsless;

import com.example.smsless.entity.User;
import com.example.smsless.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmslessApplicationTests {

    @Autowired
    private UserService userService;

    private static final String TEST_USERNAME = "testuser";
    private static final String TEST_PASSWORD = "password123";

    // 删除测试用户（如果存在），确保测试环境干净
    @BeforeAll
    public static void cleanUp(@Autowired UserService userService) {
        User existingUser = userService.lambdaQuery().eq(User::getUsername, TEST_USERNAME).one();
        if (existingUser != null) {
            userService.removeById(existingUser.getId());
        }
    }

    @Test
    @Order(1)
    public void testRegister_ShouldSuccess() {
        User user = new User();
        user.setUsername(TEST_USERNAME);
        user.setPassword(TEST_PASSWORD);

        boolean result = userService.register(user);

        assertTrue(result);

        // 查询数据库验证用户是否存在
        User savedUser = userService.lambdaQuery().eq(User::getUsername, TEST_USERNAME).one();
        assertNotNull(savedUser);
        assertEquals(TEST_USERNAME, savedUser.getUsername());

        // 验证密码是否被加密
        assertNotEquals(TEST_PASSWORD, savedUser.getPassword());
        assertTrue(savedUser.getPassword().length() > 0); // MD5 加密后长度固定
    }

    @Test
    @Order(2)
    public void testRegister_WhenUsernameExists_ShouldFail() {
        User user = new User();
        user.setUsername(TEST_USERNAME);
        user.setPassword("anotherPassword");

        // 再次尝试注册相同用户名
        boolean result = userService.register(user);

        assertFalse(result);
    }

    @Test
    public void testRegister_WhenPasswordEmpty_ShouldThrowException() {
        User user = new User();
        user.setUsername("newuser");
        user.setPassword(""); // 空密码

        assertThrows(DataAccessException.class, () -> {
            userService.register(user);
        });
    }
}
