package br.com.tkzi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.constantes.RabbitmqConstantes;
import br.com.tkzi.domain.dto.PrecoDTO;
import br.com.tkzi.domain.service.RabbitmqService;

@RestController
@RequestMapping("/preco")
public class PrecoController {
	
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@PutMapping
	private ResponseEntity<PrecoDTO> alterarPreco(@RequestBody PrecoDTO precoDTO){
		rabbitmqService.publish(RabbitmqConstantes.FILA_PRECO, precoDTO);
		return ResponseEntity.ok().build();
	}

}
