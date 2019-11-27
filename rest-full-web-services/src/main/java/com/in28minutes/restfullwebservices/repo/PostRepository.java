/**
 * 
 */
package com.in28minutes.restfullwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfullwebservices.Post;

/**
 * @author 10661300
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
