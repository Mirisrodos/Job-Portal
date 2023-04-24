package com.oose.jobportal.services.impls;

import com.oose.jobportal.models.entities.User;
import com.oose.jobportal.repositories.UserRepo;
import com.oose.jobportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean saveUser(User user) {
		User userSave = new User();
		userSave = userRepo.save(user);
		if(userSave != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean findUserbyGmail(String gmail) {
		User userGmail = new User();
		userGmail = userRepo.findByGmail(gmail);
		if(userGmail != null) {
			return true;
		} else {
			return false;
		}
	}
}
