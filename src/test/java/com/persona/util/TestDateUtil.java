package com.persona.util;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDateUtil {
	
	@Test
	public void testCalculateAge() {
		int age = DateUtil.calculateAge(LocalDate.of(2010, 12, 10));
		assertEquals("Debe tener los mismos valores",age,9);
	}
	
	@Test
	public void testCalculateBirthDay() {
		long days = DateUtil.calculateBirthDay(LocalDate.of(2010, 10, 10));
		assertNotNull("No debe ser nulo", days);
		
	}
	

}
