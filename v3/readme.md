# gradescope verkefni - gagnasafnsfræði vika 3

## 1.
### a)
```sql
select class, country from Classes where numGuns >= 4;
```

### b)
```sql
select name as nafn from Ships where launched < 1930;
```

### c)
```sql
select name from Ships where name like class;
```

### d)
```sql
select name from Ships where name like 'E%';
```

## 2.
Product:  
```sql
create table Product(
    maker VARCHAR(255),
    model VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(255)
);
```

PC:  
```sql
create table PC(
    model VARCHAR(255) NOT NULL UNIQUE,
    speed FLOAT,
    ram INT,
    hd INT,
    price INT
);
```

<div style='page-break-after: always;'></div>

Laptop:  
```sql
create table Laptop(
    model VARCHAR(255) NOT NULL UNIQUE,
    speed FLOAT,
    ram INT,
    hd INT,
    screen INT,
    price INT
)
```

Printer:  
```sql
create table Printer(
    model VARCHAR(255) NOT NULL UNIQUE,
    color VARCHAR(255),
    type VARCHAR(255),
    price INT
)
```

## 3.
### a)
```sql
select starName from StarsIn 
where movieTitle like 'Titanic' 
INTERSECT 
select name from MovieStar 
where gender like 'F';
```

### b)
```sql
select starName from StarsIn where movieTitle = (
    select title from Movie where year = 1980 
    and studioName = 'Paramount'
);
```

### c)
```sql
select name from MovieExec where cert = (
    select presC from Studio where name = "Paramount"
);
```

<div style='page-break-after: always;'></div>

### d)
```sql
select title from Movie where length > (select length from Movie where title = 'Star Wars');
```

### e)
```sql
select name from MovieExec where 
    netWorth > (select netWorth from MovieExec where 
        name = 'George Lucas'
);
```