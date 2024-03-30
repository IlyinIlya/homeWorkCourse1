import java.util.Arrays;

public class Main {
    private final static int numberOfEmployees = 10;
    public static void main(String[] args) {
        Employee[] employee = new Employee[numberOfEmployees];
        employee[0] = new Employee(1, "Булгакова",
                "София", "Леоновна", 32890.45f);
        employee[1] = new Employee(2, "Родина",
                "Александра", "Артемьевна", 31575.25f);
        employee[2] = new Employee(3, "Зайцева",
                "Елизавета", "Ивановна", 34099.09f);
        employee[3] = new Employee(4, "Демин",
                "Матвей", "Андреевич", 27829.36f);
        employee[4] = new Employee(5, "Румянцев",
                "Илья", "Никитич", 32547.41f);
        employee[5] = new Employee(2, "Лопатин",
                "Тимофей", "Викторович", 30776.91f);
        employee[6] = new Employee(1, "Котова",
                "Сафия", "Михайловна", 29791.22f);
        employee[7] = new Employee(5, "Федосеев",
                "Алексей", "Львович", 35112.69f);
        employee[8] = new Employee(4, "Смирнов",
                "Александр", "Александрович", 33001.15f);
        employee[9] = new Employee(3, "Кузьмина",
                "Мария", "Максимовна", 33553.82f);
        // Вывод информации по всем сотрудникам
        printEmployeeInfo(employee);
        // Расчет общей суммы по ЗП, поиск минимальной/максимальной ЗП, расчет средней ЗП
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryCalculate(employee));
        System.out.println("Сотрудник с минимальной зарплатой: " + calculateMinSalary(employee));
        System.out.println("Сотрудник с максимальной зарплатой: " + calculateMaxSalary(employee));
        System.out.println("Средняя зарплата за месяц составляет: " + calculateAverageSalary(employee));
        // Вывод информации: ФИО сотрудников
        printEmployeeFullName(employee);
        // Расчет индексирования ЗП
        System.out.println("Если процент повышения зарплаты: " + salaryIndexIncrease(employee, 7) + "%, то:");
        printEmployeeInfo (employee);
        // Поиск минимальной/максимальной ЗП при задании фильтра по отделам
        int departmentID = 5;
        System.out.println("В отделе № " + departmentID + " минимальная зарплата сотрудника: "
                + calculateMinSalary(checkDepartment(employee, departmentID)));
        System.out.println("В отделе № " + departmentID + " максимальная зарплата сотрудника: "
                + calculateMaxSalary(checkDepartment(employee, departmentID)));
        // Расчет суммы ЗП при задании фильтра по отделу
        System.out.println("Сумма затрат на зарплаты в отделе № " + departmentID + " составляет: "
                + salaryCalculate(checkDepartment(employee, departmentID)));
        // Расчет средней ЗП при задании фильтра по отделу
        System.out.println("Средняя зарплата в отделе № " + departmentID + " составляет: "
                + calculateAverageSalary(checkDepartment(employee, departmentID)));
        // Расчет индексирования ЗП при задании фильтра по отделу
        System.out.println("Если процент повышения зарплаты: "
                + salaryIndexIncrease(checkDepartment(employee, departmentID), 9) + "%, то:");
        printEmployeeInfo(checkDepartment(employee, departmentID));
        // Вывод информации по всем сотрудником, исключая номер отдела
        printEmployeeInfoNoDep(checkDepartment(employee, departmentID));
        // Вывод информации по сотрудникам с ЗП меньше лимита
        float limitSalary = 33000.50f;
        findLessLimitCurrentSalary(employee, limitSalary);
        // Вывод информации по сотрудникам с ЗП меньше лимита
        findMoreLimitCurrentSalary(employee, limitSalary);

    }

    public static void printEmployeeInfo(Employee[] employee){
        for (Employee employees : employee) {
            System.out.println(employees);
        }
    }
    public static void printEmployeeInfoNoDep(Employee[] employee){
        for (Employee employees : employee) {
            System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                    + " " + employees.getEmployeeFirstName() + " "
                    + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
        }
    }
    public static float salaryCalculate(Employee[] employee) {
        float total = 0;
        for (Employee employees : employee) {
            total += employees.getEmployeeSalary();
        }
        return total;
    }

    public static Employee calculateMaxSalary(Employee[] employee) {
        Employee maxSalary = employee[0];
        for (Employee employees : employee) {
            if (maxSalary.getEmployeeSalary() < employees.getEmployeeSalary()) {
                maxSalary = employees;
            }
        }
        return maxSalary;
    }

    public static Employee calculateMinSalary(Employee[] employee) {
        Employee minSalary = employee[0];
        for (Employee employees : employee) {
            if (minSalary.getEmployeeSalary() > employees.getEmployeeSalary()) {
                minSalary = employees;
            }
        }
        return minSalary;
    }

    public static float calculateAverageSalary(Employee[] employee) {
        float avgSum = 0;
        for (int i = 0; i < employee.length; i++) {
            avgSum++;
        }
        return salaryCalculate(employee) / avgSum;
    }

    public static void printEmployeeFullName(Employee[] employee) {
        for (Employee employees : employee) {
            System.out.println("Ф.И.О сотрудника: " + employees.getEmployeeLastName() + " "
                    + employees.getEmployeeFirstName() + " " + employees.getEmployeeMiddleName());

        }
    }

    public static float salaryIndexIncrease(Employee[] employee, float index) {
        for (Employee employees : employee) {
            employees.setEmployeeSalary(employees.getEmployeeSalary()
                    + (employees.getEmployeeSalary() / 100 * index));
        }
        return index;
    }
    public static Employee[] checkDepartment(Employee[] employee, int departmentId) {
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

    public static void findLessLimitCurrentSalary(Employee[] employee, float limitSalary) {
        System.out.println("Ниже установленного порога:");
        for (Employee employees : employee) {
            if (employees.getEmployeeSalary() < limitSalary) {
                System.out.println("ID: " + employees.getId() + " | ФИО: " + employees.getEmployeeLastName()
                        + " " + employees.getEmployeeFirstName() + " "
                        + employees.getEmployeeMiddleName() + " | Зарплата: " + employees.getEmployeeSalary());
            }
        }
    }
    public static void findMoreLimitCurrentSalary(Employee[] employee, float limitSalary) {
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