package com.lukeshannon.meetup.springsecurity;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSecurity101Step3Application.class)
@WebAppConfiguration
public class SpringSecurity101Step1ApplicationTests {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test
	public void requiresAuthenticate() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isUnauthorized());
	}

	@Test
	public void invalidCredentials() throws Exception {
		mockMvc.perform(get("/").with(httpBasic("ninja", "invalid")))
			.andExpect(status().isUnauthorized());
	}

	@Test
	public void canAuthenitcate() throws Exception {
		mockMvc.perform(get("/").with(httpBasic("ninja", "ninja")))
			.andExpect(status().isOk());
	}

	@Test
	@WithMockUser
	public void runsAsUser() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk());
	}
}