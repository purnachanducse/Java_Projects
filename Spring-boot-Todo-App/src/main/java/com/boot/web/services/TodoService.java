package com.boot.web.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.boot.web.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	List<Todo> filteredTodos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(1, "chandu", "Spring Boot", new Date(), false));
		todos.add(new Todo(2, "purna", "Spring Microservices", new Date(), false));
		todos.add(new Todo(3, "Ram", "Hands on Microservices", new Date(), false));
	}
	
	public void addTodo(String user,String desc,Date targetDate,boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}
	
	public List<Todo> getTodos(String user){
		filteredTodos = todos.stream().filter(todo -> todo.getUser().equals(user)).collect((Collectors.toList()));
		return filteredTodos;
	}
	
	public Optional<Todo> getTodo(int id){
		Predicate<Todo> predicate = Todo -> Todo.getId() == id;
		Optional<Todo> todo2 = todos.stream().filter(predicate).findAny();
		return todo2;
	}
	
	public void updateTodo(Todo todo){
		todos.remove(todo);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		/*
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
		*/
		Predicate<Todo> condPredicate = Todo -> Todo.getId() == id;
		todos.removeIf(condPredicate);
	}
}
