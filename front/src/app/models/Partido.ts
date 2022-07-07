import { Equipo } from './Equipo';

export interface Partido {
  idPartido: number;
  fasePartido: string,
  equiposPartido: [
    {
      equipo1: Equipo;
    },
    {
      equipo2: Equipo;
    }
  ];
  estadioPartido:string;
  fechaPartido: string;
  statusPartido: string;
  resultadoPartido: [
    { equipo1Goles: number }, 
    { equipo2Goles: number }] | null;
}