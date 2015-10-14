package lamdas;

/**
 * 
 * @author cyrildz
 * Vorraussetzung : Aufgabe  aus dem PT1 Labor ( SS15) bei Herr Philipp Jenke.
 * Beschreibung :  In dieser Demo,ich nutze eine Lamda als Argument
 * Hier wird einen Text einmal verschluesselt und danach entschluesselt
 * 
 */
public class LamdaDemo {

	
	
	public static void main(String args[]){
		
		/**
		 * Hier wird eine Lamda definiert und mit ComputeFunc verbunden.
		 * Diese Lamda bekommt einen Text als Argument und liefert einen
		 * verschluesselten Text zurueck.
		 */
		
		String dummyText = "Hier wird eine Lamda definiert und mit ComputeFunc verbunden "
				+ "Diese Lamda bekommt einen Text als Argument und liefert einen "
		 + "verschluesselten Text zurueck";
		
		
		ComputeFunc strUmwandlung = (str) ->{
			char ch;
			String verschlusselteText = "";
			for (int index = 0; index < str.length(); index++){
				ch = str.toUpperCase().charAt(index);
				if(ch != ' '){
					if(ch + 4  <= 'Z'){
						verschlusselteText += String.format("%c", ch + 4);
					}
					else {
						verschlusselteText += String.format("%c", ch + 4 + ('A' - 'Z') - 1);
					}
				}
				else {
					verschlusselteText += String.format("%c", ch);
				}
				
			}
			
			return verschlusselteText;
			
		};
		
		String kodierteText = LamdaAsArgument.workOnString(strUmwandlung, dummyText);
		System.out.println( kodierteText);
		
		/**
		 * Hier wird eine neue Lamda definiert und mit ComputeFunc verbunden.
		 * Diese Lamda bekommt einen verschluesselten Text als Argument und liefert einen
		 * entschluesselten Text zurueck.
		 */
		strUmwandlung = (text) ->{
			char ch;
			String entschlusselteText = "";
			for (int index = 0; index < text.length(); index++){
				ch = text.toUpperCase().charAt(index);
				if(ch != ' '){
					if(ch - 4  >= 'A'){
						entschlusselteText += String.format("%c", ch - 4);
					}
					else {
						entschlusselteText += String.format("%c", ch - 4 + ('Z' - 'A') + 1);
					}
				}
				else {
					entschlusselteText += String.format("%c", ch);
				}
			}
			return entschlusselteText;
		};
		
		String dekodierteText = LamdaAsArgument.workOnString(strUmwandlung, kodierteText);
		System.out.println( dekodierteText);
		
		System.out.println("LamdaDemo Ende ");
		
	}
}
