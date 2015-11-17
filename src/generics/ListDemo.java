package generics;

public class ListDemo {

	public static void main(String[] args) {

		AbstractList<Integer> list = new ConcreteArrayList<Integer>(10);
		// Ein paar werte weren in die Liste gelegt
		for(int i = 0; i < 5; i++){
			try{
				list.insert(i, i);
			}
			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println();
		// Die Liste wir in der Console angezeigt
		for(int i = 0 ; i < list.size(); i++){
			try{
				System.out.print( list.retrieve(i) );
				if(i + 1 < list.size())
					System.out.print(" - ");
			}

			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println();
		// Ein neue Objekt wird in die Liste  an der Stelle 2 gelegt
		try{
			list.insert(2, 3);
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}

		for(int i = 0 ; i < list.size(); i++){
			try{
				System.out.print( list.retrieve(i) );
				if(i + 1 < list.size())
					System.out.print(" - ");
			}

			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println();
		// AbstrackList.find(int pos) liefert -1 wenn er nichts gefunden hat.
		// Man könnte schon prüfen ob index gültig ist. Es gibt aber einen Fehler 
		// in der Implementierung von find(), Als Übung du könntest diesen Fehler suchen
		// und korrigieren :)
		int index = list.find(4);
		try{
			System.out.println(" Objekt gefunden :  " + list.retrieve(index) );
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}
		System.out.println();
		/*
		 *  Das Objekt mit dem index 2 wird von der Liste entfernt.
		 */
		try{
			list.delete(2);
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}
		System.out.println("Iterable :");
		for(Integer i : list){
			System.out.print("- " + i );
		}
		System.out.println("\n Not Iterable :");
		for(int k = 0 ; k < list.size(); k++){
			try{
				System.out.print( list.retrieve(k) );
				if(k + 1 < list.size())
					System.out.print(" - ");
			}

			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		
	}
}
