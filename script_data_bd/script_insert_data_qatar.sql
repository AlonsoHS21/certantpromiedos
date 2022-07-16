use qatar;

# -------------------------- INSERT INTO JACKPOT --------------------------
/*
   CAMPEONES   		 GOLEADORES
 1 - Argentina        1 - 10
 2 - Brasil			  1 - 10
 3 - Francia 		  1 - 10
 4 - España			  1 - 10
*/
insert into jackpot(id_jackpot, id_campeon, id_goleador) values (1,4,1);
insert into jackpot(id_jackpot,id_campeon,id_goleador) values (2,2,1);
insert into jackpot(id_jackpot, id_campeon, id_goleador) values (3,3,1);
insert into jackpot(id_jackpot,id_campeon,id_goleador) values (4,1,1);

# -------------------------- INSERT INTO USUARIO --------------------------

#USUARIO HUARCAYA APOSTO QUE GANA ESPAÑA
insert into usuario (id, apellido,contrasenia, email, nombre, puntos, jackpot_id_Jackpot) values (1,"Huarcaya", "1", "rhuarcaya@certant.com", "Alonso", 0, 4);
#USUARIO OSORES APOSTO QUE GANA BRASIL
insert into usuario (id, apellido,contrasenia, email, nombre, puntos, jackpot_id_Jackpot) values (2,"Osores", "1", "fosores@certant.com", "Franco", 0, 2);
#USUARIO WOLF APOSTO QUE GANA ARGENTINA
insert into usuario (id, apellido,contrasenia, email, nombre, puntos, jackpot_id_Jackpot) values (3,"Wolf", "1", "mwolf@certant.com", "Marcelo", 0, 1);
#USUARIO DIAZ NO APOSTO
insert into usuario (id, apellido,contrasenia, email, nombre, puntos) values (4,"Diaz", "1", "mdiaz@certant.com", "Marcelo", 0);

# -------------------------- INSERT INTO EQUIPO --------------------------

#EQUIPO 1 ARGENTINA
insert into equipo (id_equipo, direccion_imagen, nombre) values (1,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/200px-Flag_of_Argentina.svg.png", "Agentina");
#EQUIPO 2 BRASIL
insert into equipo (id_equipo, direccion_imagen, nombre) values (2,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/300px-Flag_of_Brazil.svg.png", "Brasil");
#EQUIPO 3 FRANCIA
insert into equipo (id_equipo, direccion_imagen, nombre) values (3,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/270px-Flag_of_France.svg.png", "Francia");
#EQUIPO 4 ESPAÑA
insert into equipo (id_equipo, direccion_imagen, nombre) values (4,"https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Bandera_de_Espa%C3%B1a_1978.png/1024px-Bandera_de_Espa%C3%B1a_1978.png", "España");

# -------------------------- INSERT INTO JUGADOR --------------------------
#ARGENTINA
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo, dorsal) values (1,"Martinez",0,"Emiliano",1,23);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo, dorsal) values (2,"Armani",0,"Franco",1,1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (3,"Montiel",0,"Gonzalo",1,4);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (4,"Molina",0,"Nahuel",1,26);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (5,"Foyth",0,"Juan",1,2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo, dorsal) values (6,"Pezella",0,"Germán",1,6);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo, dorsal) values (7,"Di María",0,"Angel",1,11);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (8,"De Paul",0,"Rodrigo",1,7);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (9,"Messi",0,"Lionel",1,10);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (10,"Alvarez",0,"Julian",1,9);

#BRASIL
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (11,"da Silva Santos Junior",0,"Neymar",2,10);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (12,"Junior",0,"Vinicius",2,20);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (13,"Militao",0,"Eder",2,2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (14,"Sandro",0,"Alex",2,6);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (15,"Paquetá",0,"Lucas",2,7);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (16,"Casemiro",0,"Carlos Henrique",2,5);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (17,"Cunha",0,"Matheus",2,21);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (18,"De Andrade",0,"Richarlison",2,9);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (19,"Coutinho",0,"Philippe",2,11);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (20,"Goes",0,"Rodrygo",2,23);

#FRANCIA
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (21,"Lloris",0,"Hugo",3,1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (22,"Maignan",0,"Mike",3,16);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (23,"Pavard",0,"Benjamin",3,2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (24,"Kimpembe",0,"Presnel",3,3);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (25,"Koundé",0,"Jules",3,5);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (26,"Lenglet",0,"Clément",3,19);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (27,"Umtiti",0,"Samuel",3,22);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (28,"Pogba",0,"Paul",3,6);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (29,"Benzema",0,"Karim",3,19);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (30,"Mbappé",0,"kylian",3,10);

#ESPAÑA
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (31,"Simón",0,"Unai",4,1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (32,"Arrizabalaga",0,"Kepa",4,23);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (33,"Torres",0,"Pau",4,4);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (34,"Roberto",0,"Sergi",4,6);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (35,"Alonso",0,"Marcos",4,17);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (36,"Carvajal",0,"Dani",4,20);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (37,"Llorente",0,"Marcos",4,6);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (38,"Asensio",0,"Marco",4,16);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (39,"Alarcon",0,"Isco",4,22);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo , dorsal) values (40,"Sarabia",0,"Pablo",4,24);

# -------------------------- INSERT INTO PARTIDO --------------------------

#CREAMOS UN PARTIDO DESDE THYMELEAF
# ID PARTIDO 1 - ARGENTINA - BRASIL
# ID PARTIDO 1 - ESPAÑA - FRANCIA

# -------------------------- INSERT INTO APUESTA --------------------------

#USUARIO HUARCAYA APOSTO ESPAÑA 3 - FRANCIA 4 
insert into apuesta(id_apuesta, goles_equipo1, goles_equipo2,id_partido, usuario_id_usuario) values (1,3,4,2,1);
#USUARIO OSORES APOSTO ARGENTINA 2 - BRASIL 1 
insert into apuesta(id_apuesta, goles_equipo1, goles_equipo2,id_partido, usuario_id_usuario) values (2,2,1,1,2);
#USUARIO WOLF APOSTO ARGENTINA 3 - BRASIL 1
insert into apuesta(id_apuesta, goles_equipo1, goles_equipo2,id_partido, usuario_id_usuario) values (3,3,1,1,3);
#USUARIO HUARCAYA APOSTO ARGENTINA 1 - BRASIL 2
insert into apuesta(id_apuesta, goles_equipo1, goles_equipo2,id_partido, usuario_id_usuario) values (4,1,2,1,1);
#USUARIO WOLF APOSTO ESPAÑA 2 - FRANCIA 1
insert into apuesta(id_apuesta, goles_equipo1, goles_equipo2,id_partido, usuario_id_usuario) values (5,2,1,2,3);





