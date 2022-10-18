// Forrit �r Fundamentals of Database Systems
// eftir Ramez Elmasri og Shamkant B. Navathe

// Sta�f�rt, lei�r�tt og a�laga� af Snorra Agnarssyni 2012.
// Virkar gagnvart SQLite, PostgreSQL og ODBC.

// �etta forrit m� ���a og keyra svona � Windows:
//   javac JDBC1.java
// og s��an (fyrir SQLite)
//   java -cp .;sqlite-jdbc-....jar JDBC1
// e�a (fyrir PostgreSQL)
//   java -cp .;postgresql-....jar JDBC1 userid password
// e�a (fyrir ODBC)
//   java JDBC1
//   
// � Unix:
//   javac JDBC1.java
// og s��an (fyrir SQLite)
//   java -cp .:sqlite-jdbc-....jar JDBC1
// e�a (fyrir PostgreSQL)
//   java -cp .:postgresql-....jar JDBC1 userid password
// e�a (fyrir ODBC)
//   java JDBC1

// Til �ess a� �etta virki fyrir SQLite �arf sqlite-jdbc-....jar
// og company.db a� vera � n�verandi m�ppu, �ar sem company.db er 
// COMPANY gagnagrunnurinn � SQLite, og sqlite-jdbc-....jar er 
// SQLite JDBC klasasafni�.
//
// Ef nota skal PostgreSQL �arf postgresql-9.2-1002.jdbc4.jar
// a� vera til sta�ar � m�ppunni, en �� �arf ekki SQLite
// skr�rnar.  Ef postgresql-9.2-1002.jdbc4.jar er til sta�ar
// (b��i � skipanal�nunni og � m�ppunni) ver�ur reynt a� nota
// PostgreSQL tengingu, annars ekki.
// �rautalendingin er a� nota ODBC, en �� �arf a� vera til
// sta�ar ODBC "data source" sem heitir COMPANY og ver�ur
// (eins og � hinum tilfellunum) a� innihalda COMPANY
// gagnagrunninn.

import java.io.*;
import java.sql.*;
import java.util.Scanner;

class JDBC1 {
	public static void main(String[] args)
			throws Exception {
		Connection conn;
		try {
			// Reynum fyrst PostgreSQL
			Class.forName("org.postgresql.Driver"); // fyrir PostgreSQL
			java.util.Properties props = new java.util.Properties();
			props.setProperty("user", args[0]);
			props.setProperty("password", args[1]);
			conn = DriverManager.getConnection("jdbc:postgresql:COMPANY", props);
		} catch (Exception e) {
			// H�ldum bara �fram og reynum SQLite
			try {
				Class.forName("org.sqlite.JDBC"); // fyrir SQLite
				conn = DriverManager.getConnection("jdbc:sqlite:company.db");
			} catch (Exception e2) {
				// H�ldum �fram og reynum ODBC
				conn = DriverManager.getConnection("jdbc:odbc:COMPANY");
			}
		}

		// �egar h�r er komi� erum vi� me� tengingu vi� gagnagrunn
		// (conn) sem er anna�hvort PostgreSQL, SQLite e�a ODBC.
		String ssn, lname;
		double salary;
		String stmt1 = "select Lname, Salary from EMPLOYEE where ssn = ?";
		PreparedStatement p = conn.prepareStatement(stmt1);
		System.out.print("Enter a Social Security Number: ");
		Scanner scanner = new Scanner(System.in);
		ssn = scanner.nextLine();
		p.clearParameters();
		p.setString(1, ssn);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			lname = r.getString(1);
			salary = r.getDouble(2);
			System.out.println(lname + " " + salary);
		}
		r.close();
		conn.close();
	}
}
