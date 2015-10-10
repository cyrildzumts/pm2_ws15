package generics;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractList<Integer> list = new ConcreteArrayList<Integer>(10);
		System.out.println(" List size : " + list.size());
		
		for(int i = 0; i < 5; i++){
			try{
				list.insert(i, i);
			}
			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println(" List size 2 : " + list.size());
		
		for(int i = 0 ; i < list.size(); i++){
			try{
				System.out.print(list.retrieve(i) + " - ");
			}
			
			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println("\nContainer Size : " +  list.size());
	
	try{
		list.insert(2, 3);
	}
	catch(IndexOutOfBoundsException error){
		error.printStackTrace();
	}
	
	for(int i = 0 ; i < list.size(); i++){
		try{
			System.out.print("- " + list.retrieve(i) );
		}
		
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}
	}
	System.out.println("\nContainer Size : " +  list.size());
	
	int i = list.find(1);
	System.out.println("Index is : " + i);
		try{
			System.out.print("- " + list.retrieve(i) + "\n" );
		}
		
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}
		try{
			list.delete(2);
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
		}
		for(int k = 0 ; k < list.size(); k++){
			try{
				System.out.print("- " + list.retrieve(k) );
			}
			
			catch(IndexOutOfBoundsException error){
				error.printStackTrace();
			}
		}
		System.out.println("\nContainer Size : " +  list.size());
	}
}
