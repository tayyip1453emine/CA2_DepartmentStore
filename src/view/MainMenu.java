package view;

import model.Employee;
import services.FileService;
import java.util.List;

public class MainMenu {
    public static void main(String[] args) {

        String fileName = "Applicants_Form.txt";

        List<Employee> employees = FileService.readApplicantsFile(fileName);

        System.out.println("Loaded Employees: " + employees.size());
        int limit = Math.min(5, employees.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(employees.get(i));
        }
    }
}

