package com.itm.ucompiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 * This is the main page of the application, 
 * it shows a welcome page to describe what is the project about
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "index";
	}
}
