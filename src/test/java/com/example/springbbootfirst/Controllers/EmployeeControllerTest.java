package com.example.springbbootfirst.Controllers;

import com.example.springbbootfirst.Models.RegisterDetails;
import com.example.springbbootfirst.Services.EmployeeService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute(){
        String result = employeeController.sample();
        assertEquals("Welcome to SPRING-BOOT Security Features",result);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeService.getAllEmployees();
        assertEquals(2,result.size());
    }
}