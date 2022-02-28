package szorgalmi;

import java.util.Scanner;

public class console {
	Scanner scanInput = new Scanner(System.in);
	
	public String ReadData(String s) {
		String data ="";
		System.out.println("\n"+s);
		data=scanInput.nextLine();
		return data;
	}
}
