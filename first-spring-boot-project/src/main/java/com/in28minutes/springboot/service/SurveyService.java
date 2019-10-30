/**
 * 
 */
package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.model.Survey;

/**
 * @author 10661300
 *
 */
@Component
public class SurveyService {

	public static List<Survey> listOfSurveys = new ArrayList<Survey>();
	
	private SecureRandom secureRandom = new SecureRandom();
	
	static {
		Question question1 = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question2 = new Question("Question2",
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question3 = new Question("Question3",
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question4 = new Question("Question4",
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
		
		List<Question> listOfQstns = Arrays.asList(question1,question2,question3,question4);
		Survey survey = new Survey("Survey1", "Favorite SUrvey", "Desc of Survey", listOfQstns);
		
		listOfSurveys.add(survey);
	}
	
	public List<Survey> retrieveAllSurveys() {
		return listOfSurveys;
	}

	public Survey retrieveSurvey(String surveyId) {
		for (Survey survey : listOfSurveys) {
			if (survey.getId().equals(surveyId)) {
				return survey;
			}
		}
		return null;
	}

	public List<Question> retrieveQuestions(String surveyId) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		return survey.getQuestions();
	}

	public Question retrieveQuestion(String surveyId, String questionId) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		for (Question question : survey.getQuestions()) {
			if (question.getId().equals(questionId)) {
				return question;
			}
		}

		return null;
	}
	
	public Question addQuestion(String surveyId,Question question) {
		Survey survey = retrieveSurvey(surveyId);
		if(survey == null) {
			return null;
		}
		
		String randomId = new BigInteger(130, secureRandom).toString(32);
		question.setId(randomId);
		survey.getQuestions().add(question);
		return question;
	}
}
