public class EmployeeBook {
    private final Employee[] employee;

    public EmployeeBook(int sizeEmployeeBook){
        this.employee = new Employee[sizeEmployeeBook];
    }
    public void newEmployee (Employee[] employee, int department, String lastname,
                             String firstname, String middlename, float salary) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(department, lastname, firstname, middlename, salary);
                return;
            }
        }
    }

    public void printEmployeeInfo(Employee[] employee){
        for (Employee employees : employee) {
            System.out.println(employees);
        }
    }
    public void printEmployeeInfoNoDep(Employee[] employee){
        for (Employee employees : employee) {
            System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                    + " " + employees.getEmployeeFirstName() + " "
                    + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
        }
    }
    public float salaryCalculate(Employee[] employee) {
        float total = 0;
        for (Employee employees : employee) {
            total += employees.getEmployeeSalary();
        }
        return total;
    }

    public Employee calculateMaxSalary(Employee[] employee) {
        Employee maxSalary = employee[0];
        for (Employee employees : employee) {
            if (maxSalary.getEmployeeSalary() < employees.getEmployeeSalary()) {
                maxSalary = employees;
            }
        }
        return maxSalary;
    }

    public Employee calculateMinSalary(Employee[] employee) {
        Employee minSalary = employee[0];
        for (Employee employees : employee) {
            if (minSalary.getEmployeeSalary() > employees.getEmployeeSalary()) {
                minSalary = employees;
            }
        }
        return minSalary;
    }

    public float calculateAverageSalary(Employee[] employee) {
        float avgSum = 0;
        for (int i = 0; i < employee.length; i++) {
            avgSum++;
        }
        return salaryCalculate(employee) / avgSum;
    }

    public void printEmployeeFullName(Employee[] employee) {
        for (Employee employees : employee) {
            System.out.println("Ф.И.О сотрудника: " + employees.getEmployeeLastName() + " "
                    + employees.getEmployeeFirstName() + " " + employees.getEmployeeMiddleName());

        }
    }

    public float salaryIndexIncrease(Employee[] employee, float index) {
        for (Employee employees : employee) {
            employees.setEmployeeSalary(employees.getEmployeeSalary()
                    + (employees.getEmployeeSalary() / 100 * index));
        }
        return index;
    }
    public Employee[] checkDepartment(Employee[] employee, int departmentId) {
        int filterDepartmentId = 0; //отфильтруем количество совпадений
        int counterDepertmentId = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartmentId() == departmentId) {
                filterDepartmentId ++;
            }
        }
        Employee[] chooseDepartmentId = new Employee[filterDepartmentId];
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartmentId() == departmentId) {
                chooseDepartmentId[counterDepertmentId] = employee[i];
                counterDepertmentId++;
            }
        }
        return chooseDepartmentId;
    }

    public void findLessLimitCurrentSalary(Employee[] employee, float limitSalary) {
        System.out.println("Ниже установленного порога:");
        for (Employee employees : employee) {
            if (employees.getEmployeeSalary() < limitSalary) {
                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                        + " " + employees.getEmployeeFirstName() + " "
                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
            }
        }
    }
    public void findMoreLimitCurrentSalary(Employee[] employee, float limitSalary) {
        System.out.println("Выше установленного порога:");
        for (Employee employees : employee) {
            if (employees.getEmployeeSalary() >= limitSalary) {
                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                        + " " + employees.getEmployeeFirstName() + " "
                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
            }
        }
    }
}
