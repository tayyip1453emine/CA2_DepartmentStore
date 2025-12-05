package controller;

import model.Employee;
import model.TreeNode;
import services.InputService;
import services.SearchService;
import services.SortingService;
import services.TreeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuController {

    public static void startMenu(List<Employee> employees) {

        SortingService.mergeSort(employees);

        boolean running = true;

        while (running) {
            System.out.println("\n1. Search Employee");
            System.out.println("2. Add Employee");
            System.out.println("3. Create Binary Tree");
            System.out.println("4. Exit");

            String choice = InputService.getString("Select option: ");

            switch (choice) {
                case "1":
                    String name = InputService.getString("Enter name: ");
                    Employee result = SearchService.searchByName(employees, name);
                    if (result != null) {
                        System.out.println("Found: " + result);
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case "2":
                    addEmployeeWithValidation(employees);
                    break;

                case "3":
                    TreeNode root = TreeService.buildLevelOrderTree(employees);
                    if (root == null) {
                        System.out.println("No employees to build tree.");
                    } else {
                        System.out.println("Level-order traversal:");
                        TreeService.printLevelOrder(root);
                        System.out.println("Tree height: " + TreeService.height(root));
                        System.out.println("Total nodes: " + TreeService.countNodes(root));
                    }
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addEmployeeWithValidation(List<Employee> employees) {
        String firstName = InputService.getString("First name: ");
        String lastName = InputService.getString("Last name: ");

        Set<String> validDepartments = getDepartments(employees);
        Set<String> validManagerTypes = getManagerTypes(employees);

        String department;
        while (true) {
            department = InputService.getString("Department " + validDepartments + ": ");
            if (validDepartments.contains(department)) {
                break;
            }
            System.out.println("Invalid department. Please choose from the list.");
        }

        String managerType;
        while (true) {
            managerType = InputService.getString("Manager Type " + validManagerTypes + ": ");
            if (validManagerTypes.contains(managerType)) {
                break;
            }
            System.out.println("Invalid manager type. Please choose from the list.");
        }

        employees.add(new Employee(firstName, lastName, department, managerType));
        SortingService.mergeSort(employees);
        System.out.println("Employee added.");
    }

    private static Set<String> getDepartments(List<Employee> employees) {
        Set<String> departments = new HashSet<>();
        for (Employee e : employees) {
            if (e.getDepartment() != null && !e.getDepartment().isEmpty()) {
                departments.add(e.getDepartment());
            }
        }
        return departments;
    }

    private static Set<String> getManagerTypes(List<Employee> employees) {
        Set<String> managers = new HashSet<>();
        for (Employee e : employees) {
            if (e.getManagerType() != null && !e.getManagerType().isEmpty() && !"Unknown".equals(e.getManagerType())) {
                managers.add(e.getManagerType());
            }
        }
        return managers;
    }
}
