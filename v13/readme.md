# vikublað 13 - gagnasafnsfræði

## spurning 4.
> finnið þær kvikmyndastjörnur sem léku í öllum kvikmyndum sem framleiddar voru árið 2017 þar sem titillinn byrjaði á stafnum 'R'  

```sql
select name from MovieStar where not exists (select * from Movie where not exists (select * from StarsIn where movieTitle like 'R%' and movieYear = 2017 and name like starName))
```

> finnið þá kvikmyndaframleiðendur sem hafa framleitt einhverja kvikmynd með sérhverri kvikmyndastjörnu.

```sql
select name from MovieExec where not exists (select producerC from Movie where not exists (select * from StarsIn))
```

## spurning 5.
