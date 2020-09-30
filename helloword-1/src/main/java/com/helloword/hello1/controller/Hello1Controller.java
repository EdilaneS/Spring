package com.helloword.hello1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello1Controller {

	@GetMapping("/hello1")
	public String hello() {
		return " \n Objetivos de Aprendizagem!!!  "
				+ "\n1-Spring \n2-Rest \n3-Metodos e Status Http \n4-Camadas";
	}
	@GetMapping("/hello2")
	public String hello1() {
		return " Foco na missão!!!";
	}
}
