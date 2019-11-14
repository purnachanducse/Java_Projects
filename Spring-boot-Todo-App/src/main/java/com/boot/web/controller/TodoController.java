package com.boot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.web.model.Todo;
import com.boot.web.services.TodoRepository;
import com.boot.web.services.TodoService;

@Controller
//@SessionAttributes("userName")
public class TodoController {
	
	

	@Autowired
	TodoService todoService;
	
	@Autowired
	TodoRepository todoRepo;
	
	@InitBinder
	public void dateBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	@RequestMapping(value = "/list-todos",method = RequestMethod.GET)
	public String showUserTodos(ModelMap model) {
		//String user = getLoggedInUserName(model);
		String user = getLoggedInUserName();
		//model.put("todos",todoService.getTodos(user));
		List<Todo> listOfTodos = todoRepo.findAll();
		model.put("todos",listOfTodos);
		return "list-todos";
	}

//	private String getLoggedInUserName(ModelMap model) {
//		return (String)model.get("userName");
//	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		
		return principal.toString();
	}
	
	@RequestMapping(value = "/todo",method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		//model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Default Desc", new Date(), false));
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(), "Default Desc", new Date(), false));
		return "todo";
	}
	
	
	@RequestMapping(value = "/todo",method = RequestMethod.POST)
	public String addTodos(ModelMap model,@Valid Todo todo,BindingResult bindingResult) {
		
		Todo todo2 = new Todo();
		
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		
		todo2.setUser(getLoggedInUserName());
		todo2.setDesc(todo.getDesc());
		todo2.setTargetDate(todo.getTargetDate());
		todoRepo.save(todo2);
		//todoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
		//todoService.addTodo(getLoggedInUserName(), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		//Optional<Todo> todo2 = todoService.getTodo(id);
		Optional<Todo> todo2 = todoRepo.findById(id);
		model.put("todo",todo2);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult bindingResult) {
		//todo.setUser(getLoggedInUserName(model));
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		//todoService.updateTodo(todo);
		todoRepo.save(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		//todoService.deleteTodo(id);
		todoRepo.deleteById(id);
		return "redirect:/list-todos";
	}
}
