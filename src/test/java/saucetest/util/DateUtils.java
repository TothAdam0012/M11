package saucetest.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static final String TIME_ZONE = "CET";
	private static final DateTimeFormatter CET_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").withZone(ZoneId.of(TIME_ZONE));

	public static String formatCurrentTime() {
		return CET_FORMATTER.format(Instant.ofEpochMilli(System.currentTimeMillis()));
	}
}
