


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sorting {
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for (j = i - 1; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	public static void selectionSort(int[] a) {
		//
	}

	public static int bubbleSort(int[] a) {
		int i, j, temp;
		boolean swapped;
		int count = 0;
		for (i = 0; i < a.length - 1; i++) {
			for (j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					count++;
				}
			}
		}
		return count;

	}

	public static void flagbubbleSort(int[] a) {
		//
	}

	public static int partition(int a[], int i, int j) {
		int pivot = a[i]; // leftmost value
		int p = i;
		int temp;
		for (int k = i + 1; k <= j; k++) { // find the element<pivot
			if (a[k] < pivot) {
				p = p + 1;
				temp = a[p];
				a[p] = a[k];
				a[k] = temp;
			}
		}
		temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		return p;
	}

	public static void internalQuickSort(int[] a, int m, int n) {
		int p;
		if (m >= n) {
			return;
		}
		p = partition(a, m, n);
		internalQuickSort(a, m, p - 1); // left part
		internalQuickSort(a, p + 1, n); // right part
	}

	public static void quickSort(int[] a) {
		internalQuickSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a) {
		int[] temp = new int[a.length];
		internalMergeSort(a, temp, 0, a.length - 1);
	}

	private static void internalMergeSort(int[] a, int[] temp, int m, int n) {
		if (m < n) {
			int middle = (m + n) / 2;
			internalMergeSort(a, temp, m, middle);
			internalMergeSort(a, temp, middle + 1, n);
			merge(a, temp, m, middle, middle + 1, n);

		}
	}

	private static void merge(int[] a, int[] temp, int m, int p, int q, int n) {
		int t = m;
		int numElements = n - m + 1;
		while (m <= p && q <= n) {
			if (a[m] < a[q]) {
				temp[t++] = a[m++];
			} else {
				temp[t++] = a[q++];
			}

		}
		while (m <= p) {
			temp[t++] = a[m++];
		}
		while (q <= n) {
			temp[t++] = a[q++];
		}
		for (int i = 0; i < numElements; i++, n--) {
			a[n] = temp[n];
		}

	}

	private static int total;

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private static void heapify(int[] arr, int i) {
		int lft = i * 2;
		int rgt = lft + 1;
		int grt = i;
		if (lft <= total && arr[lft] > arr[grt])
			grt = lft;
		if (rgt <= total && arr[rgt] > arr[grt])
			grt = rgt;
		if (grt != i) {
			swap(arr, i, grt);
			heapify(arr, grt);
		}
	}

	public static void heapSort(int[] arr) {
		total = arr.length - 1;// ������ ����

		for (int i = total / 2; i >= 0; i--)
			heapify(arr, i);

		for (int i = total; i > 0; i--) {
			swap(arr, 0, i);
			total--;
			heapify(arr, 0);
		}
	}

	public static int get_max_val(int arr[]) {
		int max_val = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max_val) {
				max_val = arr[i];
			}
		}
		return max_val;
	}

	//ä����
	static void countSortNew(int arr[], int exp) {
		int max = 0;
		for(int x : arr) {
			max = Math.max(x, max);
		}
		
		int[] count = new int[max+1];
	    int[] result = new int[arr.length];
	    
	    // data�� count �迭�� �ε����� �ش��ϴ� ���ڵ��� �� �� �ִ��� ī��Ʈ.
	    for(int x: arr) {
	      count[x]++;
	    }
	    
	    // count �迭 ���������� ����.
	    for(int i = 1; i <= max; i++) {
	      count[i] += count[i-1];
	    }
	    
	    // data �迭 �ڿ������� ���鼭 result�� ������ �� �ֱ�.
	    for(int i = arr.length-1; i>=0 ; i--) {
	      count[arr[i]]--;
	    result[count[arr[i]]] = arr[i];
	    }
	    System.out.println(Arrays.toString(result));
	}
	
	
	static void countSort(int arr[], int exp) {
		int result[] = new int[arr.length];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < arr.length; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (i = arr.length - 1; i >= 0; i--) {
			result[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}

	}
	static void radixSort(int arr[]) {
		int m = get_max_val(arr);
		//1�� �ڸ������� ���� ū �ڸ�������
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, exp);
		}

	}

	static void bucketSort(int[] a) {
		int maxVal=get_max_val(a);
		int[] bucketArr = new int[maxVal + 1];
		// ��Ŷ �ʱ�ȭ
		for (int i = 0; i < bucketArr.length; i++) {
			bucketArr[i] = 0;
		}
		//������ ���� ���ҵ��� ���� ���
		for (int i = 0; i < a.length; i++) {
			bucketArr[a[i]]++;
		}
		
		int outPos = 0;
		for (int i = 0; i < bucketArr.length; i++) {
			for (int j = 0; j < bucketArr[i]; j++) {
				a[outPos++] = i;
			}
		}
	}

	public static void shellSort(int[] array) {
		int interval = array.length; 
		while (interval > 1)// 
		{
			interval = 1 + interval / 3;// 
			for (int i = 0; i < interval; i++) {
				intervalSort(array, i, interval);// 
			}
		}
	}

	public static void intervalSort(int[] a, int i, int interval) {
		// ���긮��Ʈ�� ���� ���ķ� �����ϴ� shellSort()�� �����Լ�
		int j = i + interval; //
		while (j < a.length) {
			int n = a[j]; // ���긮��Ʈ�� ���ο� ����
			int k = j; // n���� ū ���Ҵ� interval��ŭ ���������� �̵�
			boolean move = true;
			while (move) {
				if (a[k - interval] <= n)
					move = false;
				else {
					a[k] = a[k - interval];
					k = k - interval;
					if (k == i)
						move = false;
				}
			}
			a[k] = n;// �̵��ؼ� ���� �ڸ��� ����
			j = j + interval;// ���� ���긮��Ʈ ������ �ε���
		}
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

public class Quiz_1 {
	private static int SIZE = 150000;
	private static final int MAX = 1000;

	public static void main(String[] args) {

		int arr[] = new int[SIZE];
		int tmparr[] = new int[SIZE];
		int count = 0;
		
		// 1. Randomly generated Input Data
		Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			arr[i] = r.nextInt(MAX); // 0~MAX-1
		}
		Sorting.printArray(arr);
		
		// 2. Sorted Input Data. �����͸� �����ϰ� �� �����͸� �Էµ����ͷ� ���
		Sorting.insertionSort(arr);
		
		
//		// 3. �����͸� ������
		for(int i=0;i<SIZE;i++) {
			tmparr[i]=arr[i];
		}
		for(int i=0;i<SIZE;i++) {
			arr[i]=tmparr[SIZE-1-i];
		}
		
		Sorting.printArray(arr);
		long start = System.currentTimeMillis();
//		Sorting.insertionSort(arr);
//		Sorting.selectionSort(arr);
//		count=Sorting.bubbleSort(arr);
//		Sorting.flagbubbleSort(arr);
		Sorting.quickSort(arr);
//		Sorting.heapSort(arr);
		//Sorting.mergeSort(arr);
//		Sorting.radixSort(arr);
//		Sorting.bucketSort(arr);
//		Sorting.countSort(arr,1);
//		Sorting.countSortNew(arr,1);
//		Sorting.shellSort(arr);
		//Arrays.sort(arr);
		long end = System.currentTimeMillis();
		System.out.println(" Execution Time =" + (end - start));
//		Sorting.printArray(arr);
	}

}
