public class Main {
    public static void main(String[] args) {
        // int id = Employee.getDepartmentId();
        Employee[] employee = new Employee[10];
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
        employee[9] = new Employee(4, "Кузьмина",
                "Мария", "Максимовна", 33553.82f);

        for (int id = 0; id < employee.length - 1; id++) {
            System.out.println(employee[id]);
            // salaryCalculate(id, employee[id].getEmployeeSalary());
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryCalculate(employee));
        System.out.println("Сотрудник с минимальной зарплатой: " + calculateMinSalary(employee));
        System.out.println("Сотрудник с максимальной зарплатой: " + calculateMaxSalary(employee));
        System.out.println("Средняя зарплата за месяц составляет: " + calculateAverageSalary(employee));
    }

    public static float salaryCalculate(Employee[] employee) {
        float total = 0;
        for (int i = 0; i < employee.length; i++) {
            total += employee[i].getEmployeeSalary();
        }
        return total;
    }

    public static Employee calculateMaxSalary(Employee[] employee) {
        float maxSalary = employee[0].getEmployeeSalary();
        Employee salary = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (maxSalary < employee[i].getEmployeeSalary()) {
                maxSalary = employee[i].getEmployeeSalary();
                salary = employee[i];
            }
        }
        return salary;
    }

    public static Employee calculateMinSalary(Employee[] employee) {
        float minSalary = employee[0].getEmployeeSalary();
        Employee salary = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (minSalary > employee[i].getEmployeeSalary()) {
                minSalary = employee[i].getEmployeeSalary();
                salary = employee[i];
            }
        }
        return salary;
    }

    public static float calculateAverageSalary(Employee[] employee) {
        float avgSum = 0;
        for (int i = 0; i < employee.length; i++) {
            avgSum++;
        }
        return salaryCalculate(employee) / avgSum;
    }
}