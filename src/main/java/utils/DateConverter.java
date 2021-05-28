package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
	
	
	// konverzija Date -> LocalDate
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	
	// konverzija LocalDate -> Date
	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
	    return java.util.Date.from(dateToConvert.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}
}
