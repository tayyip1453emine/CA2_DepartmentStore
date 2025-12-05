package services;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

public class SortingService {

    public static void mergeSort(List<Employee> employees) {
        if (employees == null || employees.size() <= 1) {
            return;
        }
        mergeSort(employees, 0, employees.size() - 1);
    }

    private static void mergeSort(List<Employee> employees, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(employees, left, mid);
        mergeSort(employees, mid + 1, right);
        merge(employees, left, mid, right);
    }

    private static void merge(List<Employee> employees, int left, int mid, int right) {
        List<Employee> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            String nameI = employees.get(i).getFullName().toLowerCase();
            String nameJ = employees.get(j).getFullName().toLowerCase();

            if (nameI.compareTo(nameJ) <= 0) {
                temp.add(employees.get(i));
                i++;
            } else {
                temp.add(employees.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(employees.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(employees.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            employees.set(left + k, temp.get(k));
        }
    }
}
