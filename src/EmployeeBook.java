import java.util.*;

public class EmployeeBook {
    private final static int numberOfEmployees = 10;
    private Map<String, Employee> employees = new HashMap<>();

    public void addNewEmployee(Employee employee) throws RuntimeException {
        employees.put(employee.getFullName(), employee);
    }
//        for (int i = 0; i < employee.length; i++) {
//            if (employee[i] == null) {
//                employee[i] = new Employee(department, lastname, firstname, middlename, salary);
//                return;
//            }
//        }
//        throw new RuntimeException("Не возможно добавить пользователя. Ограничение по количеству");
//    }

//    public void removeEmployee(int id) throws RuntimeException {
//        for (int i = 0; i < employee.length; i++) {
//            if (employee[i] != null && employee[i].getId() == id) {
//                employee[i] = null;
//                return;
//            }
//        }
//        throw new RuntimeException("Не найден пользователь с ID: " + id);
//    }
//
    public void printEmployeeInfo() {
        employees.forEach((k, v) -> System.out.println(v));
    }
//
//    public void printByDepartment(int departmentId) {
//        for (Employee employees : employee) {
//            if (employees != null && employees.getDepartmentId() == departmentId) {
//                System.out.println(employees);
//            }
//        }
//    }
//
//    public void printById(int id) {
//        for (Employee employees : employee) {
//            if (employees != null && employees.getId() == id) {
//                System.out.println(employees);
//            }
//        }
//    }
//
//    public void printEmployeeInfoNoDep() {
//        for (Employee employees : employee) {
//            System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
//                    + " " + employees.getEmployeeFirstName() + " "
//                    + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
//        }
//    }
//
//    public float salaryCalculate() {
//        float total = 0;
//        for (Employee employees : employee) {
//            if (employees != null) {
//                total += employees.getEmployeeSalary();
//            }
//        }
//        return total;
//    }
//
//    public float salaryCalculate(int departmentId) {
//        float total = 0;
//        for (Employee employees : employee) {
//            if (employees != null && employees.getDepartmentId() == departmentId) {
//                total += employees.getEmployeeSalary();
//            }
//        }
//        return total;
//    }
//
    public Employee calculateMaxSalary() {
        var staff = employees.values();
        return Collections.max(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }
//
//    public double calculateMaxSalary(int departmentId) {
//        //Employee maxSalary = employee[0];
//        double maxSalary = 0.0;
//        for (var emp : employee.values()){
//            if(emp.getDepartmentId() == departmentId) {
//                maxSalary +=emp.getEmployeeSalary();
//            }
//        }
//     //   for (Employee employees : employee) {
//     //       if (employees != null && employees.getDepartmentId() == departmentId
//     //               && (maxSalary.getEmployeeSalary() < employees.getEmployeeSalary())) {
//     //           maxSalary = employees;
//     //       }
//     //   }
//        return maxSalary;
//    }
//
    public Employee calculateMinSalary() {
        var staff = employees.values();
        return Collections.min(staff, Comparator.comparingDouble(Employee::getEmployeeSalary));
    }
//
//    public Employee calculateMinSalary(int departmentId) {
//        Employee minSalary = employee[0];
//        for (Employee employees : employee) {
//            if (employees != null && employees.getDepartmentId() == departmentId &&
//                    (minSalary.getEmployeeSalary() > employees.getEmployeeSalary())) {
//                minSalary = employees;
//            }
//        }
//        return minSalary;
//    }
//
//    public float calculateAverageSalary() {
//        int avgSum = 0;
//        for (Employee employees : employee) {
//            if (employees != null) {
//                avgSum++;
//            }
//        }
//        return salaryCalculate() / avgSum;
//    }
//
//    public float calculateAverageSalary(int departmentId) {
//        float avgSum = 0;
//        int count = 0;
//        for (Employee employees : employee) {
//            if (employees != null && employees.getDepartmentId() == departmentId) {
//                avgSum += employees.getEmployeeSalary();
//                count++;
//            }
//        }
//        return avgSum / count;
//    }
//
//    public void printEmployeeFullName() {
//        for (Employee employees : employee) {
//            System.out.println("Ф.И.О сотрудника: " + employees.getEmployeeLastName() + " "
//                    + employees.getEmployeeFirstName() + " " + employees.getEmployeeMiddleName());
//
//        }
//    }
//
//    public float salaryIndexIncrease(float index) {
//        for (Employee employees : employee) {
//            if (employees != null) {
//                employees.setEmployeeSalary(employees.getEmployeeSalary()
//                        + (employees.getEmployeeSalary() / 100 * index));
//            }
//        }
//        return index;
//    }
//
//    public float salaryIndexIncrease(float index, int departmentId) {
//        for (Employee employees : employee) {
//            if (employees != null && employees.getDepartmentId() == departmentId) {
//                employees.setEmployeeSalary(employees.getEmployeeSalary()
//                        + (employees.getEmployeeSalary() / 100 * index));
//            }
//        }
//        return index;
//    }
//
//    public void findLessLimitCurrentSalary(float limitSalary) {
//        System.out.println("Ниже установленного порога:");
//        for (Employee employees : employee) {
//            if (employees != null && employees.getEmployeeSalary() < limitSalary) {
//                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
//                        + " " + employees.getEmployeeFirstName() + " "
//                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
//            }
//        }
//    }
//
//    public void findMoreLimitCurrentSalary(float limitSalary) {
//        System.out.println("Выше установленного порога:");
//        for (Employee employees : employee) {
//            if (employees != null && employees.getEmployeeSalary() >= limitSalary) {
//                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
//                        + " " + employees.getEmployeeFirstName() + " "
//                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
//            }
//        }
//    }
}
