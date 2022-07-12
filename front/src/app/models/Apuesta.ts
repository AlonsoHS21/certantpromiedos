import { Partido } from "./Partido";

export interface Apuesta{
    apuestaId: number,
    golesEquipo1: number,
    golesEquipo2: number,
    partido:Partido,
}
