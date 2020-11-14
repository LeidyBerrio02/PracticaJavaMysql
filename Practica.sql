create database PracticaJavaMysql;
use PracticaJavaMysql;

create table asesor(
cedula int unique not null,
nombre varchar(45) not null,
telefono int, 
fechaNacimiento date  not null, 
genero varchar(20),
cliente varchar(45) not null,
Sede varchar(45),
edad int
);

select * from asesor;
insert into asesor  (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
values (1000233,"Juan camilo quintero",243222,'2000-02-22',"Masculino","Bancolombia","Ruta N");
insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede) 
values (2129089,"Paulin Jaramillo Quiseno",452322,'1998-05-19',"Femenino","Suramericana","Buro");

insert into asesor  (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
values (3492929,"Mateo Atheorua Muñoz",452452,'2009-01-10',"Masculino","Bancolombia","Puerto Seco");

insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
values (3423111,"Juliana Velez Zapata",875888,'2002-12-29',"Femenino","Konecta","Ruta N");

insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
values (4112322,"Carlos Velez Zapata",435243,'1994-12-01',"Femenino","Konecta","Ruta N");
 
insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (4253222,"Juan Esteban Ameno",4580656,'1949-12-31',"Masculino","Konecta","Ruta N"); 
 
insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (1028100,"Carolina Lopez Restrepo",7867999,'1989-10-11',"Femenino","Bancolombia","Ruta N"); 
 
 insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (3423222,"Brandon Jimenez oreo",7643546,'1979-07-24',"Masculino","Bancolombia","Ruta N"); 
 
 insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (6534222,"Carmen Socorro Zapata",6335433,'1994-02-27',"Femenino","CEOH","Buro"); 
 
 insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (1000248,"Esteban Restrepo Quiseno",6522211,'2001-09-24',"Masculino","Bancolombia","Ruta N"); 

 insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (1003233,"Matias Bermudez Murillo",3425677,'1995-05-05',"Masculino","CEOH","Ruta N");
 
insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
values (1003222,"Jose Pedrano Santillana",4232222,'2010-01-19',"Masculino","CEOH","Ruta N");

  insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (10008768,"Miguel Angel Santillana",8658811,'2001-11-19',"Masculino","CEOH","Ruta N");

  insert into asesor (cedula, nombre , telefono, fechaNacimiento,genero, cliente, sede)
 values (152348,"Camilo Jose Santillana",534322,'1993-03-02',"Masculino","CEOH","Ruta N");

/*select nombre, fechaNacimiento, year(now())-year(fechaNacimiento) as edad from asesor;*/

desc asesor;

select  nombre as "Nombre Asesor" , cedula  as "Cedula", telefono as "Telefono" , fechaNacimiento as "FechaNacimiento" ,
edad as "Edad", genero as Genero, Cliente, sede as "Sede de trabajo" FROM asesor ORDER BY nombre asc;

 call practicajavamysql.AsignarEdad();

/*UPDATE asesor SET cedula=148100, nombre="Marco Fidel Suares", telefono=53492820,
 fechaNacimiento='1990-11-21', genero="Masculino" , cliente="Konecta" ,sede="Buro" WHERE cedula=0;*/




/* Procedimiento almacenado
CREATE DEFINER=`root`@`localhost` PROCEDURE `AsignarEdad`()
BEGIN
update asesor set edad= (year(curdate())-year(fechaNacimiento)) where cedula;
END
*/


/*
Ignorar
create trigger AsignarEdad after insert
on asesor
for each row
update asesor set edad= (year(curdate())-year(fechaNacimiento)) where cedula;

update asesor set nombre= "Marcela Bedoya Astriz" where cedula=4112322;

drop trigger AsignarEdad;


update asesor set edad= (year(curdate())-year(fechaNacimiento)) where cedula;

UPDATE asesor SET edad=TIMESTAMPDIFF (YEAR,fechaNacimiento,DATE(NOW()))
WHERE cedula;*/
