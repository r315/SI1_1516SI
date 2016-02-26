use AcamPE;
/* DROP das Tabelas */
if OBJECT_ID('Hist_Precos_Alojamento', 'U') is not null	drop table Hist_Precos_Alojamento;
if OBJECT_ID('Hist_Precos_Extra', 'U') is not null	drop table Hist_Precos_Extra;
if OBJECT_ID('Hist_Precos_Actividade', 'U') is not null	drop table Hist_Precos_Actividade;
if OBJECT_ID('Estadia_Actividades', 'U') is not null drop table Estadia_Actividades;
if OBJECT_ID('Actividade', 'U') is not null drop table Actividade;
if OBJECT_ID('Estadia_Extras_Por_Alojamento', 'U') is not null drop table Estadia_Extras_Por_Alojamento;
if OBJECT_ID('Estadia_Alojamentos', 'U') is not null drop table Estadia_Alojamentos;
if OBJECT_ID('Alojamento_Extras', 'U') is not null drop table Alojamento_Extras;
if OBJECT_ID('Extra', 'U') is not null	drop table Extra;
if OBJECT_ID('Roulote', 'U') is not null	drop table Roulote;
if OBJECT_ID('Bungalow', 'U') is not null	drop table Bungalow;
if OBJECT_ID('Tenda', 'U') is not null	drop table Tenda;
if OBJECT_ID('Alojamento', 'U') is not null	drop table Alojamento;
if OBJECT_ID('Parque', 'U') is not null	drop table Parque;

/* DROP da Base de Dados */
if (DB_ID('AcamPE') is not null)
	BEGIN
		use master
		alter database AcamPE set single_user with rollback immediate
		drop database AcamPE
	END
