package agilethought.internship.abolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import agilethought.internship.abolio.domain.CreateCVResponse;
import agilethought.internship.abolio.model.CV;
import agilethought.internship.abolio.service.CVService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cv-api/cv/abolio/")
public class Controller {

	@Autowired
	private CVService service;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", produces = "application/json")
	public CV getById(@PathVariable String id) throws Exception {
		log.info("Getting CV with id: " + id);
		return service.getById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = "application/json")
	public List<CV> getAll() throws Exception {
		return service.getAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = "application/json", produces = "application/json")
	public CreateCVResponse createCV(@RequestBody CV request) {
		log.info("Creating CV...");
		log.debug("Creating CV using request: " + request);
		return service.createCV(request);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public void updateCV(@RequestBody CV request, @PathVariable String id) throws Exception {
		log.info("Updating CV with id: " + id);
		log.debug("Updating CV with id: " + id + " and request: " + request);
		service.updateCV(request, id);
	}

}