package lamdas;


/**
 * Haw Hamburg
 * @author Cyrille Ngassam Nkwenga
 * Lamda Ausdruecke
 *  PM2 WS 15
 */
public class LamdaAsArgument {
	
	/**
	 * 
	 * @param Func ist eine Functional Interface womit eine Lamda mit der gleichen Signature verbunden
	 * werden kann.
	 * 
	 * @param str ist die Zeichenkette die von der Lamda verarbeitet wird.
	 * @return liefert die verarbeitet Zeichenkette zurueck.
	 * 
	 */
	public static String workOnString(ComputeFunc Func, String str){
		return Func.compute(str);
	}
}
