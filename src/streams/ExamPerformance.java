package streams;

import java.io.Serializable;

/**
 * Class ExamPerformance:
 * @author cyrildz
 *
 * Description : This class contains some informations
 * on the performance at the exams of a student.
 * Since this class is part of Student and Student is serializable,
 * ExamPerformance needs to be serializable too.
 */
public class ExamPerformance implements Serializable {

	
	/**
	 * This ID is automatically generated.
	 */
	private static final long serialVersionUID = 8922673898998442943L;

	/**
	 *  Name of the  Module
	 */
	private String module;
	
	/**
	 * Student's Score for this module
	 */
	private double score;
	
	public ExamPerformance(String module, double score){
		this.module = module;
		this.score = score;
	}
	
	/** 
	 * @return Liefert den Modulename zurueck
	 */
	public String getModule(){
		return module;
	}
	
	/**
	 * @return Liefert die Note dieses Modules zurueck
	 */
	public double getScore(){
		return score;
	}
	
	public void setModule(String module){
		if(!module.isEmpty()){
			this.module = module;
		}
	}
	
	public void setScore(double score){
		this.score = score;
	}
}
