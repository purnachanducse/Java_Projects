/**
 * 
 */
package com.in28minutes.springboot.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

/**
 * @author 10661300
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = SurveyController.class)
public class SurveyControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SurveyService surveyService;
	
	@Test
	public void retrieveDetailsForQuestion() throws Exception {
		
		Question mockQuestion = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));

		Mockito.when(
				surveyService.retrieveQuestion(Mockito.anyString(), Mockito
						.anyString())).thenReturn(mockQuestion);

		
		//surveyService.retrieveQuestion(Mockito.anyString(), Mockito.anyString()).
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		
		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options:[India,Russia,United States,China]}";
		
		//JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void createSurveyQuestion() throws Exception {
		
		Question mockQuestion = new Question("1", "Smallest Number", "1", Arrays.asList("1","2","3","4"));
		
		String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
		
		Mockito.when(surveyService.addQuestion(Mockito.anyString(), Mockito.any(Question.class))).thenReturn(mockQuestion);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/surveys/Survey1/questions").accept(MediaType.APPLICATION_JSON).content(questionJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		//assertEquals(HttpStatus.CREATED.value(),response.getStatus()); 
		
		//assertEquals("http://localhost/surveys/Survey1/questions/Question1", response.getHeader(HttpHeaders.LOCATION)); 
	}
}
