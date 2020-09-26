package com.cjc.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;
@Repository
public interface RepositaryI extends CrudRepository<Student, Integer>
{

	public Student findByRollno(int rollno);
	
	public Student findAllByUserAndPass(String user,String pass);

}
