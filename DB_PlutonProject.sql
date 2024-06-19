create database db_InstitutoPluton;
use db_InstitutoPluton;

#--------------------------------Tablas-------------------------------#

#Tabla Aulas:
create table Aulas(
codAula char(5) not null,
pisoAula int not null,
cantidadAlumnosAula int,
estadoAula char(12) not null,
Primary key (codAula)
);

#Tabla Alumnos:
create table Alumnos(
codAlumno char(7) not null,
nombresAlumno varchar(255) not null,
apellidosAlumno varchar(255) not null,
edadAlumno int not null,
codAulaAlumno char(5) not null,
gradoAlumno char (2) not null,
sectionAlumno char (1) not null,
nota1 real,
nota2 real,
nota3 real,
Primary Key (codAlumno),
Foreign key (codAulaAlumno) references Aulas(codAula)
);

insert into Aulas values ('AU101', 1, 0, 'HABILITADA');
insert into Aulas values ('AU102', 1, 0, 'HABILITADA');
insert into Aulas values ('AU201', 2, 0, 'INHABILITADA');
insert into Aulas values ('AU202', 2, 0, 'HABILITADA');
insert into Aulas values ('AU301', 3, 0, 'INHABILITADA');
insert into Aulas values ('AU302', 3, 0, 'HABILITADA');

#Tabla Usuarios:
create table Usuarios(
codUsuario char(7) not null,
passwordUsuario varchar(255),
Primary Key (codUsuario)
);
insert into Usuarios values ('SEC1001', 12345);
insert into Usuarios values ('SEC1002', 123);
insert into Usuarios values ('DOC1001', 333);
insert into Usuarios values ('DOC1002', 25626);
insert into Usuarios values ('DOC1003', 456);
insert into Usuarios values ('DOC1004', 1009);

#Tabla Docentes:
create table Docentes(
codDocente char(7) not null,
nombresDocente varchar(255) not null,
apellidosDocente varchar(255) not null,
telfDocente int,
edadDocente int not null,
codAulaDocente char(5),
Primary Key (codDocente),
Foreign Key (codDocente) references Usuarios(codUsuario),
Foreign Key (codAulaDocente) references Aulas(codAula)
);

insert into Docentes values ('DOC1001', 'Aldo', 'Tapia Rojas', 375904111, 30, 'AU101');
insert into Docentes values ('DOC1002', 'Laura Paula', 'Torrez Benavides', 915833666, 63, 'AU102');
insert into Docentes values ('DOC1003', 'Alvaro', 'Quevedo Vilca', 910583000, 46, 'AU202');
insert into Docentes values ('DOC1004', 'César', 'Armas Ortiz', 997123765, 50, 'AU302');

#Tabla Secretarias:
create table Admins(
codAdmin char(7) not null,
nombresAdmin varchar(255) not null,
apellidosAdmin varchar(255) not null,
telfAdmin int,
edadAdmin int not null,
Primary Key (codAdmin),
Foreign Key (codAdmin) references Usuarios(codUsuario)
);

insert into Admins values ('SEC1001', 'Andrea Mabel', 'Trinidad Benavides', 967281943, 25);
insert into Admins values ('SEC1002', 'María Fernanda', 'Arce Torres', 925837555, 30);


create table Historial(
executeDate date not null,
executeTime time not null,
codExecutor char(7) not null,
codAffected char(7),
executeDescription varchar(255) not null,
Foreign Key (codExecutor) references Usuarios(codUsuario)
);

create table UserIniciado(
codIniciado char(7),
nombresIniciado varchar(255),
apellidosIniciado varchar(255),
telfIniciado int,
edadIniciado int not null,
aulaIniciado char(5),
Foreign Key (codIniciado) references Usuarios(codUsuario)
);

#--------------------------------Procedimientos-------------------------------#

#Para mostrar Aulas:
create procedure aula_Listar()
select * from Aulas;

#Para cambiar el estado del  Aula:
DELIMITER //
create procedure aula_Cambiar_Estado(
aula char (5),
aulaStatus varchar (12))
Begin
update Aulas set estadoAula = aulaStatus
where codAula = aula;
End //
DELIMITER ;

#Para mostrar los Alumnos:
create procedure alumnos_Listar()
select * from Alumnos;

#Para registrar nuevos Alumnos en el sistema
DELIMITER //
create procedure alumno_Insertar(
nombres varchar(255),
apellidos varchar(255),
edad int,
codAula varchar(7)
)
Begin
#Variables:
declare max_cod varchar(7);
declare nuevo_cod varchar(7);
select MAX(codAlumno) from Alumnos into max_cod;
set max_cod = ifnull(max_cod, 'AL9999');
set nuevo_cod = CONCAT('AL', CAST(SUBSTRING(max_cod,3,6) AS SIGNED) +1);
insert into Alumnos values (nuevo_cod, nombres, apellidos, edad, codAula, 0, 0, 0);
End //
DELIMITER ;

#Procedimiento para que Admin edite SOLO nombre, apellidos, edad y/o código de Aula del Alumno
DELIMITER //
create procedure admin_EditarAlumno(
codAlumnoEditar char(7),
nombresNuevo varchar(255),
apellidosNuevo varchar(255),
edadNuevo int,
codAulaNuevo varchar(5)
)
Begin
declare old_nombres varchar(255);
declare old_apellidos varchar(255);
declare old_edad int;
declare old_codAula varchar(5);
select nombres, apellidos, edad, codAula into old_nombres, old_apellidos, old_edad, old_codAula
from Alumnos where codAlumno = codAlumnoEditar;
if nombresNuevo = '.' then set nombresNuevo = old_nombres;
end if;
if apellidosNuevo = '.' then set apellidosNuevo = old_apellidos;
end if;
if edadNuevo=0 then set edadNuevo = old_edad;
end if;
if codAulaNuevo='.' then set codAulaNuevo = old_codAula;
end if;
update Alumnos set nombre = nombresNuevo, apellidos = apellidosNuevo, edad = edadNuevo, codAula = codAulaNuevo
where codAlumno = codAlumnoEditar;
End //
DELIMITER ;

