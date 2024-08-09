package br.com.tkzi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.constantes.RabbitmqConstantes;
import br.com.tkzi.domain.dto.EstoqueDTO;
import br.com.tkzi.domain.service.RabbitmqService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	
	@PutMapping
	private ResponseEntity<EstoqueDTO> alteraEstoque(@RequestBody EstoqueDTO estoqueDTO){
		rabbitmqService.publish(RabbitmqConstantes.FILA_ESTOQUE, estoqueDTO);
		return ResponseEntity.ok().build();
	}

}
