# gagnasafnsfræði - vikublað 8 

> öll þessara falla notast við samskonar "boilerplate" kóða sem ég set neðst í þessi skil

## 1.

```java
double salaries = 0;
int cnt = 0;
ResultSet rs = statement.executeQuery("select Salary from EMPLOYEE");
// keyrir fyrir allar launatölur í EMPLOYEE
while (rs.next()) {
    // bætir gildi við salaries og einum við teljara
    salaries += rs.getDouble(1);
    cnt++;
}
rs.close();
// prentar út meðaltal launatalna
System.out.printf("avg-salary: %f", salaries/cnt);
```

## 2.

```java
// query strengur skilgreindur
String query = "update EMPLOYEE set Salary = (Salary + 200) where Ssn = ?";
PreparedStatement p = connection.prepareStatement(query);

// keyrir fyrir hverja kennitölu í EMPLOYEE
ResultSet rs = statement.executeQuery("select ssn from EMPLOYEE");
while (rs.next()) {
    // nær í einstaka kennitölur
    String ssn = rs.getString(1);
    // hreinsar p til að geta sett inn ferskt viðfang
    p.clearParameters();
    // setur kennitölu sem viðfang í p
    p.setString(1, ssn);
    // keyrir p
    p.execute();
}
rs.close();
```

## 3.

```java
// fyrir allt starfsfólk í EMPLOYEE setja Salary sem Salary*1.03
statement.executeUpdate("update EMPLOYEE set Salary = (Salary*1.03)");
```

<div style='page-break-after: always;'></div>

## 4.


### keyrsla á JDBC1 fyrir breytingar
![mynd5](pics/m5.png)

### þýða öll forritin
![mynd1](pics/m1.png)  

### keyrsla á v8a
![mynd2](pics/m2.png)  

### keyrsla á v8b, síðan v8a til að sýna meðallaun
![mynd3](pics/m3.png)  

### keyrla á v8c, síðan v8a til að sýna meðallaun
![mynd4](pics/m4.png)

### keyrsla á JDBC1 eftir breytingar
![mynd6](pics/m6.png)

<div style='page-break-after: always;'></div>

## boilerplate

```java
import java.sql.*;

public class v8abc {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:company.db");
            Statement statement = connection.createStatement();

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            // VERKEFNAKÓÐI KEMUR HÉR Á MILLI        
            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
```