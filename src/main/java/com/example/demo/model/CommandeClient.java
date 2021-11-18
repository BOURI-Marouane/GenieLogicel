package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class CommandeClient {
	
	
	

	public CommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public CommandeClient(Date registrationDate, Client client, List<LigneCommandeClient> ligneCommandeClient) {
		super();
		this.registrationDate = registrationDate;
		this.client = client;
		this.ligneCommandeClient = ligneCommandeClient;
	}

	
	  public CommandeClient(Client client) { super(); this.client = client;
	  
	  }
	 
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommandeClient;

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "Date_Commande")
	private Date registrationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ID_CLT")
	private Client client;
	
	 @OneToMany(targetEntity=LigneCommandeClient.class,mappedBy="commandeClient",fetch=FetchType.LAZY)
	private List<LigneCommandeClient> ligneCommandeClient;

	/*
	 * @OneToMany(mappedBy = "commandeClient") private List<LigneCommandeClient>
	 * ligneCommandeClient;
	 */

	public Long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(Long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/*
	 * public List<LigneCommandeClient> getLigneCommandeClient() { return
	 * ligneCommandeClient; }
	 * 
	 * public void setLigneCommandeClient(List<LigneCommandeClient>
	 * ligneCommandeClient) { this.ligneCommandeClient = ligneCommandeClient; }
	 */

}
