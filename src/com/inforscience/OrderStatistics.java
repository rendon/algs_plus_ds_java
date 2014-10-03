package com.inforscience;

import java.util.Random;

public class OrderStatistics {
    private int[] A;
    private Random random;
    public OrderStatistics(int[] data)
    {
        A = data;
        random = new Random();
    }

    private void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition(int[] A, int l, int r)
    {
        int n = r - l;
        int p = l + random.nextInt(n);
        swap(A, l, p);
        int x = A[l];
        int i = l;
        for (int j = l + 1; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, l, i);
        return i;
    }

    private int find(int[] A, int l, int r, int i)
    {
        if (A == null || r <= l || i < 0 || i > (r - l)) {
            return -1; // Or throw an exception ?
        }

        if (l >= r) {
            return -1;
        }

        if (l + 1 == r) {
            return A[l];
        }

        int m = partition(A, l, r);
        int k = m - l + 1;
        if (i == k) {
            return A[m];
        } else if (i < k) {
            return find(A, l, m, i);
        } else {
            return find(A, m + 1, r, i - k);
        }
    }

    public int findK(int k)
    {
        return find(A, 0, A.length, k);
    }

}
