package exam.esprit.dataCenter.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exam.esprit.dataCenter.Entities.DataCenter;


@Repository
public interface DataCenterRepository extends CrudRepository<DataCenter, Integer> {

	
	@Query("Select d From DataCenter d where d.dateFabriquation > '2019-11-01'")
	List<DataCenter> listerDataCenter();
	
	
}
