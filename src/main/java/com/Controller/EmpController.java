package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EmployeeBean;
import com.service.EmpService;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		
		// for displaying the alert msg on the web page
		String msg = (String)session.getAttribute("msg");
		if(msg != null) {
			model.addAttribute("msg", msg);
			session.removeAttribute("msg");
		}
		
		List<EmployeeBean> emp =service.getAllEmp();
		model.addAttribute("emp",emp);
                        return "index";
           }
	
	@GetMapping("addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute EmployeeBean e, HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
//		session.setAttribute("msg", "Employee added successfuly");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
			
		EmployeeBean e = service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute EmployeeBean e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "sucessfullllll");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Deleted sucessfullllll");
		return "redirect:/";
	}
	
	
}
