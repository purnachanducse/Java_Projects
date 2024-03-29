/**
 * 
 */
package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

/**
 * @author 10661300
 *
 */
@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("surveys/{surveyId}/questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@PostMapping("surveys/{surveyId}/questions")
	public ResponseEntity<Object> addQuestionsForSurvey(@PathVariable String surveyId,@RequestBody Question question) {
		Question addQuestion = surveyService.addQuestion(surveyId, question);
		if(addQuestion == null) ResponseEntity.noContent().build();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/surveyId").buildAndExpand(addQuestion.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}

	@GetMapping("surveys/{surveyId}/questions/{questionId}")
	public Question retrieveDetailsForQuestion(@PathVariable String surveyId,@PathVariable String questionId) {
		return surveyService.retrieveQuestion(surveyId, questionId);
	}
}
