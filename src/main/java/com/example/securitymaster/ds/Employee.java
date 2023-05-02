package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "First Name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*",message = "First Name cannot contain illegal characters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*",message = "Last Name cannot contain illegal characters")
    private String lastName;

    @NotBlank(message = "Phone Number cannot be blank")
    @Pattern(regexp = "[0-9\\-+]*",message = "Phone Number cannot contain illegal characters")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address cannot contain illegal characters")
    private String address;

    @NotBlank(message = "Cubicle Number cannot be blank")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",message = "Cubicle Number cannot contain illegal characters")
    private String cubicleNo;
}
