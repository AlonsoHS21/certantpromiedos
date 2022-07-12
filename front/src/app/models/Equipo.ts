import { Jugador } from './Jugador';

export interface Equipo {
  idEquipo: number;
  nombre: string;
  direccionImagen: string;
  jugadores?: Jugador[];
}
