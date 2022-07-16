package com.qatar.proyecto.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qatar.proyecto.entities.Jackpot;
import com.qatar.proyecto.repositories.IJackpotRepository;
import com.qatar.proyecto.services.IJackpotService;

@Service("jackpotService")
public class JackpotService implements IJackpotService{
	
	@Autowired
	@Qualifier("jackpotRepository")
	private IJackpotRepository jackpotRepository;

	@Override
	public List<Jackpot> getAll() {
		return jackpotRepository.findAll();
	}

	@Override
	public List<Jackpot> buscarJackpotsPorIdUsuario(Long id) {
		return jackpotRepository.buscarJackpotsPorIdUsuario(id);
	}

	@Override
	@Transactional
	public int eliminarJackpotPorUsuario(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
}	
