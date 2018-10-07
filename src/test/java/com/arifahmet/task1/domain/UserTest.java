package com.arifahmet.task1.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class UserTest {

    @Autowired
    private JacksonTester<User> jacksonTester;

    private String content = "{\"id\":1111,\"name\":\"Arif\",\"phoneNumber\":\"05554443322\",\"address\":\"Ankara\"}";

    @Test
    public void serializeJson() throws Exception {
        User user = new User();
        user.setId(1111L);
        user.setName("Arif");
        user.setPhoneNumber("05554443322");
        user.setAddress("Ankara");

        assertThat(this.jacksonTester.write(user)).isEqualToJson(content);
    }

    @Test
    public void deserializeJson() throws Exception{
        assertThat(this.jacksonTester.parse(content).getObject().getName()).isEqualTo("Arif");
    }
}
