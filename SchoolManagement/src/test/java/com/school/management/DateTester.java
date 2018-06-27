package com.school.management;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateTester {

	@Test
	public void testDate()
	{
		System.out.println("shree");
		
		printDate(2);
	}
	
	private void printDate(int month)
	{
		Calendar calendar = Calendar.getInstance();         
		calendar.add(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		System.out.println("nextMonthFirstDay  "+nextMonthFirstDay);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date nextMonthLastDay = calendar.getTime();
		System.out.println(" nextMonthLastDay "+nextMonthLastDay );
	}
}
