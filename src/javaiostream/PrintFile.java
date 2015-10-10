package javaiostream;
import java.io.*;

/**
 * 
 * @author Cyrille Ngassam Nkwenga
 * TI Programmierung Methodik 2
 * I/O Demo
 * WS 2015
 * Dieses klein Programm öffnet ein
 * Datei falls es existiert und zeigt 
 * den Inhalt des Datei in der Konsole an.
 * 
 * Man kann aus diesem Programm ganz einfach
 * ein anderes Programm schreiben das eine Kopie 
 * von einem Datei erstellt.
 *
 */
public class PrintFile {

	
	public static void main(String[] args) {
	
		
		int currentByte;
		final int EOF = -1;
		FileInputStream input = null;
		if(args.length != 1){
			System.out.println("Usage: java PrintFile filepath");
			System.out.println( " Args length : " + args.length);
			return;
		}
		// Opening and reading
		try{
			input = new FileInputStream(args[0]);
			do{
				currentByte = input.read();
				if(currentByte!= EOF){
					System.out.print((char)currentByte);
				}
			} while(currentByte!= EOF);
		}
		// Die Reihenfolge hier ist wichtig : zuerst muss FileNotFoundException 
		// gefangen werden  sonst wird sie nie gefangen werden und dann beschwert sich der Compiler.
		
//		catch(FileNotFoundException error){
//			//System.out.println(error.getMessage());
//			error.printStackTrace();
//		}
		catch(IOException error){
			//System.out.println(error.getMessage());
			error.printStackTrace();
		}
		
		finally{
			// closing
			try{
				if(input != null){
					input.close();
				}
				
			}
			catch(IOException error){
				//System.out.println(error.getMessage());
				error.printStackTrace();
			}
		
		}
	}
}
