CREATE TABLE MovieExec(
	name varchar(25),
	address varchar(25),
	cert varchar(3) primary key, 
	netWorth int
);

CREATE TABLE Studio (
	name varchar(25) primary key, 
	address varchar(25), 
	presC varchar(3) 
		references MovieExec(cert)
);

CREATE TABLE Movie (
	title varchar(25), 
	year int, length int, 
	inColor boolean, 
	studioName varchar(25) 
		references Studio(name), 
	producerC varchar(3) 
		references MovieExec(cert), 
	primary key (title, year)
);

CREATE TABLE MovieStar (
	name varchar(25) primary key, 
	address varchar(25), 
	gender char(1), 
	birthdate varchar(10)
);

CREATE TABLE StarsIn (
	movieTitle varchar(25), 
	movieYear int, 
	starName varchar(25) 
		references MovieStar(name), 
	primary key (movieTitle, movieYear, starName), 
	foreign key (movieTitle, movieYear) 
		references Movie(title,year)
);
insert into MovieStar values
	('Tumi' ,'Kopavogur' ,'M' ,'Sept'),
	('Hakon', 'Saudakrokur' ,'M', 'April'),
	('Gunnar', 'Vestmannaeyjar' ,'M' ,'Oct'),
	('Maria', 'Reykjavik' ,'F' ,'June'),
	('Isabella', 'Reykjavik', 'F', 'Feb'),
	('Veturlidi' ,'Isafjordur','M' ,'Nov'),
	('Patrik' ,'Poland' ,'M' ,'Feb');
	
insert into Studio values
	('Metro golden Mayer' ,'Calefornia' ,'SIG'),
	('Disney Studios' ,'Dufnaholar 10' ,'STI'),
	('Dreamworks' ,'Raufarhofn'),
	('Paramount' ,'Kopasker');

insert into MovieExec values
	('Siggi', 'Bolholt 10', 'SIG', 150),
	('Palli', 'Bolholt 11', 'PAL', 930),
	('Stína', 'Bolholt 12', 'STI', 30),
	('Lísa' , 'Bolholt 13', 'LIS', 100),
	('Rögnvaldur', 'Ísafjörður 83', 'ROG', 10000);

insert into Movie values
	('Avatar',				2007, 1, 300, 'Metro golden Mayer', 	'SIG'),
	('Green Mile',			2017, 1, 250, 'Metro golden Mayer', 	'PAL'),
	('Harry Potter 3',		2012, 1, 170, 'Disney Studios', 		'STI'),
	('Tron',				2013, 1, 130, 'Disney Studios', 		'STI'),
	('Titanic',				2015, 1, 250, 'Disney Studios', 		'STI'),
	('Star Wars',			1997, 1, 210, 'Disney Studios', 		'LIS'),
	('Star Trek',			1834, 1, 169, 'Metro golden Mayer', 	'PAL'),
	('Guns Akimbo',			2001, 1, 170, 'Disney Studios', 		'LIS'),
	('Road Work Ahead',		2010, 1, 309, 'Metro golden Mayer', 	'ROG'),
	('I Sure Hope It Does',	2017, 1, 102, 'Metro golden Mayer', 	'ROG'),
	('Mad Max',				2001, 1, 520, 'Metro golden Mayer', 	'SIG'),
	('Hacker',				2017, 1, 150, 'Metro golden Mayer', 	'SIG');

insert into StarsIn values
	('Avatar' ,2007 ,'Hakon'),
	('Avatar' ,2007 ,'Isabella'),
	('Avatar' ,2007 ,'Maria'),
	('Avatar' ,2007 ,'Gunnar'),
	('Avatar' ,2007 ,'Tumi'),
	('Avatar' ,2007 ,'Patrik'),
	('Avatar' ,2007 ,'Veturlidi'),
	('Green Mile' ,2017 ,'Hakon'),
	('Green Mile' ,2017 ,'Patrik'),
	('Harry Potter 3' ,2012 ,'Gunnar'),
	('Harry Potter 3' ,2012 ,'Hakon')
	('Tron' ,2013 ,'Tumi'),
	('Tron' ,2013 ,'Isabella'),
	('Titanic' ,2015 ,'Maria'),
	('Star Wars' ,1997 ,'Isabella'),
	('Star Trek' ,1834 ,'Veturlidi'),
	('Guns Akimbo' ,2001 ,'Gunnar'),
	('Road Work Ahed' ,2010 ,'Patrik'),
	('Mad Max' ,2001 ,'Isabella'),
	('Hacker' ,2017 ,'Maria');