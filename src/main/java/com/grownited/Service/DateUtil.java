package com.grownited.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	    public static Date[] getLastMonthDateRange() {
	        LocalDate now = LocalDate.now();
	        LocalDate startDate = now.minusMonths(1).withDayOfMonth(1);
	        LocalDate endDate = now.withDayOfMonth(1).minusDays(1);

	        return new Date[] {
	            Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
	            Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
	        };
	    }
	}



