package com.school.management.dao;

import java.util.List;

import com.school.management.domain.Holiday;

public interface HolidayDao {

	public void saveHoliday(Holiday holiday);

	public boolean isExistByName(String name);

	public boolean existsById(Long holiday_id);

	public Holiday getHoliday(Long holiday_id);

	public List<Holiday> getHolidayList();

	public void deleteHoliday(Long holiday_id);

	public void updateHoliday(Holiday holiday);
}
