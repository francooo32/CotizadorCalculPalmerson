package com.palmerson.cotizador.repository.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.palmerson.cotizador.model.Stock;

@Service
public interface CotizadorServices {
	
	
	Stock saveVechicle(Stock secuencia);
	
	Optional<Stock> getSecuence(String idSecuence);
	
	Stock secuenceMaj(String id, Stock secuencia);
	
	boolean deleteSecuence(String id);
	
	ArrayList<Stock> getAllVehicles();
	
	ArrayList<Stock> getByModelo(String modelo);
	
	boolean findMutants(List<String> secuences);
	

}
