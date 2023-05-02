package com.example.securitymaster.security.annotation;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.securitymaster.security.SecurityRoles.ROLES_ADMIN;
import static com.example.securitymaster.security.SecurityRoles.ROLE_PREFIX;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Secured(ROLE_PREFIX + ROLES_ADMIN)
public @interface SuperAdmin {
}
