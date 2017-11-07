import java.util.List;

/**
 * @author Chris Paxton
 *
 */
public abstract class AbstractDictionarySCLL<K, V>{
	
	private int numberOfEntries;
	private List<TableEntry<K, V>>[] hashTable;
	private final int DEFAULT_CAPACITY = 5;
	private int tableSize;
	private final int MAX_LOAD_FACTOR = 1;  //Recomended value in the book. 
	
	//Constructors
	
	
	
	// Concrete Methods
	public void clear(){
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = null;
		}
		numberOfEntries = 0;
	}

	private int getHashIndex(K key) {

		int hc = key.hashCode();
		int index = hc % hashTable.length;
		if (index < 0)
			index += hashTable.length;

		return index;
	}
	
	private int locate(K key){
		int index = getHashIndex(key);
		if(hashTable[index].contains(key)){
			return index;
		}else{
			return -1;
		}
	}
	
	public V getValue(K key){
		int tableIndex = locate(key);
		if(tableIndex == -1)
			return null;
		else{
			int bucketIndex = hashTable[tableIndex].indexOf(key);
			return hashTable[tableIndex].get(bucketIndex).value;
		}
	}
	
	//Abstract methods
	public abstract void add();
	public abstract void remove();
	
	private class TableEntry<S, T>{
		private S key;
		private T value;
		
		
	}

}
