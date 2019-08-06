package br.com.recrutamento.brasilia.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDateUtil {

	public static Date convert(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
