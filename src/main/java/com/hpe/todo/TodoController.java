package com.hpe.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String todoPage(ModelMap model){
		
		model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String addTodo(){
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoPage(ModelMap model, @RequestParam String desc) {
		service.addTodo("in28Minutes", desc, new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoPage(ModelMap model,@RequestParam int id) {
		service.deleteTodo(id);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodoPage(ModelMap model,@RequestParam int id) {
//		service.deleteTodo(id);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
}
