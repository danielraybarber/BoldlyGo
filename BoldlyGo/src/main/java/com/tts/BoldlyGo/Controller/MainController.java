package com.tts.BoldlyGo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/api/hello")
	public String hello() {
		return "Hello WorldS!";
	}
}
