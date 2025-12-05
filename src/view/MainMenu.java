package view;

import model.Employee;
import services.FileService;
import controller.MenuController;
import java.util.List;

public class MainMenu {
    public static void main(String[] args) {

        String fileName = "Applicants_Form.txt";

        List<Employee> employees = FileService.readApplicantsFile(fileName);

        MenuController.startMenu(employees);
    }
}
