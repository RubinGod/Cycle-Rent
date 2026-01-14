package Controller;

import java.util.ArrayList;
import java.util.List;

public class SortByName {
    public void mergeSort(Object[][] data, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private void merge(Object[][] data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[][] L = new Object[n1][data[0].length];
        Object[][] R = new Object[n2][data[0].length];

        for (int i = 0; i < n1; ++i) L[i] = data[left + i];
        for (int j = 0; j < n2; ++j) R[j] = data[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Index 1 is the "Full Name" column
            if (L[i][1].toString().compareToIgnoreCase(R[j][1].toString()) <= 0) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) data[k++] = L[i++];
        while (j < n2) data[k++] = R[j++];
    }
}