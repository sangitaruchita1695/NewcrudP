package com.cjc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Student;
import com.cjc.service.ServiceI;

@RestController
@RequestMapping("/controller")
@CrossOrigin("*")
public class Homecontroller 
{
	@Autowired
	ServiceI si;

	@PostMapping("/post")
	public String prelogin(@RequestBody Student s)
	{
		Student s1=si.prelogin(s);
		return "save data";
	}
	
	@GetMapping("/get/{rollno}")
	public Student getdata(@RequestBody Student s, @PathVariable  Integer rollno)
	{
		Student s1=si.getdata(rollno);
		
		return s1;
	}
	
	@PostMapping("/save")
	public String savestudent(@RequestBody List<Student> s)
	{
		si.savedata(s);
		return "data saved";
	}
	
	@GetMapping("/getalldata")
	public List<Student> gatalldata()
	{
		List<Student> l=si.getalldata();
		return l;
	}
	
	@GetMapping("/log/{user}/{pass}")
	public  List<Student> login(@PathVariable("user")String user, @PathVariable("pass")String pass)
	{
		if (user.equals("admin") && pass.equals("admin"))
		{
			List<Student> l=si.getalldata();
			return l;
		}
		else
		{
			List<Student> l=si.loginstudent(user,pass);
			if (!l.isEmpty()) {
				List<Student> l1 = si.loginstudent(user, pass);
			
			return l1;
		}
	}
		return null;
	
	
	}
}

