package application.controller;

import core.usecases.CoreRequest;
import core.usecases.CoreResponse;
import entities.DefaultEntidade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import usecases.interactors.DefaultInteractor;

@Controller
public class DefaultController {

	private final DefaultInteractor defaultInteractor;

	public DefaultController(DefaultInteractor defaultInteractor){

		this.defaultInteractor = defaultInteractor;
	}

	@PostMapping("/default")
	public ResponseEntity<CoreResponse<DefaultEntidade>> defaultMethod(DefaultEntidade entidade) {

		CoreResponse<DefaultEntidade> execute = defaultInteractor.execute(new CoreRequest<>(entidade));
		return ResponseEntity.ok(execute);
	}
}
