import { Equipo } from "./Equipo";

export interface Jugador{
    idJugador: number,
    nombre: string,
    apellido: string,
    goles: number,
    equipo: Equipo
}