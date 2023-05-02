package com.example.securitymaster.controller;

import com.example.securitymaster.dao.DepartmentDao;
import com.example.securitymaster.ds.Department;
import com.example.securitymaster.security.annotation.department.DepartmentsCreate;
import com.example.securitymaster.security.annotation.department.DepartmentsDelete;
import com.example.securitymaster.security.annotation.department.DepartmentsRead;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/departments")
    @DepartmentsRead
    public ModelAndView listAllDepartment(){
        return new ModelAndView("departments","departments",departmentDao.findAll());
    }

    @GetMapping("/department-form")
    @DepartmentsCreate
    public String departmentForm(Model model){
        model.addAttribute("department",new Department());
        return "departmentForm";
    }

    @PostMapping("/department-form")
    @DepartmentsCreate
    public String departmentCreate(@Valid Department department, BindingResult result){
        if (result.hasErrors()){
            return "departmentForm";
        }
        departmentDao.save(department);
        return "redirect:/department/departments";
    }

    @GetMapping("/delete")
    @DepartmentsDelete
    public String removeDepartment(@RequestParam("id") int id){
        departmentDao.deleteById(id);
        return "redirect:/department/departments";
    }
}









































