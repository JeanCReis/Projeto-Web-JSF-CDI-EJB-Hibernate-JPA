package br.com.caelum.auron.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.caelum.auron.modelo.Participante;
import br.com.caelum.auron.modelo.Sorteador;
import br.com.caelum.auron.modelo.SorteadorException;
import br.com.caelum.auron.modelo.Sorteio;

@Named
@RequestScoped
public class SorteioBean {

	private Sorteio sorteio = new Sorteio();

	public Sorteio getSorteio() {
		return sorteio;
	}

	public void sortear() throws SorteadorException {
		List<Participante> participantes = new ArrayList<>();
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		try {
			sorteador.sortear();
		} catch (SorteadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
