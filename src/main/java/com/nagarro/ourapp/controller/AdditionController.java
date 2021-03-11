package com.nagarro.ourapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdditionController {
	 String findAge(int current_date, int current_month, 
            int current_year, int birth_date, 
            int birth_month, int birth_year) 
{ 
int month[] = { 31, 28, 31, 30, 31, 30, 31,  
                     31, 30, 31, 30, 31 }; 
if (birth_date > current_date) { 
    current_month = current_month - 1; 
    current_date = current_date + month[birth_month - 1]; 
} 

if (birth_month > current_month) { 
    current_year = current_year - 1; 
    current_month = current_month + 12; 
} 

int calculated_date = current_date - birth_date; 
int calculated_month = current_month - birth_month; 
int calculated_year = current_year - birth_year; 

String ss="You are "+calculated_year+" Year "+calculated_month+" months and "+calculated_date+" days Old";
return ss;
} 
	@RequestMapping(value="/add")
    public ModelAndView getAdditionResult(HttpServletRequest request,HttpServletResponse response)
    {
    	ModelAndView mv=new ModelAndView();
    	int a= Integer.parseInt(request.getParameter("t1"));
    	int b= Integer.parseInt(request.getParameter("t2"));
    	int c= Integer.parseInt(request.getParameter("t3"));
    	
    	String ss=java.time.LocalDate.now().toString();  
    	String dateParts[] = ss.split("-");
    	int  year  = Integer.parseInt(dateParts[0]);
    	int month  = Integer.parseInt(dateParts[1]);
    	int day = Integer.parseInt(dateParts[2]);
    	mv.addObject("result",findAge(day, month, year, a, b, c));
    	mv.setViewName("add-result");
    	return mv;
    }
}
