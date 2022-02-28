package szorgalmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demethods {
	private Statement s = null;
	private Connection conn = null;
	private ResultSet RS = null;
	
	
	public void Connect() {
		try {
			String url = "jdbc:sqlite:C:\\Users\\cirku\\Desktop\\sqlite gedvaság\\szorgalmi.db";
			conn = DriverManager.getConnection(url);
			SM("Connection ok!");
		}catch (SQLException e) {
			SM("JDBC Connect:" +e.getMessage());
		}
		
	}
	public void DisConnect() {
		try {
			conn.close();
			SM("Disconnection ok!");
		} catch (SQLException e) {SM(e.getMessage());}
	}
	
	public void Reg() {
		try {
			Class.forName("org.sqlite.JDBC");
			SM("Sikeres driver regisztráció!");
		}catch (ClassNotFoundException e) {
			SM("hibás driver regisztráció!");
		}
		
	}
	public void SM(String msg){
			System.out.println(msg);
		}
	
	public void ReadAllDatatermek() {
		String termek_nev ="", x="\t";
		int id=0, ar=0;
		String sqlp= "select id,termek_nev,ar from Termek";
		try {
			s =  conn.createStatement();
			RS = s.executeQuery(sqlp);
			while(RS.next()) {
				id = RS.getInt("id");
				termek_nev = RS.getString("termek_nev");
				ar= RS.getInt("ar");
				SM(id+x+termek_nev+x+ar);
			}
			RS.close();
		} catch (SQLException e) {SM(e.getMessage());}
	}
	
	public void ReadAllDatapanaszok() {
		String hiba_neve ="",hibaleiras ="", x="\t";
		int id=0, termek_id=0;
		String sqlp= "select id,hiba_neve,hibaleiras,termek_id from Panaszok";
		try {
			s =  conn.createStatement();
			RS = s.executeQuery(sqlp);
			while(RS.next()) {
				id = RS.getInt("id");
				hiba_neve = RS.getString("hiba_neve");
				hibaleiras = RS.getString("hibaleiras");
				termek_id= RS.getInt("termek_id");
				SM(id+x+hiba_neve+x+hibaleiras);
			}
			RS.close();
		} catch (SQLException e) {SM(e.getMessage());}
	}
	
	public void Insert(String id,String termek_nev, String ar) {
		String sqlp = "insert into Termek values("+id+", '"+termek_nev+"', '"+ar+"')";
		try {
			s = conn.createStatement();
			s.execute(sqlp);
			SM("insert OK!");
		} catch (SQLException e) {
			SM("JDBC insert: "+e.getMessage());
		}
	}
	public void StatikusAdattorles() {
		Scanner sc = new Scanner(System.in); 
	System.out.println("Törlendõ termék id-je: ");
	String rsz = sc.next();
	String sqlp = "delete from Termek where id like '" + rsz+ "'"; 
	if (conn != null) {
		try { s = conn.createStatement();
		s.executeUpdate(sqlp);
		s.close();
		System.out.println(rsz + " id termek törölve\n");
		} catch (Exception ex)
		{System.err.println(ex.getMessage());  
		}
	}
	
	} 
	public void StatikusAdatmod() {
		Scanner sc = new Scanner(System.in); 
	System.out.println("modositando termék idjét : ");
	String rsz = sc.next();
	System.out.println("Adja meg a terméknek az új árát : ");
	String ujar= sc.next();
	String sqlp = "Update Termek set ar='" + ujar + "'" + " where id like '" + rsz+ "'"; 
	if (conn != null) {
		try { s = conn.createStatement();
		s.executeUpdate(sqlp);
		s.close();
		System.out.println(rsz + " id termek modositva lett\n");
		} catch (Exception ex)
		{System.err.println(ex.getMessage());  
		}
	}
	}



}
