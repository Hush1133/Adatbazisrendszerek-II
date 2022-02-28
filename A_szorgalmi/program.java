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
		System.out.println("1:Term�k t�bla list�z�s");
		System.out.println("2:Panasz t�bla list�z�s");
		System.out.println("3:�j term�k felv�tele");
		System.out.println("4:Term�k t�rl�se");
		System.out.println("5:Term�k adatmodosit�s");
		System.out.println("6:Kil�p�s");
		System.out.println("K�rem a tev�kenys�g�nek a sz�m�t");
		int szam=sc.nextInt();
		switch (szam) {
		  case 1:
			  dbm.ReadAllDatatermek();
		    break;
		  case 2:
			  dbm.ReadAllDatapanaszok();
		    break;
		  case 3:
			String id = cm.ReadData("k�rem az idt: ");
			String termek_nev = cm.ReadData("K�rem a term�k_nevet: ");
			String ar = cm.ReadData("K�rem az �rat: ");
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
