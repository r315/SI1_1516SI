/* SE A BASE DE DADOS JÁ EXISTE DEVOLVE ERRO E PARA O SCRIPT*/
IF (DB_ID('AcamPE') is NOT null)
	BEGIN
		RAISERROR('@Por favor correr o Script de Drop primeiro!', 16, 1)
		RETURN
	END
/*SE A BASE DE DADOS NÃO EXISTIR CRIA-A*/
CREATE DATABASE AcamPE
GO
IF (@@ERROR = 50000)
	RETURN

use AcamPE;

/* CRIAR TABELAS */
/*
BEGIN TRANSACTION
BEGIN TRY
*/
	create table Parque(
		Nome varchar(50) primary key,
		Morada varchar(100) not null,
		Localizacao varchar(20) not null
	);

	create table Alojamento(
		Parque varchar(50) not null references Parque(Nome),
		ID int unique IDENTITY not null,
		--ID int unique not null,
		Localizacao varchar(50) not null,
		Descricao varchar(100),
		Preco numeric(10,2) not null,
		Tipo varchar(10) not null,
		CONSTRAINT PK_Alojamento PRIMARY KEY ( Parque, ID ),
		CONSTRAINT LocUnicaNoParque UNIQUE (Parque, Localizacao),
		CONSTRAINT Tipo_values CHECK ( Tipo IN ('T', 'R' ,'B'))
	);

	create table Tenda(
		Parque varchar(50) not null,
		ID int not null,
		Area int not null,
		FOREIGN KEY (Parque, ID) references Alojamento(Parque, ID) ON DELETE CASCADE,
		CONSTRAINT PK_Tenda PRIMARY KEY ( Parque, ID )
	);

	create table Bungalow(
		Parque varchar(50) not null,
		ID int not null,
		Topologia varchar(10)  not null,
		FOREIGN KEY (Parque, ID) references Alojamento(Parque, ID) ON DELETE CASCADE,
		CONSTRAINT PK_Bungalow PRIMARY KEY ( Parque, ID ),
		CONSTRAINT Topologia_values CHECK ( Topologia IN ('T0', 'T1' ,'T2', 'T3'))
	);

	create table Roulote(
		Parque varchar(50) not null,
		ID int not null,
		FOREIGN KEY (Parque, ID) references Alojamento(Parque, ID) ON DELETE CASCADE,
		CONSTRAINT PK_Roulote PRIMARY KEY ( Parque, ID )
	);

	create table Extra(
		ID int IDENTITY primary key,
		--ID int primary key,
		Descricao varchar(100),
		Preco numeric(10,2),
	);

	create table Alojamento_Extras (
		Parque varchar(50) not null,
		Alojamento int not null,
		Extra int not null references Extra(ID),
		FOREIGN KEY (Parque, Alojamento) references Alojamento(Parque, ID) ON DELETE CASCADE,
		CONSTRAINT PK_Extras_Por_Alojamento primary key (Parque, Alojamento, Extra)
	);

	create table Hospede(
		NIF int PRIMARY KEY,
		BI int,
		Passaporte varchar(10),
		Nome varchar(50) not null,
		Morada varchar(100) not null,
		CONSTRAINT BIePass_null CHECK (BI is not null or Passaporte is not null)
	);

	create table Estadia(
		ID int IDENTITY primary key,
		--ID int primary key,
		Tipo varchar(10) not null,
		Sinal numeric(10,2),
		DT_entrada date,
		DT_Saida date,
		Hospede int references Hospede(NIF),
		CONSTRAINT Tipo_Vals CHECK ( Tipo IN ( 'Res' , 'Est' , 'Est+Res'))
	);

	create table Estadia_Alojamentos(
		Estadia int references Estadia(ID),
		Aloj_ID int,
		Aloj_Parque varchar(50) not null,
		FOREIGN KEY (Aloj_Parque, Aloj_ID) references Alojamento(Parque,ID) ON DELETE CASCADE,
		CONSTRAINT PK_Estadia_Alojamentos primary key (Estadia, Aloj_Parque, Aloj_ID ),
	);

	create table Estadia_Extras_Por_Alojamento(
		Estadia int references Estadia(ID),
		Aloj_ID int,
		Aloj_Parque varchar(50) not null,
		Extra int references Extra(ID),
		FOREIGN KEY (Aloj_Parque, Aloj_ID) references Alojamento(Parque,ID) ON DELETE CASCADE,
		CONSTRAINT PK_Estadia_Extras_Por_Alojamento primary key (Extra,Estadia),
		CONSTRAINT CC_Estadia_Alojamentos UNIQUE ( Extra, Aloj_Parque, Aloj_ID )
	);


	create table Actividade(
		Parque varchar(50) not null references Parque(Nome),
		Nome varchar(50) not null,
		Data datetime not null,
		Descricao varchar(200),
		Lot_Max int,
		precoPessoa numeric(10,2) not null,
		CONSTRAINT PK_Actividade PRIMARY KEY (Parque, Nome, Data)
	);

	create table Estadia_Actividades(
		Estadia int references Estadia(ID),
		Parque varchar(50),
		Nome varchar(50),
		Data datetime,
		Num_Participantes int,
		FOREIGN KEY (Parque, Nome, data) references Actividade(Parque,Nome,Data),
		CONSTRAINT PK_Estadia_Actividades PRIMARY KEY (Estadia,Parque, Nome, Data)
	);

	create table Hist_Precos_Actividade(
		Parque varchar(50) not null,
		Nome varchar(50) not null,
		Data datetime not null,
		Dt_Inicio date not null,
		Dt_Fim date,
		PrecoPessoa numeric(10,2) not null,
		FOREIGN KEY (Parque, Nome, data) references Actividade(Parque,Nome,Data),
		CONSTRAINT PK_Hist_Precos_Actividade PRIMARY KEY (Parque, Nome, Data, DT_Inicio)
	);

	create table Hist_Precos_Extra(
		ExtraID int not null references Extra(ID),
		Dt_Inicio date not null,
		Dt_Fim date,
		Preco numeric(10,2) not null,
		CONSTRAINT PK_Hist_Precos_Extra PRIMARY KEY (ExtraID, DT_Inicio)
	);

	create table Hist_Precos_Alojamento(
		Parque varchar(50) not null,
		Aloj_ID int not null,
		Dt_Inicio date not null,
		Dt_Fim date,
		Preco numeric(10,2) not null,
		FOREIGN KEY (Parque, Aloj_ID) references Alojamento(Parque, ID) ON DELETE CASCADE,
		CONSTRAINT PK_Hist_Precos_Alojamento PRIMARY KEY (Parque, Aloj_ID, DT_Inicio)
	);

