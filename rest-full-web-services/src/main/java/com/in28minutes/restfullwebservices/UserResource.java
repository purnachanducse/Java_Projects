/**
 * 
 */
package com.in28minutes.restfullwebservices;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author 10661300
 *
 */
@RestController
public class UserResource {

	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDAOService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public Optional<User> retrieveUser(@PathVariable String userId) {
		Optional<User> user = userDAOService.findOne(Integer.parseInt(userId));
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+userId);
		}
		
//		EntityModel<User> resource = new EntityModel<User>(user.get());
//		@SuppressWarnings("deprecation")
//		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//		//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//		resource.add(linkTo.withRel("all-users"));
//		return resource;
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User addUser = userDAOService.addUser(user);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequestUri()
		.path("/{id}").buildAndExpand(addUser.getId()).toUri();
		return  ResponseEntity.created(uriLocation).build();
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable String userId) {
		Optional<User> user = userDAOService.findOne(Integer.parseInt(userId));
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+userId);
		}else {
			userDAOService.delete(Integer.parseInt(userId));
		}
	}
}
