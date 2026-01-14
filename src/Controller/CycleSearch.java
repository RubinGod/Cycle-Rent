package Controller;

import Model.Cycle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CycleSearch {
    public static Cycle searchById(ArrayList<Cycle> list, int searchId) {
        // Sort first because Binary Search requires a sorted list
        Collections.sort(list, Comparator.comparingInt(Cycle::getId));

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = list.get(mid).getId();

            if (midId == searchId) return list.get(mid);
            if (midId < searchId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}