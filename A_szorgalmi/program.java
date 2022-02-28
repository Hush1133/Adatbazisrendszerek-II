package szorgalmi;

import java.util.Scanner;

import szorgalmi.console;
import szorgalmi.demethods;

public class program {

	static demethods dbm = new demethods();
	static console cm = new console();

	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
		boolean ok=false;
		while(!ok) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("1:Termék tábla listázás");
		System.out.println("2:Panasz tábla listázás");
		System.out.println("3:Új termék felvétele");
		System.out.println("4:Termék törlése");
		System.out.println("5:Termék adatmodositás");
		System.out.println("6:Kilépés");
		System.out.println("Kérem a tevékenységének a számát");
		int szam=sc.nextInt();
		switch (szam) {
		  case 1:
			  dbm.ReadAllDatatermek();
		    break;
		  case 2:
			  dbm.ReadAllDatapanaszok();
		    break;
		  case 3:
			String id = cm.ReadData("kérem az idt: ");
			String termek_nev = cm.ReadData("Kérem a termék_nevet: ");
			String ar = cm.ReadData("Kérem az árat: ");
			  dbm.Insert(id, termek_nev,ar);
		    break;
		  case 4:
			  dbm.StatikusAdattorles();
		    break;
		  case 5:
			  dbm.StatikusAdatmod();
		    break;
		  case 6:
			  ok=true;
			  break;
			  
		}
		}
		
		dbm.DisConnect();

	}

}
