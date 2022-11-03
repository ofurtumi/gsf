# vikublað 9 - gagnasafnsfræði

## 1. 
```sql
CREATE TABLE Stars (
    name VARCHAR(30), 
    address VARCHAR(30),
    PRIMARY KEY name
);

CREATE TABLE Studios (
    name VARCHAR(30), 
    address VARCHAR(30),
    PRIMARY KEY name
);

CREATE TABLE Movies (
    title VARCHAR(30), 
    year VARCHAR(30), 
    length INT, 
    genre VARCHAR(30), 
    studio VARCHAR(30),
    FOREIGN KEY studio REFERENCES Studios(name)
);

CREATE TABLE StarsIn (
    name VARCHAR(30), 
    title VARCHAR(30), 
    year INT,
    FOREIGN KEY name REFERENCES Stars(name),
    FOREIGN KEY title REFERENCES Movies(title),
    FOREIGN KEY year REFERENCES Movies(year),
    PRIMARY KEY (name, title, year)
);
```

<div style='page-break-after: always;'></div>

## 2. 
```sql
CREATE TABLE Studios (
    name VARCHAR(30),
    addr VARCHAR(30),
    PRIMARY KEY name
);

CREATE TABLE Crews (
    number int,
    crewChief VARCHAR(30),
    studio VARCHAR(30),
    FOREIGN KEY studio REFERENCES Studios(name),
    PRIMARY KEY (number, studio)
);
```

## 3.
```sql
CREATE TABLE Customers (
    SSNo CHAR(10),
    name VARCHAR(30),
    addr VARCHAR(30),
    phone VARCHAR(12),
    PRIMARY KEY SSNo
);

CREATE TABLE Flights (
    number VARCHAR(20),
    day DATE,
    aircraft VARCHAR(20),
    PRIMARY KEY (number, day),
);

CREATE TABLE Bookings (
    row CHAR(2),
    seat CHAR(1),
    SSNo CHAR(10),
    flightNumber VARCHAR(20),
    day DATE,
    FOREIGN KEY SSNo REFERENCES Customers(SSNo),
    FOREIGN KEY flightNumber REFERENCES Flights(number)
    FOREIGN KEY day REFERENCES Flights(day)
    PRIMARY KEY (SSNo, flightNumber, day)
);
```