package com.sorting;

/*
 * it works with the in place approach, ie using the constant memory.
 * with this approach first we need to select an element called pivot element.
 * Move the elements less than pivot to left and more to right of it.
 * and repeat the mechanism till it is no more possible.
 * best and average o(n log n), worst is o(n2). worst will be when the array was already sorted, so we can randomize the array before operating on it.
 */

public class QuickSort {

	public static void main(String[] args) {

		int sort[] = { -3, 7, 8, 6, 4, 3, 2, 1, 27, 9, -2 };
		quickSort(sort, 0, sort.length - 1);
		for (int n : sort) {
			System.out.println(n);
		}
	}

	public static void quickSort(int arr[], int start, int end) {

		if (start < end) {
			int pivotIndex = getPivotIndex(arr, start, end);
			quickSort(arr, 0, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	public static int getPivotIndex(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				if(i != pIndex)
					swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, end, pIndex);
		return pIndex;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;
	}

}
