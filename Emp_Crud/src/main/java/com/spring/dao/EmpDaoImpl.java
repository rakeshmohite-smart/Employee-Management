package com.spring.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void saveEmp(Emp emp) {
		hibernateTemplate.saveOrUpdate(emp);
	}

	@Override
	public Emp getEmpById(Long id) {
	Emp emp = hibernateTemplate.get(Emp.class, id);
		return emp;
	}

	@Override
	public List<Emp> getAllEmp() {
	List<Emp> list = hibernateTemplate.loadAll(Emp.class);
		return list ;
	}

	@Override
	@Transactional
	public void update(Emp emp) {
		
		hibernateTemplate.update(emp);
	}

	@Override
	@Transactional
	public void deleteEmp(long id) {
		Emp emp = hibernateTemplate.get(Emp.class, id);
		hibernateTemplate.delete(emp);
		
		
	}

}
