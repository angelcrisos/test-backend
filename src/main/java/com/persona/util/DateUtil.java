package com.persona.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateUtil {

	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		if (birthDate != null) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}
	
	public static long calculateBirthDay(LocalDate birthday){          
		long totalDias = 0;
        LocalDate today = LocalDate.now();
        LocalDate nextBDay = birthday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
        
        totalDias = ChronoUnit.DAYS.between(today, nextBDay);
           
        return totalDias;
    }

}
