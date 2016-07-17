package br.eti.webstuff.register.tests.build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;

public class Utilities {
	
	public static Competence generateCompetence(String tecnologia, String data) {
		Competence competence = new Competence();
		competence.setTecnologia(tecnologia);
		competence.setDataLancamento(parseData(data));
		return competence;
	}
	
	
	
	//TODO: Testar
	public static Professional generateProfessional(String nome, String setor, List<Competence> competencies ) {
		
		Professional professional = new Professional();
		professional.setNome(nome);
		professional.setSetor(setor);
		professional.setCompetencies(competencies);
		return professional;
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
