package com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;
@Repository
public interface EmpRepo extends JpaRepository<EmployeeBean, Integer>  {
		
}
