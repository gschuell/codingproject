package com.adserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdserverprojectApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void durationTest() {

		String query1 = "{\"partner_id\": \"Partner 1\",\"duration\":10,\"ad_content\":\"Now you can be your very own business owner...see how\"}";
		String query2 = "{\"partner_id\": \"Partner 1\",\"duration\":10,\"ad_content\":\"Now you can be your very own a nre car, cheap!\"}";


	}

}
