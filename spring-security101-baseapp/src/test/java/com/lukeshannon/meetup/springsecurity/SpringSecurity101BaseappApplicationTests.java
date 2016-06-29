package com.lukeshannon.meetup.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSecurity101BaseappApplication.class)
@WebAppConfiguration
public class SpringSecurity101BaseappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
