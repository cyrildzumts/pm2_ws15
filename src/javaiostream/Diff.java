package javaiostream;
import java.io.*;
/**
 * 
 * @author Cyrille Ngassam Nkwenga
 *
 *	Description : Dieses Programm prueft ob 
 *	zwei Daten identisch sind. 
 *	Zwei Daten sind gleich wenn alle byte gleich sind.
 *	Man kann mehr Fonktionalitaet implementieren,
 *	wie z.b :
 *  # Das klein und groß schreiben ignorieren
 *  # Die stelle wo die beiden Daten sich unterscheiden
 *  # ...
 *  
 *  Usage : java Diff file1 file2
 */
public class Diff {

	public static void main(String[] args) {
		final int EOF = -1;
		FileInputStream file1 = null;
		FileInputStream file2 = null;
		int currentByteFile1;
		int currentByteFile2;
		
		// hat der user die richtigen parameter gegeben ?
		if(args.length != 2){
			System.out.println("Usage : java path/zu/Diff path/zu/file1 path/zu/file2");
			return;
		}
		
		// ich versuche jetzt die Daten zu eroeffnen und lesen : 
		try{
			file1 = new FileInputStream(args[0]);
			file2 = new FileInputStream(args[1]);
			do{
				currentByteFile1 = file1.read();
				currentByteFile2 = file2.read();
				/* ich brauche nicht mehr weiter zu pruefen
				 * wenn die beiden Byte ungleich sind. 
				 */
				if(currentByteFile1 != currentByteFile2){
					break;
				}
			}while((currentByteFile1 != EOF) && (currentByteFile2 != EOF));
			
			if(currentByteFile1 != currentByteFile2){
				System.out.println("Die Daten sind nicht gleich");
			}
			else{
				System.out.println("Die Daten sind gleich");
			}
			
		}
		catch(IOException error){
			error.printStackTrace();
		} finally {
			try{
				if(file1 != null){
					file1.close();
				}
				if(file2 != null){
					file2.close();
				}
			}
			catch(IOException error){
				error.printStackTrace();
			}
		}
		

	}

}
