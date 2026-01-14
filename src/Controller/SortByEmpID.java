package Controller;

import Model.Employee;
import java.util.ArrayList;
import java.util.List;

public class SortByEmpID {

    /**
     * Main method to call for sorting the employee list
     */
    public void sort(List<Employee> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        mergeSort(list, 0, list.size() - 1);
    }

    private void mergeSort(List<Employee> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide: Sort first and second halves
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // Conquer: Merge the sorted halves
            merge(list, left, mid, right);
        }
    }

    private void merge(List<Employee> list, int left, int mid, int right) {
        // Create temporary sub-lists
        List<Employee> leftSide = new ArrayList<>(list.subList(left, mid + 1));
        List<Employee> rightSide = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0;
        int k = left;

        // Compare and merge based on EmpID (String comparison)
        while (i < leftSide.size() && j < rightSide.size()) {
            if (leftSide.get(i).getEmpId().compareTo(rightSide.get(j).getEmpId()) <= 0) {
                list.set(k, leftSide.get(i));
                i++;
            } else {
                list.set(k, rightSide.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < leftSide.size()) {
            list.set(k, leftSide.get(i));
            i++;
            k++;
        }
        while (j < rightSide.size()) {
            list.set(k, rightSide.get(j));
            j++;
            k++;
        }
    }
}