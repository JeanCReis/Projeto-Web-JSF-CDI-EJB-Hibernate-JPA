package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sorteio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToMany(mappedBy="sorteio")
	private Set<Par> pares = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Par> getPares() {
		return Collections.unmodifiableSet(pares);
	}

	public void setPares(Set<Par> pares) {
		this.pares = pares;
	}
	
	public void adicionaPar(Par par) {
		this.pares.add(par);
	}

	public int getQuantidadeDePares() {
		return pares.size();
		
	}

}
