package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {

	public static void main(String[] args) {
		
		/*
		 * serialCode contains the name of the  binary file
		 * that will be created to serialize the content
		 * of student1 to student2.
		 */
		String serialCode = "SeriaDemo";
		// creating some scores 
		List<ExamPerformance> performances = new ArrayList<ExamPerformance>();
		performances.add(new ExamPerformance("Computer Science 101", 5));
		performances.add(new ExamPerformance("Assembler", 6));
		performances.add(new ExamPerformance("Computer Science 102", 2));
		performances.add(new ExamPerformance("Mathematics 101", 2));
		performances.add(new ExamPerformance("History", 5));
		
		try{
			// creating a new student and setting his performances
			Student student1 = new Student("Cyrille", "Laplace", 147);
			student1.setPerformances(performances);
			System.out.println("\t\t Student 1 ");
			System.out.println(student1);
			
			/* 
			 * Serialization starts here . 
			 * A binary file will be created on the root folder of this programm.
			 * In this file will be save the binary content of the instance student1.
			 */
			
			FileOutputStream fileOutputStream = new FileOutputStream(serialCode);
			ObjectOutputStream objectOutputstream = new ObjectOutputStream(fileOutputStream);
			objectOutputstream.writeObject(student1);
			objectOutputstream.flush();
			
			objectOutputstream.close();
		}
		catch(IOException error){
			System.out.println("Exception during serialization: " + error);
			System.exit(0);
		}
		
		
		/* 
		 * Deserialization starts here . 
		 * The binary file containing the previously sent data will be opened  
		 * and his content will be write into the instance student2
		 */
		try{
			Student student2;
			FileInputStream fileInputStream = new FileInputStream(serialCode);
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			student2 = (Student)objInputStream.readObject();
			objInputStream.close();
			System.out.println("\t\t Student 2");
			System.out.println(student2);
			
		}
		/**
		 * ObjectInputStream.readObject() throws two exceptions. So 
		 * for this case we just catch every Exceptions that will be
		 * thrown  and then quit. 
		 */
		catch(Exception error){
			System.out.println("Exception during deserialization: " + error);
			System.exit(0);
		}

	}

}
