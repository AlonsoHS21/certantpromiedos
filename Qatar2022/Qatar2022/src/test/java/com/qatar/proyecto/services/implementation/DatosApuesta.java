package com.qatar.proyecto.services.implementation;

import com.qatar.proyecto.entities.Apuesta;
import com.qatar.proyecto.entities.Equipo;
import com.qatar.proyecto.entities.Partido;
import com.qatar.proyecto.entities.Usuario;

public class DatosApuesta {
	
	public static final Equipo EQUIPO1 = new Equipo(1L, "Argentina");
	public static final Equipo EQUIPO2 = new Equipo(2L, "Brasil");
	
	public static final Partido PARTIDO = new Partido(1L, "Grupo A", "Qatar", "2022/09/30T23:00","Abierta",1L, 2L);
	
	public static final Usuario USUARIO1 = new Usuario(1L,"Huarcaya", "1", "rhuarcaya@certant.com", "Alonso", 0);
	public static final Usuario USUARIO2 = new Usuario(2L,"Osores", "1", "fosores@certant.com", "Franco", 0);
	public static final Usuario USUARIO3 = new Usuario(3L,"Wolf", "1", "mwolf@certant.com", "Marcelo", 0);
	
	public static final Apuesta APUESTA1 = new Apuesta(1L,2,3,PARTIDO,USUARIO1);
	public static final Apuesta APUESTA2 = new Apuesta(2L,3,3,PARTIDO,USUARIO2);
	public static final Apuesta APUESTA3 = new Apuesta(3L,3,3,PARTIDO,USUARIO3);
	
}
