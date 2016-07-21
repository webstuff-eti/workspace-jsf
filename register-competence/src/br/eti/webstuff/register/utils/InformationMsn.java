package br.eti.webstuff.register.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class InformationMsn {
	
	
	public void intenacionalizaRuntimeException(String msn) throws IOException{
		 
		 FacesContext context = FacesContext.getCurrentInstance();

		 ResourceBundle bundle = ResourceBundle.getBundle("br.eti.webstuff.labels", context.getViewRoot().getLocale());
		 
		 String msgBundle = bundle.getString(msn); //captura a mensagem do messages.properties (com o faces-config.xml configurado)

		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msgBundle, msgBundle)); //emitindo a mensagem na tela
	}

}
