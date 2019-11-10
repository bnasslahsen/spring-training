package com.bnpparibas.dojo.user.userapp.presentation.user;

import com.bnpparibas.dojo.user.userapp.domaine.User;
import org.springframework.stereotype.Component;

/**
 * @author Badr NASS
 *
 */
@Component
public class UserMapper {

	public UserDTO mapToDto(User user) {
		if (user != null)
			return new UserDTO(user.getFirstName(), user.getLastName());
		else
			throw new RuntimeException("User can not be null");
	}

	public User mapToEntity(UserDTO userDTO) {
			return new User(userDTO.getFirstName(), userDTO.getLastName());
	}

}