package services;

import model.Employee;
import java.util.List;

public class SearchService {

    public static Employee searchByName(List<Employee> employees, String name) {
        String lower = name.toLowerCase();

        for (Employee e : employees) {
            if (e.getFullName().toLowerCase().contains(lower)) {
                return e;
            }
        }
        return null;
    }
}
