use AcamPE;

insert into Parque(Nome, Morada, Localizacao) 
			values( 'MIRAMAR', 'Rua do Mar, Santo Mar de baixo', '38.713889, -9.139444');
insert into Parque(Nome, Morada, Localizacao) 
			values( 'MIRASOL', 'Rua do Sol, Santo Sol de Cima', '28.713889, -8.139444');
insert into Parque(Nome, Morada, Localizacao) 
			values( 'MIRATERRA', 'Rua da Terra, Santa Terra dalém', '18.713889, -7.139444');

SET IDENTITY_INSERT Extra ON
insert into Extra( ID, Descricao, Preco ) values ( 1, 'Electricidade', 5.00 );
insert into Hist_Precos_Extra( ExtraID, Dt_Inicio, Dt_Fim, Preco ) values ( 1, '1-1-2015', '1-1-2099', 5.00 );
insert into Extra( ID, Descricao, Preco ) values ( 2, 'Estancionamento', 8.00 );
insert into Hist_Precos_Extra( ExtraID, Dt_Inicio, Dt_Fim, Preco ) values ( 2, '1-1-2015', '1-1-2099', 8.00 );
insert into Extra( ID, Descricao, Preco ) values ( 3, 'Pessoa Extra', 5.00 );
insert into Hist_Precos_Extra( ExtraID, Dt_Inicio, Dt_Fim, Preco ) values ( 3, '1-1-2015', '1-1-2099', 5.00 );
insert into Extra( ID, Descricao, Preco ) values ( 4, 'Animal de Companhia', 5.00 );
insert into Hist_Precos_Extra( ExtraID, Dt_Inicio, Dt_Fim, Preco ) values ( 4, '1-1-2015', '1-1-2099', 5.00 );
SET IDENTITY_INSERT Extra OFF



insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRAMAR', 'Jogo da Malha', '05-04-2016 09:00', 'Atirar o cachucho contra a estaca', 10, 5.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRAMAR', 'Jogo da Malha', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 5.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRASOL', 'Jogo da Malha', '05-04-2016 09:00', 'Atirar o cachucho contra a estaca', 10, 8.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRASOL', 'Jogo da Malha', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 8.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRAMAR', 'Excursão MIRANTE', '05-04-2016 09:00', 'Excursão ao ponto mais perto do MAR' , 25, 15.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRAMAR', 'Excursão MIRANTE', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 15.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRASOL', 'Excursão MIRANTE', '05-04-2016 09:00', 'Excursão ao ponto mais perto do SOL', 20, 30.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRASOL', 'Excursão MIRANTE', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 30.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRATERRA', 'Excursão MIRANTE', '05-04-2016 09:00', 'Excursão ao ponto mais perto da TERRA', 30, 8.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRATERRA', 'Excursão MIRANTE', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 8.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRAMAR', 'Churrascada Brava', '05-04-2016 09:00', 'Chica à descrição' , 50, 20.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRAMAR', 'Churrascada Brava', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 20.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRASOL', 'Churrascada Brava', '05-04-2016 09:00', 'Chica à descrição', 60, 20.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRASOL', 'Churrascada Brava', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 20.00 );

insert into Actividade( Parque, Nome, Data, Descricao, Lot_Max, precoPessoa ) 
			   values ( 'MIRATERRA', 'Churrascada Brava', '05-04-2016 09:00', 'Chica à descrição', 40, 25.00 );
insert into Hist_Precos_Actividade( Parque, Nome, Data, Dt_Inicio, Dt_Fim, PrecoPessoa ) 
			   values ( 'MIRATERRA', 'Churrascada Brava', '05-04-2016 09:00', '1-1-2015', '1-1-2099', 25.00 );


insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Questão da Silva', 100100100, 32345662, null, 'Rua do ISEL, N3, Trabalho' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'João Ratão', 123456789, 11543667, null, 'Rua tal, N1, Talaide' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Rato Mickey', 242423424, 53453535, 'M3434232', 'Rua X, N4, Frei de Espada à Cinta' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Super Homem', 645456425, null, 'M549278464', 'Rua S, N1, Crypton' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Passos Coelho', 74574567, 77567323, null, 'Rua N, N99, Buraca' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'José Socrates', 64564562, 22645674, null, 'Estabelecimento Prisional de Evora' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Homem Invisivel', 23423536, null, 'M243524246', 'Rua I, N54, Algures' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Leonel Messi', 575467456, null, 'M34364246', 'Rua LM, N10, Barcelona' );
insert into Hospede(  Nome, NIF, BI, Passaporte, Morada ) values( 'Cristiano Ronaldo', 533569943, 187975654, 'M765673324', 'Rua CR7, N7, Madrid' );


