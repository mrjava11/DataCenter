package exam.esprit.dataCenter.Entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "DataCenter")
@Data @AllArgsConstructor @NoArgsConstructor
public class DataCenter implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDs;
	private String region;
	@Temporal(TemporalType.DATE)
	private Date dateFabriquation;
	private int capaciteDisque;
	private int espaceLibreDisque;
	@JsonIgnore
	@OneToMany(mappedBy="dataCenter", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<VirtualMachine> vms;
	
	
	
	

}
