package sorting;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int j = leftIndex + 1 ; j < rightIndex+1; j++) {
			T key = array[j];
			int i = j -1 ;
			while ((i >= leftIndex) && (array[i].compareTo(key)) > 0){
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}		
	}

	@Override
	public void sort(T[] array) {
		for (int j = 0 ; j < array.length; j++) {
			T key = array[j];
			int i = j -1 ;
			while ((i >= j) && (array[i].compareTo(key)) > 0){
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}		
	}

}
