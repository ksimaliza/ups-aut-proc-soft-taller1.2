package com.example.demodocker;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class DemoDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDockerApplication.class, args);
	}

	@GetMapping
	public String hola() {
		return "redirect:/users";
	}

	@RequestMapping(value = "/users")
	public String getUsers(Model model) {
		String url = "https://jsonplaceholder.typicode.com/users";
		RestTemplate restTemplate = new RestTemplate();
		Object[] usersObjects = restTemplate.getForObject(url, Object[].class);
		model.addAttribute("userList", usersObjects);
		model.addAttribute("fecha", new Date());
		return "users";
	}

}
