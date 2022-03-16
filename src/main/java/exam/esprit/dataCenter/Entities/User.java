package exam.esprit.dataCenter.Entities;

import java.io.Serializable;

import java.util.Set;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Entity
@Table( name = "User")
@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	private String nom;
	private String prenom;
	private String login;
	private String pwd;
	
	@OneToMany
	@JsonIgnore
	private Set<VirtualMachine> vms;
	
	

}
