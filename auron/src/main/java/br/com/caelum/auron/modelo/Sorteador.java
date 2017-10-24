package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.List;

public class Sorteador {

	private Sorteio sorteio;
	private List<Participante> participantes;
	private int totalDeParticipantes;

	public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteadorException {
		if(participantes == null) {
			throw new SorteadorException("Por favor, insira uma lista de participantes");
		}
		this.sorteio = sorteio;
		this.participantes = participantes;
		this.totalDeParticipantes = participantes.size();
	}

	public void sortear() throws SorteadorException {
		
		
		verificaTamanhoDaListaDeParticipantes();
		embaralhaParticipantes();
		
		int indiceAtual = 0;
		
		while(indiceAtual < totalDeParticipantes) {
			if(participanteAtualEhOUltimo(indiceAtual)) {
				criarEAdicionarParNoSorteio(sorteio, indiceAtual, 0);
				break;
			}
			criarEAdicionarParNoSorteio(sorteio, indiceAtual, indiceAtual + 1);
			
			indiceAtual++;
		}
		
	}

	private void embaralhaParticipantes() {
		Collections.shuffle(participantes);
	}

	private void verificaTamanhoDaListaDeParticipantes() throws SorteadorException {
		if(totalDeParticipantes < 2) {
			throw new SorteadorException("Por favor, insira uma lista com no minimo dois participantes");
		}
	}

	private boolean participanteAtualEhOUltimo(int indiceAtual) {
		return indiceAtual == totalDeParticipantes - 1;
	}

	private void criarEAdicionarParNoSorteio(Sorteio sorteio, int indiceAtual, int indiceFinal) {
		Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceFinal), sorteio);
		sorteio.adicionaPar(par);
	}

}
