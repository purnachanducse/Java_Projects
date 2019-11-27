/**
 * 
 */
package com.in28minutes.restfullwebservices;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restfullwebservices.repo.PostRepository;
import com.in28minutes.restfullwebservices.repo.UserRepository;


/**
 * @author 10661300
 *
 */
@RestController
public class UserJPAService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{userId}")
	public User findOne(@PathVariable int userId) {
		Optional<User> findUser = userRepository.findById(userId);
		if(!findUser.isPresent()) {
			throw new UserNotFoundException("Specified user is not available user!");
		}
		return findUser.get();
	}
	
	@PostMapping("/jpa/users")
	public User addUser(@RequestBody User user) {
		User insertUser = new User();
		insertUser.setName(user.getName());
		insertUser.setBirthDate(user.getBirthDate());
		User savedUser = userRepository.save(insertUser);
		return savedUser;
	}
	
	@DeleteMapping("/jpa/users/{userId}")
	public void delete(@PathVariable int userId) {
		Predicate<User> condition = user -> (user.getId() == userId);
		userRepository.findAll().removeIf(condition);
	}
	
	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("Specified user is not available in our records!");
		}
		
		return userOptional.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int userId,@RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("Specified user is not available in our records!");
		}
		
		User user = userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(post.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
