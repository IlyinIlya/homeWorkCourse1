import java.util.Objects;

public class Employee {
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMiddleName;
    private static int departmentId;
    private int employeeSalary;

    public Employee(int departmentId, String employeeLastName, String employeeFirstName,
                    String employeeMiddleName, int employeeSalary){
        Employee.departmentId = departmentId;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeSalary = employeeSalary;
    }
// Геттеры
    public String getEmployeeLastName() {
        return this.employeeLastName;
    }
    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }
    public String getEmployeeMiddleName() {
        return this.employeeMiddleName;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public int getEmployeeSalary() {
        return this.employeeSalary;
    }
// Сеттеры
    public void setEmployeeLastName() {
        this.employeeLastName = employeeLastName;
    }
    public void setEmployeeFirstName() {
        this.employeeFirstName = employeeFirstName;
    }
    public void setEmployeeMiddleName() {
        this.employeeMiddleName = employeeMiddleName;
    }
    public void setEmployeeSalary() {
        this.employeeSalary = employeeSalary;
    }

//String
    public String toString(){
    return departmentId + " " + employeeLastName + " " + employeeFirstName + " "
            + employeeMiddleName + " " + employeeSalary;
    }
// Equals и hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emploee = (Employee) o;
        return employeeSalary == emploee.employeeSalary && Objects.equals(employeeFirstName,
                emploee.employeeFirstName) && Objects.equals(employeeLastName, emploee.employeeLastName)
                && Objects.equals(employeeMiddleName, emploee.employeeMiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, employeeMiddleName, employeeSalary);
    }
}
