package com.arifahmet.task1.service;

import com.arifahmet.task1.domain.User;
import com.arifahmet.task1.repository.UserRepository;
import com.arifahmet.task1.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {


    @Configuration
    static class ContextConfiguration {
        @Bean
        public UserService userService() {
            UserService userService = new UserServiceImpl();
            return userService;
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUsers_ShouldReturnUserList() throws Exception {
        User user = new User();
        user.setId(1111L);
        user.setName("Arif");
        user.setPhoneNumber("05452335011");
        user.setAddress("Ankara");

        List<User> response = new ArrayList<User>();
        response.add(user);

        when(userRepository.findByNameIgnoreCase("Arif")).thenReturn(response);

        List<User> list =  userService.getUsersByName("Arif");

        verify(userRepository, times(1)).findByNameIgnoreCase(isA(String.class));

        assertEquals(list.size(), 1);

    }

    @Test
    public void save_ShouldPersistUser() {
        User user = new User();
        user.setName("Ahmet");
        given(userRepository.save(isA(User.class))).willReturn(user);

        User returnedUser = userService.addUser(user);

        verify(userRepository, times(1)).save(isA(User.class));
        assertNotNull(returnedUser);
    }



}
