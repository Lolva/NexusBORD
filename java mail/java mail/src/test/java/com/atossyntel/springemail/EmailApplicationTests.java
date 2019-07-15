package com.atossyntel.springemail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atossyntel.springemail.EmailApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmailApplication.class)
@WebAppConfiguration
public class EmailApplicationTests {

	@Test
	public void contextLoads() {
	}

}
