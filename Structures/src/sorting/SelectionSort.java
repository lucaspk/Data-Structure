package sorting;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			int minimo = i;
			for (int j = i+1; j <= rightIndex; j++) {
				if(array[minimo].compareTo(array[j]) > 0)
					minimo = j;
			}
			T temp = array[i];
			array[i] = array[minimo];
			array[minimo] = temp;
			}
		}
	

	@Override
	public void sort(T[] array) {
		
	}

}
