package sorting;

public interface Sort<T> {

	public void sort(T[] array, int left, int right);
	
	public void sort(T[] array);
}
