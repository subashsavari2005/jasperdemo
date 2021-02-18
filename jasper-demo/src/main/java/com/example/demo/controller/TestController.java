package com.example.demo.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/jasper")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test/{format}")
	public String getReport(@PathVariable("format") String format) throws FileNotFoundException, JRException{
		return testService.generateJasper(format);
	}

}
