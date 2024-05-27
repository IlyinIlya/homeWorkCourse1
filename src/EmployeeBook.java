import java.util.*;

public class EmployeeBook {
    private Map<String, Employee> employees = new LinkedHashMap<>();

    public void addNewEmployee(Employee employee) {
        employees.put(employee.getFullName(), employee);
    }

    public void removeEmployee(int id) throws RuntimeException {
        for (var emp : employees.values()) {
            if (!emp.getFullName().isEmpty() && emp.getId() == id) {
                employees.remove(emp.getFullName());
                return;
            }
        }
        throw new RuntimeException("Не найден пользователь с ID: " + id);
    }

    public void printEmployeeInfo() {
        employees.forEach((k, v) -> System.out.println(v));
    }

    public void printByDepartment(int departmentId) {
        for (var emp : employees.values()) {
            if (emp.getDepartmentId() == departmentId) {
                System.out.println(emp);
            }
        }
    }

    public void printById(int id) {
        for (var emp : employees.values()) {
            if (emp.getId() == id) {
                System.out.println(emp);
            }
        }
    }

    //
    public void printEmployeeInfoNoDep() {
        for (var emp : employees.values()) {
            System.out.println("ID: " + emp.getId() + " | ФИО: " + emp.getEmployeeLastName()
                    + " " + emp.getEmployeeFirstName() + " "
                    + emp.getEmployeeMiddleName() + " | Зарплата: " + emp.getEmployeeSalary());
        }
    }

    //
    public float salaryCalculate() {
        float total = 0;
        for (var emp : employees.values()) {
            total += emp.getEmployeeSalary();
        }
        return total;
    }

    public float salaryCalculate(int departmentId) {
        float total = 0;
        for (var emp : employees.values()) {
            if (emp.getDepartmentId() == departmentId) {
                total += emp.getEmployeeSalary();
            }
        }
        return total;
    }

    public Employee calculateMaxSalary() {
        var staff = employees.values();
        return Collections.max(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }

    public Employee calculateMaxSalary(int departmentId) {
        var staff = new ArrayList<>(employees.values());
        staff.removeIf(emp -> emp.getDepartmentId() != departmentId);
        return Collections.max(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }

    public Employee calculateMinSalary() {
        var staff = employees.values();
        return Collections.min(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }

    public Employee calculateMinSalary(int departmentId) {
        var staff = new ArrayList<>(employees.values());
        staff.removeIf(emp -> emp.getDepartmentId() != departmentId);
        return Collections.min(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }

    public float calculateAverageSalary() {
        return salaryCalculate() / employees.size();
    }

    public float calculateAverageSalary(int departmentId) {
        float avgSum = 0;
        int count = 0;
        for (var emp : employees.values()) {
            if (emp.getDepartmentId() == departmentId) {
                avgSum += emp.getEmployeeSalary();
                count++;
            }
        }
        return avgSum / count;
    }

    public void printEmployeeFullName() {
        for (var emp : employees.values()) {
            System.out.println("Ф.И.О сотрудника: " + emp.getFullName());

        }
    }

    public float salaryIndexIncrease(float index) {
        for (var emp : employees.values()) {
            emp.setEmployeeSalary(emp.getEmployeeSalary()
                    + (emp.getEmployeeSalary() / 100 * index));
        }
        return index;
    }

    public float salaryIndexIncrease(float index, int departmentId) {
        for (var emp : employees.values()) {
            if (emp.getDepartmentId() == departmentId) {
                emp.setEmployeeSalary(emp.getEmployeeSalary()
                        + (emp.getEmployeeSalary() / 100 * index));
            }
        }
        return index;
    }

    public void findLessLimitCurrentSalary(float limitSalary) {
        System.out.println("Ниже установленного порога:");
        for (var emp : employees.values()) {
            if (emp.getEmployeeSalary() < limitSalary) {
                System.out.println("ID: " + emp.getId() + " | ФИО: " + emp.getEmployeeLastName()
                        + " " + emp.getEmployeeFirstName() + " "
                        + emp.getEmployeeMiddleName() + " | Зарплата: " + emp.getEmployeeSalary());
            }
        }
    }

    public void findMoreLimitCurrentSalary(float limitSalary) {
        System.out.println("Выше установленного порога:");
        for (var emp : employees.values()) {
            if (emp.getEmployeeSalary() >= limitSalary) {
                System.out.println("ID: " + emp.getId() + " | ФИО: " + emp.getEmployeeLastName()
                        + " " + emp.getEmployeeFirstName() + " "
                        + emp.getEmployeeMiddleName() + " | Зарплата: " + emp.getEmployeeSalary());
            }
        }
    }
}
