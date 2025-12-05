package model;

public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String managerType;

    public Employee(String firstName, String lastName, String department, String managerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.managerType = managerType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getManagerType() {
        return managerType;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + managerType + " | " + department;
    }
}
