---
pdf_options:
  format: a4
  margin: 30mm 20mm
---
# vikublað 11 - gagnasafnsfræði

## forrit
> * bara sá kóði sem ég breytti eða bætti við, allur kóðinn verður í heild sinni neðst
```java
Statement stmt = conn.createStatement();
stmt.executeUpdate("DROP TABLE IF EXISTS R");
stmt.executeUpdate("DROP INDEX IF EXISTS RINDEX");
stmt.executeUpdate("CREATE TABLE R(key integer primary key, value double)");

if (USE_INDEX)
    stmt.executeQuery("create index RINDEX on R(value)");

PreparedStatement pstmt = conn.prepareStatement("INSERT INTO R VALUES(?,?)");

long start, end;

start = System.nanoTime();
int i;
for (i = 0; i != 1000000; i++) {
    double y = Math.random() * 2.0;
    // pstmt.clearParameters();
    pstmt.setInt(1, i);
    pstmt.setDouble(2, y);
    pstmt.executeUpdate();
    if (System.nanoTime() - start > 6e10)
        break;
}
```

## töflur
tímar sem eru gefnir eru tveir, per innsetningu og margefeldi af tíma per innsetningu og fjölda leita


### tími fyrir innsetningu
<table>
<tbody>
  <tr>
    <td></td>
    <td colspan="2" style="text-align: center">Án vísis<br></td>
    <td colspan="2" style="text-align: center">Með vísi</td>
  </tr>
  <tr>
    <td></td>
    <td>Án AutoCommit<br></td>
    <td>Með AutoCommit</td>
    <td>Án AutoCommit<br></td>
    <td>Með AutoCommit</td>
  </tr>
  <tr>
    <td>Tími per innsetning</td>
    <td>0.00000182s</td>
    <td>0.01909562s</td>
    <td>0.00000707s</td>
    <td>0.01939054s</td>
  </tr>
  <tr>
    <td>Tími per milljón</td>
    <td>1.82s</td>
    <td>5.3klst</td>
    <td>7.07s</td>
    <td>5.38klst</td>
  </tr>
</tbody>
</table>


### tími fyrir leit
|Án vísis|Með vísi|
|:---:|:---:|
|0.095584837s|0.021116301s|

<div style='page-break-after: always;'></div>

# kóðinn í heild sinni
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

// Notkun: java -cp .;sqlite-jdbc-....jar V11 <args>
//         þar sem <args> er: [autocommit|noautocommit] [index|noindex]
// Eftir:  Búið er að mæla tíma fyrir gagnagrunnsaðgerðir og
//         skrifa niðurstöður

public class V11 {
    public static void main(String[] args)
            throws Exception {
        Class.forName("org.sqlite.JDBC");
        boolean USE_AUTOCOMMIT = args[0].equals("autocommit");
        boolean USE_INDEX = args[1].equals("index");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:v11.db");
            conn.setAutoCommit(USE_AUTOCOMMIT);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS R");
            stmt.executeUpdate("DROP INDEX IF EXISTS RINDEX");
            stmt.executeUpdate("CREATE TABLE R(key integer primary key, value double)");

            if (USE_INDEX)
                stmt.executeUpdate("create index RINDEX on R(value)");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO R VALUES(?,?)");

            long start, end;

            start = System.nanoTime();
            int i;
            for (i = 0; i != 1000000; i++) {
                double y = Math.random() * 2.0;
                // pstmt.clearParameters();
                pstmt.setInt(1, i);
                pstmt.setDouble(2, y);
                pstmt.executeUpdate();
                if (System.nanoTime() - start > 6e10)
                    break;
            }
            if (!USE_AUTOCOMMIT)
                conn.commit();

            end = System.nanoTime();
            System.out.println("Tími fyrir/Time for " +
                    i + " innsetningar/inserts: " +
                    (double) (end - start) / 1e9);

            System.out.println("Tími per innsetningu/Time per insert: " +
                    (double) (end - start) / 1e9 / i);

            start = System.nanoTime();
            ResultSet r = stmt.executeQuery("SELECT COUNT(*) FROM R WHERE " +
                    "value BETWEEN 0.05 AND 0.15");
            r.next();
            System.out.println("Niðurstaða leitar/Result of search: " + r.getInt(1));
            System.out.println("Tími fyrir leit/Time for search: " +
                    (double) (System.nanoTime() - start) / 1e9);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
```