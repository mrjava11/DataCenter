package exam.esprit.dataCenter.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exam.esprit.dataCenter.Entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
