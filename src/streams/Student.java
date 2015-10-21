package streams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Student:
 * @author Cyrille Ngassam Nkwenga
 * HAW HAMBURG
 * TI PM2
 * WS 2015
 * 
 * Description : This class represent the information we have
 * on a student :
 * His Lastname, firstname, ID, and performance at the exams.
 * This class implements Comparable<Student> since it we be 
 * great to compare two student and take some decision based
 * on the result of that caparaison.
 * This class is also serializable,this mean I could for example 
 * save the state of this student and work with that info some time 
 * later.
 *
 */
public class Student implements Comparable<Student>, Serializable{

	
	/**
	 * This ID is automatically generated.
	 */
	private static final long serialVersionUID = 740302399597708295L;
	/**
	 * Student's Firstname
	 */
	private String firstname;
	
	/**
	 * Student's Lastname
	 */
	private String lastname;
	/**
	 * Student's ID
	 */
	private int studentID;
	/**
	 * Student's Performances list
	 */
	private List<ExamPerformance> performances;
	
	public Student(String firstname, String lastname, int studentID){
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentID = studentID;
		performances = new ArrayList<ExamPerformance>();
		
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getNachname() {
		return lastname;
	}

	public void setNachname(String lastname) {
		this.lastname = lastname;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public List<ExamPerformance> getPerformances() {
		return performances;
	}

	public void setPerformances(List<ExamPerformance> leistungen) {
		this.performances = leistungen;
	}

	@Override
	public int compareTo(Student student) {
		if(student != null){
			if( studentID < student.getStudentID()){
				return -1;
			}
			if( studentID == student.getStudentID()){
				return 0;
			}
			if( studentID > student.getStudentID()){
				return 1;
			}
		}
		return -1;
	}
	@Override
	public String toString(){
		String info = String.format("Name : %s %s\n", firstname, lastname) ;
		info += String.format("Student ID : %d\n", studentID);
		info += "----------------------------------------------------\n";
		info += "\t\t Performances : \t\t\n" ;
		for (ExamPerformance exam: performances){
			info += String.format("%s : %.1f\n", exam.getModule(), exam.getScore());
		}
		info += "----------------------------------------------------\n";
		return info;
	}
}
