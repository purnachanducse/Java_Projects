package com.boot.web.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boot.web.model.Todo;
import com.boot.web.services.TodoService;

@Controller
@SessionAttributes("userName")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping(value = "/list-todos",method = RequestMethod.GET)
	public String showUserTodos(ModelMap model) {
		String user = (String)model.get("userName");
		model.put("todos",todoService.getTodos(user));
		return "list-todos";
	}
	
	@RequestMapping(value = "/todo",method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String)model.get("userName"), "Default Desc", new Date(), false));
		return "todo";
	}
	
	
	@RequestMapping(value = "/todo",method = RequestMethod.POST)
	public String addTodos(ModelMap model,@Valid Todo todo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String)model.get("userName"), todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Optional<Todo> todo2 = todoService.getTodo(id);
		model.put("todo",todo2);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
}
