package com.arifahmet.task1.repository;

import com.arifahmet.task1.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void save_ShouldPersistUser() {
        User user = new User();
        user.setId(1111L);
        user.setName("Arif");
        user.setPhoneNumber("05554443322");
        user.setAddress("Ankara");

        User returnedUser = userRepository.save(user);

        assertNotNull(returnedUser.getId());
    }

    @Test
    public void findByName_ShouldReturnNull_WhenUserNotExists() {
        List<User> userList = userRepository.findByNameIgnoreCase("Arif");

        assertEquals(userList.size(), 0);
    }


    @Test
    public void findByName_ShouldReturnUsers_WhenUsersExists() {
        User user = new User();
        user.setId(1111L);
        user.setName("Arif");
        user.setPhoneNumber("05554443322");
        user.setAddress("Ankara");
        userRepository.save(user);

        List<User> userList = userRepository.findByNameIgnoreCase("Arif");

        assertEquals(userList.size(), 1);
    }


}