#Procedimiento para que Docente edite SOLO Nota1, Nota2 y/o Nota3
DELIMITER //
create procedure docente_EditarNotasAlumno(
codAlumnoEditarNotas char(7),
n1 real,
n2 real,
n3 real)
Begin
update Alumnos set nota1 = n1, nota2 = n2, nota3 = n3
where codAlumno = codAlumnoEditarNotas;
END //
DELIMITER ;

#Procedimiento para Eliminar un Alumno por su Código de Alumno
create procedure alumno_Eliminar(
cod char(7))
delete from Alumnos where codAlumno = cod;

#Procedimiento para mostrar el Historial, en orden desde lo MÁS RECIENTE hacia abajo
create procedure historial_Listar()
SELECT * FROM Historial ORDER BY executeDate DESC, executeTime DESC;

#Procedimiento para que solo exista un registro en la tabla
#y se actualice cuando algun ADMIN inice sesión
#Solo pide el idUsuario.
DELIMITER //
create procedure admin_Login(
codUser varchar(7)
)
Begin
declare nombresLogged varchar(255);
declare apellidosLogged varchar(255);
declare telfLogged int;
declare edadLogged int;
select nombresAdmin from admins where codAdmin = codUser into nombresLogged;
select apellidosAdmin from admins where codAdmin = codUser into apellidosLogged;
select telfAdmin from admins where codAdmin = codUser into telfLogged;
select edadAdmin from admins where codAdmin = codUser into edadLogged;
delete from UserIniciado;
insert into UserIniciado values (codUser, nombresLogged, apellidosLogged, telfLogged, edadLogged, null);
End //
DELIMITER ;
#Procedimiento para que solo exista un registro en la tabla
#y se actualice cuando algun DOCENTE inice sesión
#Solo pide el idUsuario.
DELIMITER //
create procedure docente_Login(
codUser varchar(7)
)
Begin
declare nombresLogged varchar(255);
declare apellidosLogged varchar(255);
declare telfLogged int;
declare edadLogged int;
declare aulaLogged varchar(5);
select nombresDocente from docentes where codDocente = codUser into nombresLogged;
select apellidosDocente from docentes where codDocente = codUser into apellidosLogged;
select telfDocente from docentes where codDocente = codUser into telfLogged;
select edadDocente from docentes where codDocente = codUser into edadLogged;
select codAulaDocente from docentes where codDocente = codUser into aulaLogged;
delete from UserIniciado;
insert into UserIniciado values (codUser, nombresLogged, apellidosLogged, telfLogged, edadLogged, aulaLogged);
End //
DELIMITER ;

#--------------------------------Triggers-------------------------------#

#Trigger (disparador) para que cuando se REGISTRE un Alumno se muestre en la tabla Historial
DELIMITER //
create trigger tr_alumno_Registrado
after insert on Alumnos
for each row
Begin
declare codUsuario varchar(7);
select codIniciado from useriniciado into codUsuario;
Insert into Historial values (curdate(), curtime(), codUsuario, NEW.codAlumno,'Alumno Registrado');
END //
DELIMITER ;

#Trigger (disparador) para que cuando se EDITE un Alumno se muestre en la tabla Historial
DELIMITER //
create trigger tr_alumno_Editado
before update on Alumnos
for each row
Begin
declare codUsuario varchar(7);
select codIniciado from useriniciado into codUsuario;
Insert into Historial values (curdate(), curtime(), codUsuario, OLD.codAlumno, 'Alumno Editado');
END //
DELIMITER ;

#Trigger (disparador) para que cuando se ELIMINE un Alumno se muestre en la tabla Historial
DELIMITER //
create trigger tr_alumno_Eliminado
before delete on Alumnos
for each row
Begin
declare codUsuario varchar(7);
select codIniciado from useriniciado into codUsuario;
Insert into Historial values (curdate(), curtime(), codUsuario, OLD.codAlumno ,'Alumno Eliminado');
END //
DELIMITER ;

#Trigger (disparador) para que cuando se INICIE SESIÓN un Usuario se muestre en la tabla Historial
create trigger tr_user_Logged
after insert on userIniciado
for each row
Insert into Historial values (curdate(), curtime(), NEW.codIniciado, '---', 'Inició Sesión');

#Trigger (disparador) para que cuando se cambie el Estado de un Aula, aparezca en el Historial
DELIMITER //
create trigger tr_aula_CambioDeEstado
after update on aulas
for each row
Begin
declare codUsuario varchar(7);
select codIniciado from useriniciado into codUsuario;
Insert into Historial values (curdate(), curtime(),  codUsuario, OLD.codAula, 'Aula Modificada');
END //
DELIMITER ;

#Trigger (disparador) para que cuando se registre un alumno, el registro de AULAS y sus CANTIDADES
#de ALUMNOS se actualicen
DELIMITER //
create trigger tr_aula_AumentarCantidad
after insert on Alumnos
for each row
Begin
update aulas set cantidadAlumnosAula = cantidadAlumnosAula+1
where codAula = new.codAulaAlumno;
End //
DELIMITER ;

DELIMITER //
create trigger tr_aula_DisminuirCantidad
after delete on alumnos
for each row
begin
update aulas set cantidadAlumnosAula = cantidadAlumnosAula-1
where codAula = old.codAulaAlumno;
End //
DELIMITER ;estadoAula


