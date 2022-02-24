package com.palmerson.cotizador.repository.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.palmerson.cotizador.model.Stock;
import com.palmerson.cotizador.repository.CotizadorRepository;

import lombok.AllArgsConstructor;

	@Service
	@AllArgsConstructor
	public class CotizadorServicesImpl implements CotizadorServices{
		
		private final CotizadorRepository cotiRepo;

		@Override
		public Stock saveVechicle(Stock vehicle) {
			return cotiRepo.save(vehicle);
		}

		@Override
		public Optional<Stock> getSecuence(String idSecuence) {
			
			Optional<Stock> opSecuence = cotiRepo.findById(idSecuence);
			
			return opSecuence;
		}

//		@Override
//		public Stock secuenceMaj(Integer id, Stock secuenciaMaj) {
//			
//			Stock secuenceToMaj = cotiRepo.findById(id).get();
//			secuenceToMaj.setSecuencia(secuenciaMaj.getSecuencia());
//			cotiRepo.save(secuenceToMaj);
//			return null;
//		}

		@Override
		public boolean deleteSecuence(String id) {
			
			cotiRepo.deleteById(id);
				return true;
			
		}

		@Override
		public ArrayList<Stock> getAllVehicles() {
			
			ArrayList<Stock> listToIterate = new ArrayList<>();
			
			Iterable<Stock> stockList = cotiRepo.findAll();
			
			stockList.forEach(stocks -> {
				listToIterate.add(stocks);
			});
			
			return listToIterate;
		}

		@Override
		public Stock secuenceMaj(String id, Stock secuencia) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Stock> getByModelo(String modelo) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean findMutants(List<String> secuences) {
			// TODO Auto-generated method stub
			return false;
		}
		
//		public ArrayList<Stock> getBySecuence(String secuencia) {
//			return cotiRepo.findBySecuencia(secuencia);
//		}
		
//		public boolean findMutants(List<String> secuences) {
//			
//			AdnCode code = new AdnCode();
//			
//			ArrayList<String> secuenceValidated = new ArrayList<String>();
//			
//			
//			for(String secuencia : secuences){
//				
//				
//				ArrayList<Long> secuenceList = new ArrayList<Long>();
//				code.setCodeA(secuencia.chars().filter(x -> x == 'A').count());
//				secuenceList.add(code.getCodeA());
//				
//				code.setCodeT(secuencia.chars().filter(x -> x == 'T').count());
//				secuenceList.add(code.getCodeT());
//				
//				code.setCodeC(secuencia.chars().filter(x -> x == 'C').count());
//				secuenceList.add(code.getCodeC());
//				
//				code.setCodeG(secuencia.chars().filter(x -> x == 'G').count());
//				secuenceList.add(code.getCodeG());
//				
//				if(validateSecuence(secuenceList)) {
//					
//					secuenceValidated.add(secuencia);
//				}
//				
//				if(secuenceValidated.size() >= 2) {
//					
//					return true;
//				}
//			}
//			
//			return false;
//			
//			
//		}
//		
//		public boolean validateSecuence(ArrayList<Long> secuenceList) {
//			
//			for(Long secuenceCount : secuenceList) {
//				
//				if(secuenceCount >= 4) {
//					
//					return true;
//				}
//				
//			}
//			
//			return false;
//		}


	}


