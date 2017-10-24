package br.com.caelum.auron.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import br.com.caelum.auron.dao.ParticipanteDao;
import br.com.caelum.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {

	private Participante participante = new Participante();
	
	@Inject
	private ParticipanteDao dao;
	@Inject
	private Subject user;
	@Inject
	private FacesContext context;

	public Participante getParticipante() {
		return participante;
	}
	
	public void cadastrar() {
		dao.inserir(participante);
	}
	
	public List<Participante> getParticipantes() {
		return dao.getParticipantes();
	}
	
	public String login() {
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(participante.getEmail(), participante.getSenha());
			user.login(token);
			return "sorteio?faces-redirect=true";
		} catch (AuthenticationException e) {
			context.addMessage(null, new FacesMessage("Email ou senha inválidos"));
		}
		
		return null;
	}
}
