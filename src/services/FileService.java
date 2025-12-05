package services;

import model.Employee;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static List<Employee> readApplicantsFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length >= 7) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String department = parts[5].trim();
                    String managerType = parts[6].trim().isEmpty() ? "Unknown" : parts[6].trim();

                    Employee emp = new Employee(firstName, lastName, department, managerType);
                    employees.add(emp);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }
}
