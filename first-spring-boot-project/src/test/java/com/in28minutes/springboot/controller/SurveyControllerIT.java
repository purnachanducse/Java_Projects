/**
 * 
 */
package com.in28minutes.springboot.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.FirstSpringBootProjectApplication;
import com.in28minutes.springboot.model.Question;

/**
 * @author 10661300
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstSpringBootProjectApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void before() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testJsonAssert() throws JSONException {
		JSONAssert.assertEquals("{id:1}", "{id:1,name:Sathish}", false);
	}
	
	@Test
	public void testRetrieveSurveyQuestion() throws JSONException {
		String retrieveSpecificQuestionUrl = "/surveys/Survey1/questions/Question1";
		String url = createUri(retrieveSpecificQuestionUrl);
		
		//String output = restTemplate.getForObject(url, String.class);
		@SuppressWarnings("rawtypes")
		HttpEntity entity = new HttpEntity<String>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity ,String.class);
		//assertTrue(response.getBody().contains("\"id\":\"Question1\""));
		assertTrue(response.getBody().contains("Question1"));
		//System.out.println("Response: "+response.getBody());
		@SuppressWarnings("unused")
		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options:[India,Russia,United States,China]}";
		//JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createUri(String uri) {
		return "http://localhost:"+port+uri;
	}
	
	@Test
	public void retrieveSurveyQuestions() {
		
		String retrieveAllQuestions = "/surveys/Survey1/questions";
		String url = createUri(retrieveAllQuestions);
		
		ParameterizedTypeReference<List<Question>> myBean = new ParameterizedTypeReference<List<Question>>() {};
		//ResponseEntity<List<Question>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<String>(null,headers),new ParameterizedTypeReference<List<Question>>() {});
		//ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<String>(null,headers),String.class);
		ResponseEntity<List<Question>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<String>(null,headers),myBean);
		System.out.println("Response: "+responseEntity.getBody());
		@SuppressWarnings("unused")
		Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                        "India", "Russia", "United States", "China"));
		//Assertions.assertEquals(200, responseEntity.getStatusCode());
		//Assertions.assertEquals(expected, actual);
		//assertTrue(responseEntity.getBody().contains(sampleQuestion));
		assertTrue(responseEntity.getBody().toString().contains("Question1"));
	}
	
	@Test
	public void addQuestion() {
		
		String addQuestion = "/surveys/Survey1/questions";
		String url = createUri(addQuestion);

		Question question = new Question("DOESNTMATTER", "Question1", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Question>(question,headers), String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		System.out.println("actual: "+actual);
		assertTrue(actual.contains("/surveys/Survey1/questions"));
	}
}
