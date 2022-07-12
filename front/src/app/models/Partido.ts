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
  resultadoPartido?: {
    golesEquipo1:number,
    golesEquipo2:number,
    result:string,
  } | null;
}