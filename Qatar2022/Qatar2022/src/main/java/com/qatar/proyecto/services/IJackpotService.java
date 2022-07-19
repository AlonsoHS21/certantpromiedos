package com.qatar.proyecto.services;

import java.util.List;

import com.qatar.proyecto.entities.Jackpot;

public interface IJackpotService {
	
	public List<Jackpot> getAll();
	
	public Jackpot buscarJackpotPorIdUsuario(Long id);
	
	public int eliminarJackpotPorUsuario(Long id);

}
