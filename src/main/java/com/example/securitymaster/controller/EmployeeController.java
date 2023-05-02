package com.example.securitymaster.controller;

import com.example.securitymaster.dao.EmployeeDao;
import com.example.securitymaster.ds.Employee;
import com.example.securitymaster.security.annotation.enployee.EmployeesCreate;
import com.example.securitymaster.security.annotation.enployee.EmployeesDelete;
import com.example.securitymaster.security.annotation.enployee.EmployeesRead;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    @EmployeesRead
    public ModelAndView listAllEmployee(){
        return new ModelAndView("employees","employees",employeeDao.findAll());
    }

    @GetMapping("/employee-form")
    @EmployeesCreate
    public String employeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employeeForm";
    }

    @PostMapping("/employee-form")
    @EmployeesCreate
    public String employeeCreate(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "employeeForm";
        }
        employeeDao.save(employee);
        return "redirect:/employee/employees";
    }

    @GetMapping("/delete")
    @EmployeesDelete
    public String removeEmployee(@RequestParam("id") int id){
        employeeDao.deleteById(id);
        return "redirect:/employee/employees";
    }

}

















