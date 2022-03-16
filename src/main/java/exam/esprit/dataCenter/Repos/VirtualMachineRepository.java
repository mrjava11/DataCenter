package exam.esprit.dataCenter.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exam.esprit.dataCenter.Entities.VirtualMachine;


@Repository
public interface VirtualMachineRepository extends CrudRepository<VirtualMachine, Integer>{

}
