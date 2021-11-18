package com.example.demo.model;




import java.io.Serializable;
import java.util.Date;
import java.util.List;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Client implements Serializable  {

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY) 
	private Long idClient;

	private String nome;
	
	private String prenome;
	
	private String adresse;

	private String telefone;

	private String ville;
	
	private String password;
	
	private int code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date registrationDate;
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(targetEntity=CommandeClient.class,mappedBy="client",fetch=FetchType.LAZY)
	private List<CommandeClient> commandeClient;

	public List<CommandeClient> getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(List<CommandeClient> commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long idClient, String nome,String prenome , String ville, String adresse, String telefone,List<CommandeClient> commandeClient,String password) {
		super();
		
		this.nome = nome;
		this.prenome = prenome;
		this.ville = ville;
		this.adresse = adresse;
		this.telefone = telefone;
		this.commandeClient=commandeClient;
        this.password = password;
		
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrenome() {
		return prenome;
	}

	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
