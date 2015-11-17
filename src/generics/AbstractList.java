/**
 * 
 * @author Cyrille Ngassam Nwenga
 * 
 * Abstrakt List Interface
 * Ziel : Eine einfache Interface für einen Container implementieren
 * 
 * Beschreibung : Manchmal wollen wir eine Liste von Objekten (nichts mit 
 * der Java-Object Klasse zu tun) in einem Ort speichern. Es kommt aber 
 * ofter vor dass wir nicht wissen wie viel Objekten wir speichern wollen.
 * z.b Es koennte eine Einkaufliste sein. Mann bereitet die Einkauflist zuhause vor,
 * aber  beim einkaufen fällt uns noch einpaar Sachen ein, die wir kaufen wollen.
 * In diesem Fall, wir tragen in der Liste ein, die neuen Sachen die gerade uns eingefallen 
 * sind.
 * 
 * Aber Es kann sein dass wir auch zuviel Sachen in der Liste eingetragen haben und
 * dann keinen Platz mehr haben daraus folgt dass wir nichts mehr eintragen können.
 * Ein Lösung wäre dann ein paar Sachen von der Liste entfernen, die wir nicht mehr 
 * mehr brauchen.
 * AbstracctList versucht genau solche Liste zu implementieren.
 * 
 */


package generics;

public interface AbstractList<Item> extends Iterable<Item>{
	/**
	 * Add item into the list at the given index pos.
	 * In case of no room for item, the list
	 * will expand itself to allow item to get added
	 * This method throws an IndexOutOfBoundsException 
	 * when pos is out of bounds.
	 * @param item
	 */
	public void insert(int pos,Item item) throws IndexOutOfBoundsException ;
	
	/**
	 * Tryto delete the item at index corresponding to pos
	 * This method throws an IndexOutOfBoundsException when
	 * pos is out of bound
	 * @param pos
	 * @throws IndexOutOfBoundsException
	 */
	public void delete(int pos) throws IndexOutOfBoundsException;
	
	/**
	 * This method looks for item up. when the lookup was successful it
	 * returns the index of item in the list. When unsuccessful it returns
	 * -1
	 * @param item
	 * @return
	 */
	public int find(Item item);
	/**
	 * This method try retrieve an item at a the index pos.
	 * An IndexOutOfBoundsException is throws when pos is out of 
	 * bound
	 * @param pos
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Item retrieve(int pos) throws IndexOutOfBoundsException;
	
	/**
	 * This method adds list to the end of the current list.
	 * @param list
	 * @return
	 */
	public AbstractList<Item> concat(AbstractList<Item> list);
	/**
	 * This method returns the size of the list.
	 * @return
	 */
	public int size();

}
