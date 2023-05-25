package com.oose.jobportal.services;

import com.oose.jobportal.models.entities.User;

public interface UserService {
	boolean saveUser(User user);
	boolean findUserbyGmail(String gmail);
	boolean checkPassword(String gmail, String pass);
}
