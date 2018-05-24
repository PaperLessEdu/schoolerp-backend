package com.school.management.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name = "holiday")
public class Holiday {

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long holiday_id;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "discription")
		private String discripation;
		
		@Column(name = "date", updatable = false)
		@CreationTimestamp
		private LocalDateTime date;

		public long getHoliday_id() {
			return holiday_id;
		}

		public void setHoliday_id(long holiday_id) {
			this.holiday_id = holiday_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDiscripation() {
			return discripation;
		}

		public void setDiscripation(String discripation) {
			this.discripation = discripation;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		
				
}
