package com.thiagosoares.futebol.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiagosoares.futebol.model.Clube;
import com.thiagosoares.futebol.repositories.ClubeRepository;
import com.thiagosoares.futebol.services.ClubeService;

@RestController
@RequestMapping("/clubes")
public class ClubeResource {

	@Autowired
	private ClubeService clubeService;

	@Autowired
	private ClubeRepository clubeRepository;

	@GetMapping
	public List<Clube> listar() {
		List<Clube> clubes = clubeRepository.findAll();
		return clubes;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Clube clube = clubeService.findClube(id);
		return ResponseEntity.ok().body(clube);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Clube obj) {
		clubeService.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
