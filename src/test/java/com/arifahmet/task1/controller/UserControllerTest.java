package com.arifahmet.task1.controller;

import com.arifahmet.task1.domain.User;
import com.arifahmet.task1.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Matchers.isA;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUsers_ShouldReturnUserList() throws Exception {
        User user1 = new User();
        user1.setId(1111L);
        user1.setName("Arif");
        user1.setPhoneNumber("05452335011");
        user1.setAddress("Ankara");

        User user2 = new User();
        user2.setId(1111L);
        user2.setName("Ahmet");
        user2.setPhoneNumber("05452335022");
        user2.setAddress("İstanbul");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        given(userService.getUsersByName(isA(String.class))).willReturn(userList);

        mockMvc.perform(get("/user/list")
                .param("name", "Arif"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].name", is("Arif")));

        verify(userService, times(1)).getUsersByName(isA(String.class));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void addUser_ShouldReturnUser() throws Exception {
        User user = new User();
        user.setName("Arif");
        user.setPhoneNumber("05452335011");
        user.setAddress("Ankara");

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        user.setId(1111L);

        given(userService.addUser(isA(User.class))).willReturn(user);

        mockMvc.perform(post("/user/add").param("name", user.getName()).param("phoneNumber", user.getPhoneNumber()).param("address", user.getAddress()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name", is("Arif")));

        verify(userService, times(1)).addUser(isA(User.class));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void addUser_ShouldReturnStatus400_WhenValidationErrorOccurs() throws Exception {
        User user = new User();
        user.setName("Arif");
        user.setPhoneNumber("05452335011");
        user.setAddress("Ankara");

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        user.setId(1111L);

        given(userService.addUser(isA(User.class))).willReturn(user);

        mockMvc.perform(post("/user/add").param("name", "").param("phoneNumber", user.getPhoneNumber()).param("address", user.getAddress()))
                .andDo(print())
                .andExpect(status().isBadRequest());

        verify(userService, times(0)).addUser(isA(User.class));
        verifyNoMoreInteractions(userService);
    }

}
