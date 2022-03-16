package exam.esprit.dataCenter.Entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "VirtualMachine")
@Data @AllArgsConstructor @NoArgsConstructor
public class VirtualMachine implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVm;
	private String os;
	private int tailleDisque;
	@Enumerated(EnumType.STRING)
	private Etat etat;
	@ManyToOne
	private DataCenter dataCenter;

}
