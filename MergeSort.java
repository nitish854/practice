package com.sorting;

/*
 * It do not follow in-place mechanism, memory required is n.
 * it deals with dividing an array to sub array till it can no longer divided.
 * then it is merged in sorted array. It uses recursion to achieve it.
 * o(n log n).
 */

public class MergeSort {

	static int num = 0;
	
	public static void main(String[] args) {

		int sort[] = { 9, 5, 3, 7, 11, 2, 14, 6, 13 };
		sort = mergeSort(sort);
		for (int n : sort) {
			System.out.print(n + " ");
		}
	}

	public static int[] mergeSort(int[] arr) {

		num++;
		
		int length = arr.length;
		if (arr.length < 2) {
			return arr;
		}
		int mid = length / 2;
		int left[] = new int[0 + mid];
		int right[] = new int[length - mid];
		int i;
		for (i = 0; i < left.length; i++) {
			left[i] = arr[i];
		}
		for (i = 0; i < right.length; i++) {
			right[i] = arr[mid + i];
		}

		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {

		int nL = left.length;
		int nR = right.length;
		int merged[] = new int[nL + nR];
		int i = 0, j = 0, k = 0;

		while (i < nL && j < nR) {
			if (left[i] > right[j]) {
				merged[k] = right[j];
				j++;
			} else {
				merged[k] = left[i];
				i++;
			}
			k++;
		}

		while (i < nL) {
			merged[k] = left[i];
			i++;
			k++;
		}
		while (j < nR) {
			merged[k] = right[j];
			j++;
			k++;
		}

		return merged;
	}

}
