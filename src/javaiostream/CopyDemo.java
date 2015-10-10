package javaiostream;

import java.io.*;

/**
 * 
 * @author cyrildz
 *
 *
 *Description : Dieses Programm erstellt eine Kopie 
 *von einem Datei.
 *
 * Usage : java CopyDemo source destination
 */
public class CopyDemo {

	public static void main(String[] args) {
		
		FileInputStream input = null;
		FileOutputStream output = null;
		// EOF = End Of File
		final int EOF = -1; 
		int currentByte;
		
		if(args.length !=2){
			System.out.println("Usage : java CopyDemo source destination" );
			return;
		}
		
		try{
			input = new FileInputStream(args[0]);
			output = new FileOutputStream(args[1]);
			do{
				currentByte = input.read();
				if(currentByte != EOF){
					output.write(currentByte);
				}
			}while(currentByte != EOF);
		}
		catch (IOException error){
			error.printStackTrace();
		} finally {
			try{
				if(input != null){
					input.close();
				}
				if (output != null){
					output.close();
				}
			}
			catch(IOException error){
				error.printStackTrace();
			}
		}

	}

}
