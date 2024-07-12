package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.EmpRepo;
import com.bean.EmployeeBean;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(EmployeeBean e)
	{
		repo.save(e);
	}
	
	public List<EmployeeBean> getAllEmp()
	{
		return repo.findAll();
	}
	
	public EmployeeBean getEmpById(int id)
	{
		Optional<EmployeeBean> e = repo.findById(id);
		if(e.isPresent()) {
		return e.get();
		}
		
		return null;
		
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}
	
}
