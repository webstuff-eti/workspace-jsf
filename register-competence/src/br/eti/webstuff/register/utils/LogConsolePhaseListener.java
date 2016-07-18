package br.eti.webstuff.register.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogConsolePhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Nome da fase: " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		// Define qual fase o Listener atende
		return PhaseId.ANY_PHASE; //Adicionaremos todas as fases
	}

}
