package com.bnpparibas.dojo.user.userapp.presentation.user;

import com.bnpparibas.dojo.user.userapp.dao.UserRepository;
import com.bnpparibas.dojo.user.userapp.domaine.User;
import com.bnpparibas.dojo.user.userapp.presentation.common.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {

	private UserRepository userRepository;
	private UserMapper userMapper;

	private UserResource(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable final String id) {
		final User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with the following id, not found: " + id));
		return userMapper.mapToDto(user);
	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<URI> addUser(final @RequestBody UserDTO userDTO) {
		final User user = userMapper.mapToEntity(userDTO);
		userRepository.save(user);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO updateUser(@PathVariable final String id, @RequestBody UserDTO userDTO) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with the following id, not found: " + id));
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		userRepository.save(user);
		return userMapper.mapToDto(user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable final String id) {
		userRepository.deleteById(id);
	}

}