/*
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
END CATCH
*/
GO


/* Crear Stored Procedures para inserir registos na BD */
/*
	CREATE PROCEDURE dbo.insereParque
	  @Nome varchar(50),
	  @Morada varchar(100),
	  @Localizacao varchar(20)
	  AS 
	  INSERT INTO Parque(Nome, Morada, Localizacao) VALUES (@Nome, @Morada, @Localizacao)
	GO

	CREATE PROCEDURE dbo.insereAlojamento
	 @Parque varchar(50),
	 @Localizacao varchar(50),
	 @Descricao varchar(100)=null,
	 @Preco numeric(10,2),
	 @Tipo varchar(10),
	 @Topologia varchar(10)=null,
	 @Area int=null
	  AS 
			if ((@Tipo != 'B') and (@Tipo != 'R') and (@Tipo != 'T') ) begin
				return 1
			end
			else begin
					Declare @new_identity int;
					if ( @Tipo='B'AND @Topologia is not null ) begin
						INSERT INTO Alojamento(Parque, Localizacao,	Descricao, Preco, Tipo) 
						VALUES (@Parque, @Localizacao,	@Descricao, @Preco, @Tipo)
						SELECT @new_identity = SCOPE_IDENTITY()
						insert into Bungalow(Parque, ID, Topologia)
						values (@Parque, @new_identity, @Topologia)
					end
					else if ( @Tipo='T'AND @Area is not null ) begin
						INSERT INTO Alojamento(Parque, Localizacao,	Descricao, Preco, Tipo) 
						VALUES (@Parque, @Localizacao,	@Descricao, @Preco, @Tipo)
						SELECT @new_identity = SCOPE_IDENTITY()
						insert into Tenda(Parque, ID, Area)
						values (@Parque, @new_identity, @Area)
					end
					else if ( @Tipo='R' ) begin
						INSERT INTO Alojamento(Parque, Localizacao,	Descricao, Preco, Tipo) 
						VALUES (@Parque, @Localizacao,	@Descricao, @Preco, @Tipo)
						SELECT @new_identity = SCOPE_IDENTITY()
						insert into Roulote(Parque, ID )
						values (@Parque, @new_identity )
					end
					return 0
			end
	GO

	/*
	CREATE PROCEDURE dbo.insereExtra
	  @Parque varchar(50),
	  @Alojamento int
	  AS 
	  INSERT INTO Extra(Parque, Morada, Localizacao) VALUES (@Nome, @Morada, @Localizacao)
	GO
	*/
	
	*/