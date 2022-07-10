use qatar;

# -------------------------- INSERT INTO USUARIO --------------------------
insert into usuario (id, apellido,contrasenia, email, nombre, puntos) values (1,"Huarcaya", "1", "rhuarcaya@certant.com", "Alonso", 0);
insert into usuario (id, apellido,contrasenia, email, nombre, puntos) values (2,"Osores", "1", "fosores@certant.com", "Franco", 0);
insert into usuario (id, apellido,contrasenia, email, nombre, puntos) values (3,"Wolf", "1", "mwolf@certant.com", "Marcelo", 0);


# -------------------------- INSERT INTO EQUIPO --------------------------

insert into equipo (id_equipo, direccion_imagen, nombre) values (1,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/200px-Flag_of_Argentina.svg.png", "Agentina");
insert into equipo (id_equipo, direccion_imagen, nombre) values (2,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/300px-Flag_of_Brazil.svg.png", "Brasil");

# -------------------------- INSERT INTO JUGADOR --------------------------
#Argentina
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (1,"Dybala",0,"Paulo",1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (2,"Messi",0,"Lionel",1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (3,"Martinez",0,"Lautaro",1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (4,"Di Maria",0,"Angel",1);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (5,"Alvarez",0,"Julian",1);

#Brasil
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (6,"da Silva Santos Junior",0,"Neymar",2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (7,"Junior",0,"Vinicius",2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (8,"dos Santos",0,"Anthony Matheus",2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (9,"Coutinho",0,"Philippe",2);
insert into jugador (id_jugador, apellido, goles, nombre, equipo_id_equipo) values (10,"Goes",0,"Rodrygo",2);