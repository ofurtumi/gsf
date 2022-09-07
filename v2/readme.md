# gradescope verkefni - gagnasafnsfræði

## 1.
### a)
mynd 1:  
| acctNo | type | balance |
|:---:|:---:|:---:|

mynd 2:  
| firstName | lastName | idNo | account |
|:---:|:---:|:---:|:---:|

### b)

mynd 1:  
| | | |
|:---:|---|:---:|
| 12345 | sparisjóðsreikningur | 13000 |
| 23456 | hlaupareikningur | 2000 |
| 34567 | hlaupareikningur | 250 | 

mynd 2:  
| | | | |
|---|:---:|:---:|:---:|
| Jón Sigurðsson | 901-222 | 12345 |
| Sigríður Jónsdóttir | 805-333 | 34567 |
| Línus Gauti | 805-333 | 23456 |

### f)
mynd 1:  
|acctNo|type|balance|
|---|---|---|
|int|varchar(20)|int|

mynd 2:  
|firstName|lastName|idNo|account|
|---|---|---|---|
|varchar(20)|varchar(20)|char(7)|int|

## 2
### a)
fyrirspurn og svar:  
```sql
select address from MovieStar where name = "Harrison Ford";
Prefect Rd.
```

### b)
fyrirspurn og svar:  
```sql
select address from MovieExec where name = "George Lucas";
Oak Rd.
```

### c)
```sql
select starName from StarsIn where (movieYear < 1940) or movieTitle like '%Star%';
Carrie Fisher
Mark Hamill
Harrison Ford
```

### d)
```sql
select name from MovieExec where netWorth > 10000000;
George Lucas
Ted Turner
Stephen Spielberg
Merv Griffin
Calvin Coolidge
```