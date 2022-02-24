package com.palmerson.cotizador.repository;

import java.util.ArrayList;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.palmerson.cotizador.model.Stock;

@Repository
public interface CotizadorRepository extends ElasticsearchRepository<Stock, String> {
	
	public abstract ArrayList<Stock> findByModelo(String modelo);
	
}
