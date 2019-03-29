package application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class DefaultController {


	public DefaultController(){


	}

	@PostMapping("/default")
	public ResponseEntity<String> defaultMethod() {


		return ResponseEntity.ok("Ok");

	}

}
