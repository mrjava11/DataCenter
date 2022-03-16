package exam.esprit.dataCenter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.esprit.dataCenter.Entities.User;
import exam.esprit.dataCenter.Repos.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void ajouterUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

}