/* PARQUE MIRAMAR */

SET IDENTITY_INSERT Alojamento ON
insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 1, 'BG1', 'Bugalow 1', 40.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRAMAR', 1, 'T0');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 1, '01-01-2015', '1-1-2099', 40.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 2, 'BG2', 'Bugalow 2', 50.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRAMAR', 2, 'T1');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 2, '01-01-2015', '1-1-2099', 50.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 3, 'BG3', 'Bugalow 3', 100.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRAMAR', 3, 'T2');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 3, '01-01-2015', '1-1-2099', 100.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 4, 'TN1', 'Tenda 1', 15.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRAMAR', 4, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 4, '01-01-2015', '1-1-2099', 15.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 5, 'TN2', 'Tenda 2', 15.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRAMAR', 5, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 5, '01-01-2015', '1-1-2099', 15.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 6, 'TN3', 'Tenda 3', 25.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRAMAR', 6, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 6, '01-01-2015', '1-1-2099', 25.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 7, 'TN4', 'Tenda 4', 20.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRAMAR', 7, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 7, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 8, 'RL1', 'Roulote 1', 20.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRAMAR', 8);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 8, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 9, 'RL2', 'Roulote 2', 20.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRAMAR', 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 9, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRAMAR', 10, 'RL3', 'Roulote 3', 20.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRAMAR', 10);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRAMAR', 10, '01-01-2015', '1-1-2099', 20.00 );

SET IDENTITY_INSERT Alojamento OFF

/* PARQUE MIRASOL */

SET IDENTITY_INSERT Alojamento ON
insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 11, 'BG1', 'Bugalow 1', 50.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRASOL', 11, 'T1');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 11, '01-01-2015', '1-1-2099', 50.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 12, 'BG2', 'Bugalow 2', 60.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRASOL', 12, 'T2');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 12, '01-01-2015', '1-1-2099', 60.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 13, 'BG3', 'Bugalow 3', 120.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRASOL', 13, 'T3');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 13, '01-01-2015', '1-1-2099', 120.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 14, 'TN1', 'Tenda 1', 20.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRASOL', 14, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 14, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 15, 'TN2', 'Tenda 2', 20.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRASOL', 15, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 15, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 16, 'TN3', 'Tenda 3', 25.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRASOL', 16, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 16, '01-01-2015', '1-1-2099', 25.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 17, 'TN4', 'Tenda 4', 25.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRASOL', 17, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 17, '01-01-2015', '1-1-2099', 25.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 18, 'RL1', 'Roulote 1', 30.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRASOL', 18);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 18, '01-01-2015', '1-1-2099', 30.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 19, 'RL2', 'Roulote 2', 30.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRASOL', 19);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 19, '01-01-2015', '1-1-2099', 30.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRASOL', 20, 'RL3', 'Roulote 3', 35.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRASOL', 20);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRASOL', 20, '01-01-2015', '1-1-2099', 35.00 );

SET IDENTITY_INSERT Alojamento OFF

/* PARQUE MIRATERRA */

SET IDENTITY_INSERT Alojamento ON
insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 21, 'BG1', 'Bugalow 1', 50.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRATERRA', 21, 'T1');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 21, '01-01-2015', '1-1-2099', 50.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 22, 'BG2', 'Bugalow 2', 60.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRATERRA', 22, 'T2');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 22, '01-01-2015', '1-1-2099', 60.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 23, 'BG3', 'Bugalow 3', 120.00, 'B');
insert into Bungalow(Parque, ID, Topologia)
				values( 'MIRATERRA', 23, 'T3');
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 23, '01-01-2015', '1-1-2099', 120.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 24, 'TN1', 'Tenda 1', 20.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRATERRA', 24, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 24, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 25, 'TN2', 'Tenda 2', 20.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRATERRA', 25, 5);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 25, '01-01-2015', '1-1-2099', 20.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 26, 'TN3', 'Tenda 3', 25.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRATERRA', 26, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 26, '01-01-2015', '1-1-2099', 25.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 27, 'TN4', 'Tenda 4', 25.00, 'T');
insert into Tenda(Parque, ID, Area)
				values( 'MIRATERRA', 27, 9);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 27, '01-01-2015', '1-1-2099', 25.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 28, 'RL1', 'Roulote 1', 30.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRATERRA', 28);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 28, '01-01-2015', '1-1-2099', 30.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 29, 'RL2', 'Roulote 2', 30.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRATERRA', 29);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 29, '01-01-2015', '1-1-2099', 30.00 );

insert into Alojamento(Parque, ID, Localizacao,	Descricao, Preco, Tipo)
				values( 'MIRATERRA', 30, 'RL3', 'Roulote 3', 35.00, 'R');
