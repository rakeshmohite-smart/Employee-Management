package com.spring.dao;

import java.util.List;

import com.spring.entity.Emp;

public interface EmpDao {
	
	public void saveEmp(Emp emp);
	
	public List<Emp> getAllEmp();
	
	public void update(Emp emp);
	
	public void deleteEmp(long id);

	public Emp getEmpById(Long id);

}
