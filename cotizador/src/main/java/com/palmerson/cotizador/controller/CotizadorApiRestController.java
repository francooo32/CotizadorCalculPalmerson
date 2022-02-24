package com.palmerson.cotizador.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palmerson.cotizador.model.Stock;
import com.palmerson.cotizador.repository.services.CotizadorServices;

@RestController
@RequestMapping("/cotizar")
public class CotizadorApiRestController {
	
	@Autowired
	CotizadorServices cotizadorSrv;
	
	@GetMapping()
	public ResponseEntity<ArrayList<Stock>> getAllVechicles(@RequestParam(name="modelo", required=false) List<String> secuencia) {
		ArrayList<Stock> listVehicles = cotizadorSrv.getAllVehicles();
		
		return new ResponseEntity<>(listVehicles, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Stock> saveSecuence(@RequestBody Stock vehiculo) {
		
			cotizadorSrv.saveVechicle(vehiculo);
			return new ResponseEntity<Stock>(vehiculo, HttpStatus.OK);
		
		
	}
	
	@GetMapping( path = "/{id}")
	public ResponseEntity<Optional<Stock>> getSecuence(@PathVariable("id") String idSecuence) {
		return new ResponseEntity<>(cotizadorSrv.getSecuence(idSecuence), HttpStatus.OK);
	}
	
	@GetMapping("/query")
	public ResponseEntity<ArrayList<Stock>> findBySecuence(@RequestParam("modelo") String modelo){
		return new ResponseEntity<>(cotizadorSrv.getByModelo(modelo), HttpStatus.OK);
	}
	
//	@GetMapping("/stats")
//	public ResponseEntity<AdnDB> getStats(@RequestParam(name="secuencia", required=false) List<String> secuencia) {
//		ArrayList<Adn> ListAdnFull = cotizadorSrv.getAllSecuences();
//		ArrayList<Adn> ListMutant = new ArrayList<>();
//		ArrayList<Adn> ListHuman = new ArrayList<>();
//		
//		AdnDB adnCount = new AdnDB();
//		
//		for(Adn AdnForCount : ListAdnFull) {
//			
//			if(!AdnForCount.getMutantDNA().isEmpty()) {
//				ListMutant.add(AdnForCount);
//			}else {
//				ListHuman.add(AdnForCount);
//			}
//			
//			adnCount.setCount_mutant_dna(ListMutant.size());
//			
//			adnCount.setCount_human_dna(ListHuman.size());
//		}
//		
//		
//		return new ResponseEntity<AdnDB>(adnCount, HttpStatus.OK);
//	}
	
//	@DeleteMapping( path = "/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
//		boolean success = cotizadorSrv.deleteSecuence(id);
//		
//		if(success) {
//			return new ResponseEntity<String>("Delete complete on id " + id, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<String>("Delete failed on id " + id, HttpStatus.OK);
//		}
//		
//	}
}

