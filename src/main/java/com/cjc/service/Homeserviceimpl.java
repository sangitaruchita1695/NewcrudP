package com.cjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Student;
import com.cjc.repositary.RepositaryI;

@Service
public class Homeserviceimpl implements ServiceI
{
	@Autowired
	RepositaryI r;

	

	@Override
	public Student prelogin(Student s) 
	{
		// TODO Auto-generated method stub
		return r.save(s);
	}



	@Override
	public Student getdata(int rollno) 
	{
		// TODO Auto-generated method stub
		return r.findByRollno(rollno);
		
	}



	@Override
	public int savedata(List<Student> s) 
	{
		r.saveAll(s);
		return  1;
	}



	@Override
	public List<Student> getalldata() 
	{
		List<Student> l=(List<Student>) r.findAll();
		return l;
	}



	@Override
	public List<Student> loginstudent(String user, String pass) 
	{
		List<Student> l=(List<Student>) r.findAllByUserAndPass(user, pass);
		
		return l;
	}

}
