/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khadk
 */
public class SortBySalary {

    public void sort(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        if (rowCount <= 1) return;

        // 1. Extract data from the model into an array
        Object[][] data = new Object[rowCount][model.getColumnCount()];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                data[i][j] = model.getValueAt(i, j);
            }
        }

        // 2. Perform Merge Sort
        mergeSort(data, 0, rowCount - 1);

        // 3. Clear and refill the model with sorted data
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    private void mergeSort(Object[][] data, int left, int right) {
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

        Object[][] L = new Object[n1][];
        Object[][] R = new Object[n2][];

        for (int i = 0; i < n1; ++i) L[i] = data[left + i];
        for (int j = 0; j < n2; ++j) R[j] = data[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Index 3 is Monthly Salary in your jTable3
            double s1 = Double.parseDouble(L[i][3].toString());
            double s2 = Double.parseDouble(R[j][3].toString());

            if (s1 <= s2) {
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