insert into Roulote(Parque, ID)
				values( 'MIRATERRA', 30);
insert into Hist_Precos_Alojamento( Parque, Aloj_ID, Dt_Inicio, Dt_Fim, Preco )
				values ( 'MIRATERRA', 30, '01-01-2015', '1-1-2099', 35.00 );

SET IDENTITY_INSERT Alojamento OFF


/* Extras disponiveis por aLojamento */

insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 1, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 1, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 2, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 2, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 3, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 3, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 4, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 4, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 4, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 5, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 5, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 5, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 6, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 6, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 6, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 7, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 7, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 7, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 8, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 8, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 8, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 8, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 9, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 9, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 9, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 9, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 10, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 10, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 10, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRAMAR', 10, 4 );

insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 11, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 11, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 12, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 12, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 13, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 13, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 14, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 14, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 14, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 15, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 15, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 15, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 16, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 16, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 16, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 17, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 17, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 17, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 18, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 18, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 18, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 18, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 19, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 19, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 19, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 19, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 20, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 20, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 20, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRASOL', 20, 4 );

insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 21, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 21, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 22, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 22, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 23, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 23, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 24, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 24, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 24, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 25, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 25, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 25, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 26, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 26, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 26, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 27, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 27, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 27, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 28, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 28, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 28, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 28, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 29, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 29, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 29, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 29, 4 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 30, 1 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 30, 2 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 30, 3 );
insert into Alojamento_Extras(Parque, Alojamento, Extra) values ( 'MIRATERRA', 30, 4 );

SET IDENTITY_INSERT Estadia ON
/* ESTADIA 1 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 1, 'Res', 50.00, '20150821', '20150826', 100100100 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 1, 1, 'MIRAMAR');
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 1, 2, 'MIRAMAR');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 1, 1, 'MIRAMAR', 3 );
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 1, 2, 'MIRAMAR', 4 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 1,'MIRAMAR', 'Excursão MIRANTE', '05-04-2016 09:00', 2);
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 1,'MIRAMAR', 'Churrascada Brava', '05-04-2016 09:00', 2);
/* ESTADIA 2 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 2, 'Est+Res', 50.00, '2016-01-01', '2016-01-05', 242423424 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 2, 3, 'MIRAMAR');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 2, 3, 'MIRAMAR', 3 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 2,'MIRAMAR', 'Excursão MIRANTE', '05-04-2016 09:00', 2);
/* ESTADIA 3 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 3, 'Est', 0, '2016-03-01', '2016-03-07', 645456425 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 3, 19, 'MIRASOL');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 3, 19, 'MIRASOL', 3 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 3,'MIRASOL', 'Excursão MIRANTE', '05-04-2016 09:00', 2);
/* ESTADIA 4 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 4, 'Est', 0, '2016-03-18', '2016-03-20', 74574567 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 4, 16, 'MIRASOL');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 4, 16, 'MIRASOL', 2 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 4,'MIRASOL', 'Excursão MIRANTE', '05-04-2016 09:00', 4);
/* ESTADIA 5 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 5, 'Est', 0, '2016-04-15', '2016-04-19', 64564562 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 5, 24, 'MIRATERRA');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 5, 24, 'MIRATERRA', 2 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 5,'MIRATERRA', 'Churrascada Brava', '05-04-2016 09:00', 3);
/* ESTADIA 6 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 6, 'Est', 0, '2016-04-15', '2016-04-21', 23423536 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 6, 22, 'MIRATERRA');
/* ESTADIA 7 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 7, 'Est', 0, '2016-05-01', '2016-05-07', 575467456 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 7, 28, 'MIRATERRA');
/* ESTADIA 8 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 8, 'Res', 60.00, '2016-05-07', '2016-05-10', 533569943 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 8, 14, 'MIRASOL');
insert into Estadia_Extras_Por_Alojamento( Estadia, Aloj_ID, Aloj_Parque, Extra ) values ( 8, 14, 'MIRASOL', 3 );
insert into Estadia_Actividades( Estadia, Parque, Nome, Data, Num_Participantes ) 
						values( 8,'MIRASOL', 'Excursão MIRANTE', '05-04-2016 09:00', 2);
/* ESTADIA 9 */
insert into Estadia( ID, Tipo, Sinal, DT_entrada, DT_Saida, Hospede ) 
			 values( 9, 'Res', 50.00, '2016-05-10', '2016-05-21', 123456789 );
insert into Estadia_Alojamentos( Estadia, Aloj_ID, Aloj_Parque ) values ( 7, 14, 'MIRASOL');

SET IDENTITY_INSERT Estadia OFF







