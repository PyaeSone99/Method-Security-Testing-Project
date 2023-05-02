package com.example.securitymaster.controller;

import com.example.securitymaster.dao.CustomerDao;
import com.example.securitymaster.ds.Customer;
import com.example.securitymaster.security.annotation.customer.CustomersCreate;
import com.example.securitymaster.security.annotation.customer.CustomersDelete;
import com.example.securitymaster.security.annotation.customer.CustomersRead;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    @CustomersRead
    public ModelAndView listAllCustomers(){
        return new ModelAndView("customers","customers",customerDao.findAll());
    }

    @CustomersCreate
    @GetMapping("/customer-form")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @CustomersCreate
    @PostMapping("/customer-form")
    public String customerCreate(@Valid Customer customer, BindingResult result){
        if (result.hasErrors()){
            return "customerForm";
        }
        customerDao.save(customer);
        return "redirect:/customer/customers";
    }

    @CustomersDelete
    @GetMapping("/delete")
    public String removeCustomer(@RequestParam("id") int id){
        customerDao.deleteById(id);
        return "redirect:/customer/customers";
    }

//    public String updateCustomer(@RequestParam int id,Model model){
//        model.addAttribute()
//    }
}
















