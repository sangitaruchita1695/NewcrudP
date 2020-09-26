package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface ServiceI 
{
public Student prelogin(Student s);
public Student getdata(int rollno);
public int savedata(List<Student> s);
public List<Student> getalldata() ;
public List<Student> loginstudent(String user, String pass);
}
