package br.eti.webstuff.register.tests.build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import br.eti.webstuff.register.model.Competence;

public class Utilities {
	
	public static Competence generateCompetence(String tecnologia, String data) {
		Competence competence = new Competence();
		competence.setTecnologia(tecnologia);
		competence.setDataLancamento(parseData(data));
		return competence;
	}
	
	
	public static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static String parseDataToString(Calendar data) {
		
		String retorno = null;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		retorno = formatoData.format(data.getTime());

		return retorno;
	}
	
}
