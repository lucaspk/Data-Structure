package sorting;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] array, int left, int right) {
		for (int i = left; i < right; i++) {
			for (int j = left; j < right - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;

				}

			}
		}
	}

	@Override
	public void sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;

				}

			}
		}
	}
}
