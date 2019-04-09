package com.example.scutaru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
class DemoRestController {

	@GetMapping("")
	public String index() {
		return "Hello World!";

	}
}
