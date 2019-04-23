package com.vermeg.services.controller;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class AbstractController {

	URI buildLocationUri(Long id) {
	    return ServletUriComponentsBuilder
	        .fromCurrentRequest()
	        .path("/{id}")
	        .buildAndExpand(id)
	        .toUri();
	  }

}
